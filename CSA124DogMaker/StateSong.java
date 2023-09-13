public class StateSong
{
  public static void main(String[] args)
  {
    String stateSong = "Georgia, Georgia\n";
    String state2 = new String("The whole day through (The whole day through)\n");
    stateSong += state2;
    stateSong = stateSong + "Just an old sweet song\n";
    String verse = "Keeps Georgia on my mind (Georgia on mind)";
    System.out.println(stateSong + verse);
  }
}