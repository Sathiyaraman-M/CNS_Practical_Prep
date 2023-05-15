import java.util.*;

public class Exp2A {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        var plaintext = sc.nextLine();

        System.out.print("Enter the number of rails: ");
        var rails = sc.nextInt();

        var ciphertext = encrypt(plaintext, rails);
        System.out.println("Ciphertext: " + ciphertext);

        var decryptedText = decrypt(ciphertext, rails);
        System.out.println("Decrypted Text: " + decryptedText);

        sc.close();
    }

    static String encrypt(String pt, int rails) {
        var mat = getRailMatrix(pt, rails);
        String ct = "";
        for(int i = 0; i < rails; i++) {
            for(int j = 0; j < pt.length(); j++) {
                if(mat[i][j] != '.') {
                    ct += mat[i][j];
                }
            }
        }     
        return ct;
    }

    static String decrypt(String ct, int rails) {
        var mat = getRailMatrix("*".repeat(ct.length()), rails);
        String pt = "";
        var index = 0;
        for(int i = 0; i < rails; i++) {
            for(int j = 0; j < ct.length(); j++) {
                if(mat[i][j] == '*' && index < ct.length()) {
                    mat[i][j] = ct.charAt(index++);
                }
            }
        }
        var down = false;
        var row = 0;
        for(int i = 0; i < ct.length(); i++) {
            if (row == 0 || row == rails - 1) {
                down = !down;
            }
            pt += mat[row][i];
            row += down ? 1: -1;
        }
        return pt;
    }

    static char[][] getRailMatrix(String text, int rails) {
        var mat = new char[rails][text.length()];
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < text.length(); j++) {
                mat[i][j] = '.';
            }
        }
        var down = false;
        var row = 0;
        for(int i = 0; i < text.length(); i++) {
            if(row == rails - 1 || row == 0) {
                down = !down;
            }
            mat[row][i] = text.charAt(i);
            row += down ? 1: -1;
        }
        return mat;
    }
}
