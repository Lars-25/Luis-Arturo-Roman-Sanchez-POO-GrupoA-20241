
public class Main {
    public static void main(String[] args) {

        Person firstPerson = new Person("Luis", 20, "Male");
        System.out.println(firstPerson.getPersonInfo());

        System.out.println("***************");

        Person secondPerson = new Person("Kayler", 26, "Male");
        System.out.println(secondPerson.getPersonInfo());

        System.out.println("***************");

        Person thirdPerson = new Person("John", 35, "Male");
        System.out.println(thirdPerson.getPersonInfo());

        System.out.println("***************");

        Person fourthPerson = new Person("Carla", 54, "Female");
        System.out.println(fourthPerson.getPersonInfo());

        System.out.println("***************");

        Book firstBook = new Book();
        firstBook.getBookInfo();
        
        System.out.println("***************");

        Book secondBook = new Book();
        secondBook.title = "Cracking the coding interview";
        secondBook.author = "Gayle Laakmann McDowell";
        secondBook.publicationYear = 2008;
        secondBook.getBookInfo();

        System.out.println("***************");

        Book thirdBook = new Book();
        thirdBook.title = "The C Programming Language";
        thirdBook.author = "Brian Kernighan & Dennis Ritchie";
        thirdBook.publicationYear = 1978;
        thirdBook.getBookInfo();

        System.out.println("***************");

        Book fourthBook = new Book();
        fourthBook.title = "Clean Code";
        fourthBook.author = "Robert C. Martin";
        fourthBook.publicationYear = 2008;
        fourthBook.getBookInfo();

        System.out.println("***************");

        Rectangle firsRectangle = new Rectangle(5.0, 3.0);
        System.out.println(firsRectangle.getRectangleInfo());

        System.out.println("***************");

        Rectangle secondRectangle = new Rectangle(4.7, 2.9);
        System.out.println(secondRectangle.getRectangleInfo());

        System.out.println("***************");

        Rectangle thirdRectangle = new Rectangle(5.1, 7.3);
        System.out.println(thirdRectangle.getRectangleInfo());

        System.out.println("***************");

        Rectangle fourthRectangle = new Rectangle(4.6, 9.7);
        System.out.println(fourthRectangle.getRectangleInfo());

    }
}
