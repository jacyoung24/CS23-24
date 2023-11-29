/*
 * Activity 2.4.4
 */
public class LetterFrequencies
{
	public static void main(String[] args)
	{
	  int cnt = 0;
		String letters = "abcdefghijklmnopqrstuvwxyz"; 
		String phrase = "This is a phrase!";

		System.out.println("The following shows the letter frequencies for the phrase");

    /* your code here */
    for (int i = 0; i < letters.length(); i++) {
      char let1 = Character.toLowerCase(letters.charAt(i));
      for (int j = 0; j < phrase.length(); j++) {
        char let2 = Character.toLowerCase(phrase.charAt(j));
        if (let1 == let2) {
          cnt += 1;
        }
      }
      System.out.printf("%C: %d\n", let1, cnt);
      cnt = 0;
    }
	}
}
