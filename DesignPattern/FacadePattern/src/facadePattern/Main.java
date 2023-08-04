package facadePattern;

public class Main {
	public static void main(String[] args) {
        MediaFacade mediaFacade = new MediaFacade();
        String searchTitle = "Harry Potter";
        mediaFacade.searchMedia(searchTitle);
    }
}
