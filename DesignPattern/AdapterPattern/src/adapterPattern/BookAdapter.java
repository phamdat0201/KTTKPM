package adapterPattern;

public class BookAdapter implements BookViewer{
	private Book book;

    public BookAdapter(Book book) {
        this.book = book;
    }

    @Override
    public void showTitle(String title) {
        System.out.println("Tiêu đề: " + book.getTitle());
    }

    @Override
    public void showAuthor(String author) {
        System.out.println("Tác giả: " + book.getAuthor());
    }

    @Override
    public void showContent(String content) {
        System.out.println("Nội dung:\n" + book.getContent());
    }
}
