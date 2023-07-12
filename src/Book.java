public class Book {
    private String title;
    private String author;
    private String year;
    private String publisher;
    private String key;

    public Book(String[] list) {
        try {
            this.title = list[0];
            this.author = list[1];
            this.year = list[2];
            this.publisher = list[3];
            this.key = list[4];
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", publisher='" + publisher + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
