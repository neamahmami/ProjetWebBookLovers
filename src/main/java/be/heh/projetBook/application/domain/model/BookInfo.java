package be.heh.projetBook.application.domain.model;

public class BookInfo {
    private double rate;
    private String title;
    private String authorName;
    private String summary;
    private String cover;  //string car c'est un url
    private int isbn;

    //constructeur
    public BookInfo(String title, String authorName , String summary, String cover, int isbn, double rate){
        this.title=title;
        this.authorName=authorName;
        this.summary=summary;
        this.cover=cover;
        this.isbn=isbn;
        this.rate=rate;
    }
    public BookInfo(String title, String authorName , String summary, String cover, int isbn){
        this.title=title;
        this.authorName=authorName;
        this.summary=summary;
        this.cover=cover;
        this.isbn=isbn;
        this.rate=0;
    }
    public BookInfo(String title){
        this.title = title;
    }
    //getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return authorName;
    }
    public void setAuthor(String author) {
        this.authorName = authorName;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getCover(){
        return  cover;
    }
    public void setCover(String cover){
        this.cover=cover;
    }
    public int getIsbn() {return isbn;}
    public void setIsbn(int isbn) {this.isbn = isbn;}
    public double getRate(){
        return  rate;
    }
    public void setRate(double rate){
        this.rate=rate;
    }


}
