import java.util.Scanner;

public class ModularExponentiation {

    static long powerMod(long A, long k, long M) {
       
        if (k == 0) return 1 % M;  // Base case: any number to the power 0 is 1 (mod M)
      
        
        long half = powerMod(A, k / 2, M);  // Recursively compute (A^(k/2)) % M
        long result = (half * half) % M;   // Combine the results: (half * half) % M

        
        if (k % 2 == 1) {  // If k is odd, multiply by A one more time
            result = (result * A) % M;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        long A = sc.nextLong(); // base
        long k = sc.nextLong(); // exponent
        long M = sc.nextLong(); // modulo


        long result = powerMod(A, k, M);
        System.out.println(result);
    }
}
