import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Exp3 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.print("Enter Message: ");
        var message = sc.nextLine().trim();

        System.out.print("Enter SecretKey: ");
        var key = sc.nextLine().trim();

        sc.close();

        try {
            var secretKey = new SecretKeySpec(key.getBytes(), "DES");
            var encryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);

            var decryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);


            var encryptedBytes = encryptCipher.doFinal(message.getBytes());
            System.out.println("Encrypted Text: " + Base64.getEncoder().encodeToString(encryptedBytes));

            var decryptedBytes = decryptCipher.doFinal(encryptedBytes);
            System.out.println("Decrypted Text: " + new String(decryptedBytes));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
