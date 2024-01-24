package be.heh.projetBook.adapter.apiResources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiDocs {
    @JsonProperty("title")
    private String title;

    @JsonProperty("author_name")
    private List<String> authorName;

    @JsonProperty("isbn")
    private List<String> isbn;

    @JsonProperty("cover_i")
    private Integer coverI;

    @JsonProperty("key")
    private String key;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthorName() {
        return authorName;
    }

    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }

    public List<String> getIsbn() {
        return isbn;
    }

    public void setIsbn(List<String> isbn) {
        this.isbn = isbn;
    }

    public Integer getCoverI() {
        return coverI;
    }

    public void setCoverI(Integer coverI) {
        this.coverI = coverI;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
