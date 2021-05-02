/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayLayer;

import BuisnessLayer.Book;
import DataLayer.bookDataManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Faith
 */
public class Main {
    
    public static void main(String[] args) throws SQLException {
        bookDataManager bookDm = new bookDataManager();
        
        
        Book myBook = new Book(1, "A Court of Silver Flames","Sarah J. Maas","The Court of Thorns and Roses");
        Book myBook2 = new Book(2, "Capturing the Devil","Kerri Maniscalco","Stalking Jack the Ripper");
        Book myBook3 = new Book(3, "The Left-Handed Booksellers of London","Garth Nix",null);
        Book myBook4 = new Book(4, "The Crowfield Demon","Pat Walsh",null);

        bookDm.create(myBook);
        bookDm.create(myBook2);
        bookDm.create(myBook3);
        bookDm.create(myBook4);
        //how to read them
        
        ArrayList<Book> allBooks = bookDm.getAll();
        System.out.println(allBooks);
    }
    
}
