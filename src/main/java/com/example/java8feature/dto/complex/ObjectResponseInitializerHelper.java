package com.example.java8feature.dto.complex;

import java.util.Arrays;
import java.util.List;

public class ObjectResponseInitializerHelper {
    public static List<ObjectResponse> getObjectResponseList() {

        ObjectQuestion objectQuestion1 = new ObjectQuestion(1L, "OBJECT_QUESTION1");
        ObjectQuestion objectQuestion2 = new ObjectQuestion(2L, "OBJECT_QUESTION2");
        ObjectQuestion objectQuestion3 = new ObjectQuestion(3L, "OBJECT_QUESTION3");
        ObjectQuestion objectQuestion4 = new ObjectQuestion(4L, "OBJECT_QUESTION4");

        ObjectQuestionResponse objectQuestionResponse10 = new ObjectQuestionResponse(10L, "YES", objectQuestion1);
        ObjectQuestionResponse objectQuestionResponse11 = new ObjectQuestionResponse(11L, "NO", objectQuestion1);
        List<ObjectQuestionResponse> objectQuestionResponseList1 = Arrays.asList(objectQuestionResponse10,
                objectQuestionResponse11);
        objectQuestion1.setValidObjectQuestionResponses(objectQuestionResponseList1);

        ObjectQuestionResponse objectQuestionResponse20 = new ObjectQuestionResponse(20L, "YES", objectQuestion2);
        ObjectQuestionResponse objectQuestionResponse21 = new ObjectQuestionResponse(21L, "NO", objectQuestion2);
        List<ObjectQuestionResponse> objectQuestionResponseList2 = Arrays.asList(objectQuestionResponse20,
                objectQuestionResponse21);
        objectQuestion2.setValidObjectQuestionResponses(objectQuestionResponseList2);

        ObjectQuestionResponse objectQuestionResponse30 = new ObjectQuestionResponse(30L, "YES", objectQuestion3);
        ObjectQuestionResponse objectQuestionResponse31 = new ObjectQuestionResponse(31L, "NO", objectQuestion3);
        List<ObjectQuestionResponse> objectQuestionResponseList3 = Arrays.asList(objectQuestionResponse30,
                objectQuestionResponse31);
        objectQuestion3.setValidObjectQuestionResponses(objectQuestionResponseList3);

        ObjectQuestionResponse objectQuestionResponse40 = new ObjectQuestionResponse(40L, "YES", objectQuestion4);
        ObjectQuestionResponse objectQuestionResponse41 = new ObjectQuestionResponse(41L, "NO", objectQuestion4);
        List<ObjectQuestionResponse> objectQuestionResponseList4 = Arrays.asList(objectQuestionResponse40,
                objectQuestionResponse41);
        objectQuestion4.setValidObjectQuestionResponses(objectQuestionResponseList4);

        ObjectAddress objectAddress1 = new ObjectAddress(1L, "HOME1", "HOME");
        ObjectAddress objectAddress2 = new ObjectAddress(2L, "HOME2", "OFFICE");
        ObjectAddress objectAddress3 = new ObjectAddress(3L, "HOME3", "HOME");
        ObjectAddress objectAddress31 = new ObjectAddress(31L, "HOME31", "HOME");

        ObjectResponse objectResponse1 = new ObjectResponse(1L, objectQuestionResponse10, Arrays.asList(objectAddress1));
        ObjectResponse objectResponse2 = new ObjectResponse(2L, objectQuestionResponse21, Arrays.asList(objectAddress2));
        ObjectResponse objectResponse3 = new ObjectResponse(3L, objectQuestionResponse31, Arrays.asList(objectAddress3,
                objectAddress31));
        ObjectResponse objectResponse4 = new ObjectResponse(4L, objectQuestionResponse41, null);

        return Arrays.asList(objectResponse1, objectResponse2, objectResponse3, objectResponse4);

    }
}
