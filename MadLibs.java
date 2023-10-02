import java.util.*;
public class MadLibs
{
    public static void main(String[] args)
    {
        Scanner k = new Scanner(System.in);
        // create a mad libs program
        System.out.println("Enter a noun: ");
        String noun = k.nextLine();
        System.out.println("Enter a plural noun: ");
        String plural_noun = k.nextLine();
        System.out.println("Enter a number: ");
        int number = k.nextInt();
        k.nextLine();
        System.out.println("Enter an adjective: ");
        String adjective = k.nextLine();
        System.out.println("Enter an adverb: ");
        String adverb = k.nextLine();
        System.out.println("Enter a verb: ");
        String verb = k.nextLine();
        System.out.println("I went to the animal " + noun + ", the " + plural_noun + " and the " + number + " beasts were there.");
        System.out.println("Once upon a time in a " + adjective + " land, a " + noun + " " + adverb +" grew.");
        System.out.println("Do you " + verb + " your " + adjective + " " + noun + " " + adverb + "? That's hilarious!");
        k.close();
    }
}