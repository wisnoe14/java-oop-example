class Book {
    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Book(String title, String id) {
        // Inisialisasi atribut title dan id dengan nilai parameter
        this.title = title;
        this.id = id;
    }
}
