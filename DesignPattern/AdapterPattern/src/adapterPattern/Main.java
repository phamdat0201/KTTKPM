package adapterPattern;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Harry Potter", "J.K. Rowling", "Once upon a time...");

        BookViewer bookViewer = new BookAdapter(book);

        bookViewer.showTitle(book.getTitle());
        bookViewer.showAuthor(book.getAuthor());
        bookViewer.showContent(book.getContent());
    }
}

