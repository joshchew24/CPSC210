package model;

// Represents a web note having a title and a URL to a web page
public class WebNote {
    private String title;
    private String url;

    // EFFECTS: constructs a web note with a title and URL
    public WebNote(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
