import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

public class Exp7 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.print("Enter Message: ");
        var message = sc.nextLine().trim();

        sc.close();

        try {
            var md = MessageDigest.getInstance("SHA-1");
            var digestBytes = md.digest(message.getBytes());
            var bigInt = new BigInteger(1, digestBytes);
            var hashText = bigInt.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            System.out.printf("Digest: %s", hashText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
