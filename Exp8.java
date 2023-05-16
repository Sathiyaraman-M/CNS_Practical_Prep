import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.*;

import javax.crypto.KeyGenerator;

public class Exp8 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var input = sc.nextLine().trim();

        sc.close();

        try {
            var keyPairGen = KeyPairGenerator.getInstance("DSA");
            keyPairGen.initialize(1024);

            var keypair = keyPairGen.generateKeyPair();
            var priv = keypair.getPrivate();
            var pub = keypair.getPublic();

            var sign = Signature.getInstance("SHA256WithDSA");
            sign.initSign(priv);
            sign.update(input.getBytes());
            var signedBytes = sign.sign();

            var verifier = Signature.getInstance("SHA256WithDSA");
            verifier.initVerify(pub);
            sign.update(input.getBytes());
            var verified = verifier.verify(signedBytes);

            System.out.println("Message: " + input);
            System.out.println("Signature: " + Base64.getEncoder().encodeToString(signedBytes));
            System.out.println("Verified: " + verified);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
