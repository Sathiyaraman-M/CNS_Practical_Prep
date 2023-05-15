import java.util.*;

public class Exp1D {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        var plaintext = scanner.nextLine().toUpperCase();

        System.out.print("Enter the key: ");
        var key = scanner.nextLine().toUpperCase();

        var ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);

        var decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String plaintext, String key) {
        var ciphertext = new StringBuilder();

        for (int i = 0, j = 0; i < plaintext.length(); i++) {
            var c = plaintext.charAt(i);
            if (c < 'A' || c > 'Z') {
                continue; // Ignore non-alphabetic characters
            }

            var shift = key.charAt(j) - 'A';
            var encryptedChar = (char) ((c - 'A' + shift) % 26 + 'A');
            ciphertext.append(encryptedChar);

            j = (j + 1) % key.length(); // Move to the next character in the key
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        var plaintext = new StringBuilder();

        for (int i = 0, j = 0; i < ciphertext.length(); i++) {
            var c = ciphertext.charAt(i);
            if (c < 'A' || c > 'Z') {
                continue; // Ignore non-alphabetic characters
            }

            var shift = key.charAt(j) - 'A';
            var decryptedChar = (char) ((c - 'A' - shift + 26) % 26 + 'A');
            plaintext.append(decryptedChar);

            j = (j + 1) % key.length(); // Move to the next character in the key
        }

        return plaintext.toString();
    }
}