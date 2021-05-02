/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuisnessLayer;


/**
 *
 * @author Faith
 */
public class Book {
    private int bookID;
    private String title;
    private String author;
    private String series;
    

    public Book(int bookID, String title, String author, String series) {
        this.bookID = bookID;
        this.title = title;
        this.author = author ;
        this.series = series;
        
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
    
}
