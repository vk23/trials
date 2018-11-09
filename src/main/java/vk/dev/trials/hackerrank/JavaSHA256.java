package vk.dev.trials.hackerrank;


import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * JavaSHA256.
 *
 * @author Vladimir_Kuragin
 */
public class JavaSHA256 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        try {
            MessageDigest md5 = MessageDigest.getInstance("sha-256");
            byte[] digest = md5.digest(s.getBytes());
            System.out.println(new HexBinaryAdapter().marshal(digest).toLowerCase());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
