import java.util.*;

public class Exp1C {


    static void hillChipher(String pt, int N, String key) {
        var keyMatrix = new int[N][N];
        int k = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
        
        var ptMatrix = new int[N][1];
        for(int i = 0; i < N; i++) {
            ptMatrix[i][0] = (pt.charAt(i)) % 65;
        }

        var ctMatrix = new int[N][1];
        //matrix multiplication
        for(int i = 0; i < N; i++) {
            ctMatrix[i][0] = 0;
            for(int j = 0; j < N; j++) {
                ctMatrix[i][0] += keyMatrix[i][j] * ptMatrix[j][0];
            }
            ctMatrix[i][0] = ctMatrix[i][0] % 26;
        }
        var ct = "";
        for(int i = 0; i < N; i++) {
            ct += (char)(ctMatrix[i][0] + 65);
        }
        System.out.print(ct);
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var line = sc.nextLine().trim();      
        hillChipher(line, line.length(), "GYBNQKURP");  
        sc.close();
    }
}
