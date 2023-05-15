import java.util.*;

public class Exp1A {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var line = sc.nextLine();
        var key = 123;
        sc.close();
        String cipher = "";
        for(int i = 0; i < line.length(); i++) {
            var ch = (int)line.charAt(i);
            ch -= 97;
            ch += key;
            if (ch >= 26) {
                ch = ch % 26;
            }
            ch += 97;
            cipher += (char)ch;
        }
        System.out.print(cipher);
    }
}