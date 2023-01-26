package com.bookShop.bean;

import com.bookShop.entities.book.Book;
import com.bookShop.entities.book.BookRepository;
import com.bookShop.entities.book.BookRepositoryImp;
import com.bookShop.entities.book.OldBook;
import com.bookShop.entities.user.User;
import java.util.List;

/**
 *
 * @author Hakim
 */
public class BookBean {
    private final BookRepository repository=new BookRepositoryImp();
    private List<Book> allBooks;
    private List<Book> allRecentBook;
    private List<Book> allNewBooks;
    private List<OldBook> allOldBooks;
    private List<OldBook> allOldBooksOfUser;
    private User user;
    private Book singleBook;
    private OldBook singleOldBook;
    private int bookId;
    private int oldBookId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getOldBookId() {
        return oldBookId;
    }

    public void setOldBookId(int oldBookId) {
        this.oldBookId = oldBookId;
    }

    public Book getSingleBook() {
        singleBook=repository.getBook(bookId);
        return singleBook;
    }

    public OldBook getSingleOldBook() {
        singleOldBook=repository.getOldBook(oldBookId);
        return singleOldBook;
    }
    
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

    public List<Book> getAllBooks() {
        allBooks=repository.getAllBooks();
        return allBooks;
    }

    public List<Book> getAllRecentBook() {
        allRecentBook=repository.getAllBooksByCategory("recent");
        System.out.println(allRecentBook+"=>recent");
        return allRecentBook;
    }

    public List<Book> getAllNewBooks() {
        allNewBooks=repository.getAllBooksByCategory("newbook");
        return allNewBooks;
    }

    public List<OldBook> getAllOldBooks() {
        allOldBooks=repository.getAllOldBook();
        return allOldBooks;
    }

    public List<OldBook> getAllOldBooksOfUser() {
        allOldBooksOfUser=repository.getAllOldBookOfUser(user.getId());
        return allOldBooksOfUser;
    }
    
    
    
    
}
