
class Member extends Borrow {
  private String name;
  private String id;

  @Override
  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }

  public Member(String name, String id) {
    this.id = id;
    this.name = name;
  }

  public String name() {
    return name;
  }

  public String id() {
    return id;
  }

  public boolean hasBook(String id) {
    for (Book book : getBorrowList()) {
      if (book != null && book.getId().equals(id)) {
        return true;
      }
    }

    return false;
  }
}