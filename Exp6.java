import java.util.*;

public class Exp6 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.print("Enter Prime: ");
        var prime = sc.nextLong();

        System.out.print("Enter Primitive Root G: ");
        var G = sc.nextLong();

        System.out.print("Enter Private Key for Alice: ");
        var a = sc.nextLong();

        System.out.print("Enter Private Key for Bob: ");
        var b = sc.nextLong();

        var A = ((long) Math.pow(G, a)) % prime;
        var B = ((long) Math.pow(G, b)) % prime;

        var Ka = ((long) Math.pow(B, a)) % prime;
        var Kb = ((long) Math.pow(A, b)) % prime;

        System.out.printf("Ka: %d, Kb: %d\n", Ka, Kb);
        if (Ka == Kb) {
            System.out.println("Key Exchange Success!");
        }
    }
}
