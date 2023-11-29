/*
 * Activity 2.5.7
 * 
 * The runner for the MediaLibrary program
 */
public class MediaLibRunner
{
  public static void main(String[] args)
  {
    System.out.println("Welcome to your Media Library");
    MediaLib myLib = new MediaLib();
    Book myBook = new Book("The Lord of the Rings", "Tolkien");
    System.out.println("Book created " + myBook);
    System.out.println("Library:\n" + myLib);
    myLib.addBook(myBook);
    System.out.println("Library:\n" + myLib);
    int myRating = 5;
    myBook.adjustRating(myRating);
    System.out.println(myBook);
    myBook.adjustRating(-2);
    System.out.println(myBook);
    System.out.println(myRating);
    myBook.adjustRating(-4);
    System.out.println(myBook);
    myBook.setTitle("The Hobbit");
    System.out.println("Book:" + myBook);
    System.out.println("Library: " + myLib);
    myBook.setAuthor("J.R.R. Tolkien");
    System.out.println("Book:" + myBook);
    System.out.println("Library: " + myLib);

    /*
    * Activity 2.5.7
    */
    System.out.println("You have a NEW Library");
    MediaLib myLib2 = new MediaLib();

    Book newBook = new Book("To Kill a Mockingbird", "Lee");
    myLib2.addBook(newBook);
    System.out.println(myLib2);
    newBook = new Book("1984", "Orwell");
    System.out.println(myLib2);

    // System.out.println("before test:" + newBook);
    // myLib.testBook(newBook);
    // System.out.println("after test:" + newBook);

    Book newBook2 = new Book("1984", "Orwell");
    System.out.println(newBook.equals(newBook2));
    newBook2.setAuthor("George Orwell");
    System.out.println(newBook.equals(newBook2));
    // System.out.println(newBook2.title); // error: title has private access in Book

    Movie myMovie = new Movie("The Matrix", 2.5);
    System.out.println(myMovie);
    myLib2.addMovie(myMovie);
    System.out.println(myLib2);
    Movie myMovie2 = new Movie("The Matrix", 2.5);
    System.out.println(myMovie.equals(myMovie2));
    myMovie2.setDuration(2.0);
    System.out.println(myMovie.equals(myMovie2));
  }
}