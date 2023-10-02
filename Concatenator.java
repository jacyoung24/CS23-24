import java.util.Scanner;

public class Concatenator {
    public static void main(String[] args) {
        // Concatenate the first half of one line and the second half of another using scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line of text: ");
        String line1 = sc.nextLine();
        System.out.println("Enter another line of text: ");
        String line2 = sc.nextLine();
        int half1 = line1.length() / 2;
        int half2 = line2.length() / 2;
        String concat = line1.substring(0, half1) + line2.substring(half2);
        System.out.println(concat);
        sc.close();
    }
}