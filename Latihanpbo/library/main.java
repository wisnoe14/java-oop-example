import java.util.Scanner;

class Main {

  static Scanner scan = new Scanner(System.in);
  static Library library = new Library();

  public static void main(String[] args) {
    initLibraryData();

    String isContinue = "y";

    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = chooseMenu();

      if (selectedMenu == 1) {
        showBooks();
      } else if (selectedMenu == 2) {
        showMembers();
      } else if (selectedMenu == 3) {
        addMember();
      } else if (selectedMenu == 4) {
        addbook();
      } else if (selectedMenu == 5) {
        borrowBook();
      } else if (selectedMenu == 6) {
        returnBook();
      } else {
        System.out.println("wrong input");
      }

      System.out.print("continue ? ");
      isContinue = scan.next();
    }
  }

  public static void showMenu() {
    System.out.println("================================");
    System.out.println("1. show books list");
    System.out.println("2. show members list");
    System.out.println("3. add member");
    System.out.println("4. add book");
    System.out.println("5. borrow book");
    System.out.println("6. return book");
    System.out.println("================================");
  }

  public static void initLibraryData() {
    library.addBook(new Book("pemrograman java", "1"), true);
    library.addBook(new Book("pemrograman oop", "2"), true);
    library.addBook(new Book("pemrograman android", "3"), true);

    library.addMember(new Member("Aka", "1"), true);
    library.addMember(new Member("Budi", "2"), true);
    library.addMember(new Member("Tono", "3"), true);

  }

  public static int chooseMenu() {
    System.out.print("choose menu : ");
    int pilihan = scan.nextInt();
    scan.nextLine();
    return pilihan;
  }

  public static void showBooks() {
    library.showBooks();
  }

  public static void showMembers() {
    library.showMem();
  }

  public static void addMember() {
    System.out.print("name : ");
    String memName = scan.nextLine();

    System.out.print("id : ");
    String memId = scan.next();

    library.addMember(new Member(memName, memId), true);
  }

  public static void borrowBook() {
    System.out.print("id member : ");
    String memberId = scan.next();
 
    System.out.print("id book : ");
    String bookId = scan.next();

    library.giveBook(memberId, bookId);
  }

  public static void returnBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.receiveBook(memberId, bookId);
  }

  public static void addbook() {
    System.out.print("book title : ");
    String bookTitle = scan.nextLine();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.addBook(new Book(bookTitle, bookId), true);
  }

}