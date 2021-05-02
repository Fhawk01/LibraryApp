/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BuisnessLayer.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *S
 * @author Faith
 */
public class bookDataManager extends DataManager{
    public ArrayList<Book> database;
    
    public bookDataManager() {
        super();
    }
    
    public Book getById(int bookID) throws SQLException{
        PreparedStatement sqlStatement = super.getConnection().prepareStatement("  SELECT id, title, author, series FROM book_details WHERE id = ?");
        sqlStatement.setInt(1, bookID);
        
        
        ResultSet resultSet = sqlStatement.executeQuery();
        
        while(resultSet.next()){
            Book book = new Book(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));
            return book;
        }
        return null;
    }
    
    public ArrayList<Book> getAll() throws SQLException{
        try{ 
            
            ArrayList<Book> output = new ArrayList<Book>();
            
            String query1 ="SELECT * FROM book_details";
            Statement st= super.getConnection().createStatement();
            ResultSet rs= st.executeQuery(query1);
            
            while(rs.next()){
                Book book = new Book(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4));
                   output.add(book);
            }
            return output;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
        /*
        PreparedStatement sqlStatement = super.getConnection().prepareStatement("  SELECT id, title, author, series FROM book_details");
        
        ArrayList<Book> output = new ArrayList<Book>();
        
        ResultSet resultSet = sqlStatement.executeQuery();
        
        while(resultSet.next()){
            Book book = new Book(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));
            output.add(book);
        }
        return output;
        **/
    }
    public void create (Book newBook) throws SQLException{
        PreparedStatement sqlStatement = super.getConnection().prepareStatement("INSERT INTO book_details(title,author,series) VALUES(?,?,?)");
        
        sqlStatement.setString(1,newBook.getTitle());
        sqlStatement.setString(2,newBook.getAuthor());
        sqlStatement.setString(3,newBook.getSeries());
        
        sqlStatement.executeUpdate();
    }
    
    
    public void delete (Book bookToDelete){
        database.remove(bookToDelete);
    }
    
    public ArrayList<Book> getByTitle(String bookTitle) throws SQLException{
        String message = "Sorry Nothing here!";
        ArrayList<Book> booksFound = new ArrayList<Book>();
        
        try{ 
            
            
            
            String query1 ="SELECT id, title, author, series FROM book_details WHERE title = ?";
            PreparedStatement st= super.getConnection().prepareStatement(query1);
            st.setString(1,bookTitle);
            ResultSet rs= st.executeQuery();
            
            while(rs.next()){
                Book book = new Book(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4));
                   booksFound.add(book);
            }
               return booksFound;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
        
        
    }
    
        public ArrayList<Book> getByAuthor(String authorName) throws SQLException{
         
            
            ArrayList<Book> booksFound = new ArrayList<Book>();
        
        try{ 
            
            
            
            String query1 ="SELECT id, title, author, series FROM book_details WHERE author = ?";
            PreparedStatement st= super.getConnection().prepareStatement(query1);
            st.setString(1,authorName);
            ResultSet rs= st.executeQuery();
            
            while(rs.next()){
                Book book = new Book(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4));
                   booksFound.add(book);
            }
               return booksFound;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
    }
    
        public ArrayList<Book> getBySeries(String series) throws SQLException{
         
            
            ArrayList<Book> booksFound = new ArrayList<Book>();
        
        try{ 
            
            
            
            String query1 ="SELECT id, title, author, series FROM book_details WHERE series = ?";
            PreparedStatement st= super.getConnection().prepareStatement(query1);
            st.setString(1,series);
            ResultSet rs= st.executeQuery();
            
            while(rs.next()){
                Book book = new Book(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4));
                   booksFound.add(book);
            }
               return booksFound;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
        
        
        
    }
    
}
