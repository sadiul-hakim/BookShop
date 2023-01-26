package com.bookShop.entities.book;

import java.util.List;

/**
 *
 * @author Hakim
 */
public interface BookRepository {
    int saveBook(BookDTO dto);
    int updateBook(UpdateDTO dto,int id);
    int delete(int id);
    Book getBook(int id);
    List<Book> getAllBooks();
    List<Book> getAllBooksByCategory(String category);
    int saveOldBook(OldBookDTO dto);
    int updateOldBook(UpdateOldBookDTO dto,int id);
    int deleteOldBook(int id);
    OldBook getOldBook(int id);
    List<OldBook> getAllOldBook();
    List<OldBook> getAllOldBookOfUser(int id);
}
