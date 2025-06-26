
import java.util.Scanner;

public class MinNumberNotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] notes = {1, 2, 5, 10};
        int amount = sc.nextInt();
        System.out.println("Minimum number of notes required: " + minNotes(notes, amount));
        sc.close();
    }

    static int minNotes(int[] notes, int amount) {
        int ans = 0;
        
        for(int i = notes.length - 1; i >= 0 && amount > 0; i--) {
            while(amount >= notes[i]){
                amount -= notes[i];
                ans++;
            }
        }

        return ans;
    }
}

// Algo:
// 1. Read the available denominations of notes.
// 2. Read the target amount.
// 3. Initialize a counter for the number of notes.
// 4. Start from the largest denomination and try to use as many of those notes as possible.
// 5. Subtract the value of the notes used from the target amount and increment the counter.
// 6. Repeat until the amount is reduced to zero or no more denominations can be used.
// 7. Return the total count of notes used.