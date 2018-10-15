package com.example.core.file.pdf.pdfbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;

public class PdfEditor {
    private static String FILENAME = "E://misc/testworkspace/java-gradle/src/main/java/com/example/core/file/pdf/Maya_classic_8x10.pdf";
    private static String NEWFILENAME = "E://misc/testworkspace/java-gradle/src/main/java/com/example/core/file/pdf/Maya_classic_updated.pdf";
    private static final Pattern TOKEN_PATTERN = Pattern.compile("[0-9a-f]{64}+|[0-9A-F]{40}+");

    public static void main(final String[] args) throws IOException {

        /*File file = new File(FILENAME);
        PDDocument document = PDDocument.load(file);
        replaceText(document, "Cuctom Text Goes Here", "Custom Text Goes Here");
        document.save("NEWFILENAME");*/

        substituteTokens();
    }

    public static PDDocument replaceText(PDDocument document, String searchString, String replacement)
            throws IOException {
        final PDPage page = document.getPage(0);
        PDFStreamParser parser = new PDFStreamParser(page);
        parser.parse();
        List tokens = parser.getTokens();
        for (int j = 0; j < tokens.size(); j++) {
            Object next = tokens.get(j);
            if (next instanceof Operator) {
                Operator op = (Operator) next;
                // Tj and TJ are the two operators that display strings in a PDF
                if (op.getName().equals("Tj")) {
                    // Tj takes one operator and that is the string to display so lets update that operator
                    COSString previous = (COSString) tokens.get(j - 1);
                    String string = previous.getString();
                    string = string.replaceFirst(searchString, replacement);
                    previous.setValue(string.getBytes());
                    System.out.println(previous.getString());
                } else if (op.getName().equals("TJ")) {
                    COSArray previous = (COSArray) tokens.get(j - 1);
                    for (int k = 0; k < previous.size(); k++) {
                        Object arrElement = previous.getObject(k);
                        if (arrElement instanceof COSString) {
                            COSString cosString = (COSString) arrElement;
                            String string = cosString.getString();
                            string = StringUtils.replaceOnce(string, searchString, replacement);
                            cosString.setValue(string.getBytes());
                        }
                    }
                }
            }
        }
        // now that the tokens are updated we will replace the page content stream.
        PDStream updatedStream = new PDStream(document);
        OutputStream out = updatedStream.createOutputStream();
        ContentStreamWriter tokenWriter = new ContentStreamWriter(out);
        tokenWriter.writeTokens(tokens);
        page.setContents(updatedStream);
        out.close();
        return document;
    }

    // =================================================

    private static void substituteTokens() throws IOException {
        PDDocument document = null;
        try (InputStream inputStream = new FileInputStream(new File(FILENAME))) {
            try {
                document = PDDocument.load(inputStream);
                if (document.isEncrypted()) {
                    throw new IOException("Error: Encrypted documents are not supported for this example.");
                }
                for (PDPage page : document.getPages()) {
                    PDFStreamParser parser = new PDFStreamParser(page);
                    parser.parse();
                    List<Object> tokens = parser.getTokens();
                    List<Object> newTokens = new ArrayList<Object>();
                    for (Object token : tokens) {
                        if (token instanceof Operator) {
                            Operator op = (Operator) token;
                            if (op.getName().equals("TJ") || op.getName().equals("Tj")) {
                                Object argumentToken = newTokens.get(newTokens.size() - 1);
                                if (argumentToken instanceof COSString) {
                                    COSString stringToken = (COSString) argumentToken;
                                    Collection<String> tokenStrings = collectTokens(stringToken.getString());

                                    System.out.println(stringToken.getString());
                                    if (!tokenStrings.isEmpty()) {
                                        String detokenizedString = substituteTokens(stringToken.getString(),
                                                tokenStrings, "static replacement");
                                        if (detokenizedString != null) {
                                            stringToken.setValue(detokenizedString.getBytes());
                                        }
                                    }
                                }
                            }
                        }
                        newTokens.add(token);
                    }
                    PDStream newContents = new PDStream(document);
                    OutputStream out = newContents.createOutputStream(COSName.FLATE_DECODE);
                    ContentStreamWriter writer = new ContentStreamWriter(out);
                    writer.writeTokens(newTokens);
                    out.close();
                    page.setContents(newContents);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(NEWFILENAME));
                document.save(fileOutputStream);
            } finally {
                if (document != null) {
                    document.close();
                }
                inputStream.close();
            }
        }
    }

    public static Collection<String> collectTokens(String tokenizedText) throws IOException {
        Set<String> tokens = new HashSet<String>();
        Matcher matcher = TOKEN_PATTERN.matcher(tokenizedText);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }

    public static String substituteTokens(String text, Collection<String> tokens, String staticReplacementText) {
        String result = text;
        for (String token : tokens) {
            result = result.replace(token, staticReplacementText);
        }
        return result;
    }
}
