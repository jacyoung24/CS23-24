/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
  private Book book;
  private Movie movie;

  public void addBook(Book b)
  {
    book = b;
  }

  public void addMovie(Movie m)
  {
    movie = m;
  }

  // void testBook(Book tester)
  // {
  //   tester.setTitle("Test Book");
  // }

  public String toString() 
  {
    String info = "";
    info += book + "\n";
    info += movie + "\n";
    return info;
  }
}