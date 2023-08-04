package facadePattern;

public class MediaFacade {
    private Book book;
    private Music music;
    private Movie movie;

    public MediaFacade() {
        book = new Book();
        music = new Music();
        movie = new Movie();
    }

    public void searchMedia(String title) {
        book.searchBook(title);
        music.searchMusic(title);
        movie.searchMovie(title);
    }
}

