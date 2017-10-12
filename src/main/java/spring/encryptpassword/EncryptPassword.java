package spring.encryptpassword;

public class EncryptPassword {

    public static void main(String[] args) {
        ShaPasswordEncoder sha = new ShaPasswordEncoder();
        String hash = sha.encodePassword("Password1", "900000000000005807");
        System.out.println(hash);

    }

}
