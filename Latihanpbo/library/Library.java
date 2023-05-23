import java.util.ArrayList;

class Library {
  public ArrayList<Book> books = new ArrayList<>();
  public ArrayList<Member> members = new ArrayList<>();

  public void addMember(Member member, boolean duplicateCheck) {
    try {
      if (duplicateCheck) {
        isMemberIdExist(member.id());
      }

      this.members.add(member);

    } catch (LibraryException e) {
      System.out.println("Member dengan ID ini Telah Terdaftar");
    }
  }

  public void isMemberIdExist(String id) throws LibraryException {
    for (Member member : this.members) {
      if (member.id().equals(id)) {
        throw new LibraryException();
      }
    }
  }

  public void isBookIdExist(String id, String title) throws LibraryException {
    for (Book book : this.books) {
      if (book.getId().equals(id)) {
        throw new LibraryException();
      }
    }
  }

  public void giveBook(String memberId, String bookId) {
    Book book = this.getBookById(bookId, getBookList());
    if (book == null) {
      return; // Buku tidak ditemukan
    }

    this.books.remove(book);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).receiveBook(book);
  }

  public void resetBookIds() {
    for (int i = 0; i < books.size(); i++) {
      Book book = books.get(i);
      book.setId(Integer.toString(i + 1)); // Mengatur ulang ID buku berdasarkan urutan dalam daftar
    }
  }

  public void receiveBook(String memberId, String bookId) {
    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);

    if (member == null) {
      return;
    }

    Book book = this.getBookById(bookId, member.getBorrowList());
    this.books.add(book);

    this.members.get(memberIndex).giveBook(book);
  }

  private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.members) {
      if (member.id().equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id, Book[] list) {
    for (Book book : list) {
      if (book != null && book.getId().equals(id)) {
        return book;
      }
    }
    return null;
  }

  public void addBook(Book book, boolean duplicateCheck) {

    try {
      if (duplicateCheck) {
        isBookIdExist(book.getId(), book.getTitle());
        isBookIdExistInBorrowedBooks(book.getId());
      }
      this.books.add(book);
    } catch (LibraryException e) {
      System.out.println("Buku dengan ID ini Sudah Terdaftar");
    }

  }

  public void isBookIdExistInBorrowedBooks(String id) throws LibraryException {
    for (Member member : this.members) {
      if (member.hasBook(id)) {
        throw new LibraryException();
      }
    }
  }

  public Member[] getMemList() {
    Member[] memberArray = new Member[this.members.size()];
    int i = 0;
    for (Member member : this.members) {
      memberArray[i++] = member;
    }
    return memberArray;
  }

  public void showMem() {
    for (Member member : getMemList()) {
      if (member == null) {
        continue;
      }
      System.out.printf("%s %s \n", member.id(), member.name());
    }
  }

  public void showBooks() {
    for (Book book : getBookList()) {
      if (book == null) {
        continue;
      }
      System.out.printf("%s %s \n", book.getId(), book.getTitle());
    }
  }

  public Book[] getBookList() {
    Book[] bookArray = new Book[this.books.size()];
    int i = 0;
    for (Book book : this.books) {
      bookArray[i++] = book;
    }
    return bookArray;
  }

}