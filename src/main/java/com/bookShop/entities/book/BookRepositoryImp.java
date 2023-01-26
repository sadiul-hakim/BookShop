package com.bookShop.entities.book;

import com.bookShop.helper.ConnectionProvider;
import com.bookShop.helper.ErrorMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Hakim
 */
public class BookRepositoryImp implements BookRepository {

    private final Logger logger = LoggerFactory.getLogger(BookRepositoryImp.class);

    @Override
    public int saveBook(BookDTO dto) {
        int result = -1;

        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "insert into book(name,author,category,status,desciprion,price,photo) values(?,?,?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                statement.setString(1, dto.getName());
                statement.setString(2, dto.getAuthor());
                statement.setString(3, dto.getCategory());
                statement.setString(4, dto.getStatus());
                statement.setString(5, dto.getDescription());
                statement.setInt(6, dto.getPrice());
                statement.setString(7, dto.getPhoto());

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not save book.Please try again!");
            logger.error("Could not save book.Error : " + ex.getMessage());
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateBook(UpdateDTO dto, int id) {
        int result = -1;

        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "update book set name=?,status=?,desciprion=?,price=?,photo=? where id=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                statement.setString(1, dto.getName());
                statement.setString(2, dto.getStatus());
                statement.setString(3, dto.getDescription());
                statement.setInt(4, dto.getPrice());
                statement.setString(5, dto.getPhoto());
                statement.setInt(6, id);

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not update book.Please try again!");
            logger.error("Could not update book.Error : " + ex.getMessage());
        }

        return result;
    }

    @Override
    public int delete(int id) {
        int result = -1;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "delete from book where id=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1, id);

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not delete book.Please try again!");
            logger.error("Could not Delete book.Error : " + ex.getMessage());
        }

        return result;
    }

    @Override
    public Book getBook(int id) {
        Book book = null;
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from book where id = ?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1, id);

                set = statement.executeQuery();

                if (set.next()) {
                    book = new Book(
                            set.getInt("id"),
                            set.getString("name"),
                            set.getString("author"),
                            set.getString("category"),
                            set.getString("status"),
                            set.getString("desciprion"),
                            set.getString("photo"),
                            set.getInt("price"),
                            set.getTimestamp("addedAt")
                    );
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get book.Please try again!");
            logger.error("Could not get book.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from book";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                set = statement.executeQuery();

                while (set.next()) {
                    books.add(new Book(
                            set.getInt("id"),
                            set.getString("name"),
                            set.getString("author"),
                            set.getString("category"),
                            set.getString("status"),
                            set.getString("desciprion"),
                            set.getString("photo"),
                            set.getInt("price"),
                            set.getTimestamp("addedAt")
                    ));
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get books.Please try again!");
            logger.error("Could not get books.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return books;
    }

    @Override
    public List<Book> getAllBooksByCategory(String category) {
        List<Book> books = new ArrayList<>();
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from book where category = ?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setString(1, category);
                set = statement.executeQuery();

                while (set.next()) {
                    books.add(new Book(
                            set.getInt("id"),
                            set.getString("name"),
                            set.getString("author"),
                            set.getString("category"),
                            set.getString("status"),
                            set.getString("desciprion"),
                            set.getString("photo"),
                            set.getInt("price"),
                            set.getTimestamp("addedAt")
                    ));
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get books.Please try again!");
            logger.error("Could not get books.Error : " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return books;
    }

    @Override
    public int saveOldBook(OldBookDTO dto) {
        int result = -1;

        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "insert into oldbook(name,author,category,price,userid,username,photo) values(?,?,?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                statement.setString(1, dto.getName());
                statement.setString(2, dto.getAuthor());
                statement.setString(3, dto.getCategory());
                statement.setInt(4, dto.getPrice());
                statement.setInt(5, dto.getUserId());
                statement.setString(6, dto.getUserName());
                statement.setString(7, dto.getPhoto());

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not save book.Please try again!");
            logger.error("Could not save book.Error : " + ex.getMessage());
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateOldBook(UpdateOldBookDTO dto, int id) {
        int result = -1;

        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "update book set name=?,price=?,photo=? where id=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                statement.setString(1, dto.getName());
                statement.setInt(2, dto.getPrice());
                statement.setString(3, dto.getPhoto());
                statement.setInt(4, id);

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not update book.Please try again!");
            logger.error("Could not update book.Error : " + ex.getMessage());
        }

        return result;
    }

    @Override
    public int deleteOldBook(int id) {
        int result = -1;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "delete from oldbook where id=?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1, id);

                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not delete book.Please try again!");
            logger.error("Could not Delete book.Error : " + ex.getMessage());
        }

        return result;
    }

    @Override
    public OldBook getOldBook(int id) {
        OldBook book = null;
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from oldbook where id = ?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1, id);
                set = statement.executeQuery();

                if (set.next()) {
                    book = new OldBook(
                            set.getInt("id"),
                            set.getString("name"),
                            set.getString("author"),
                            set.getString("category"),
                            set.getString("photo"),
                            set.getInt("price"),
                            set.getInt("userid"),
                            set.getString("userName"),
                            set.getTimestamp("addedAt")
                    );
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get books.Please try again!");
            logger.error("Could not get books.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return book;
    }

    @Override
    public List<OldBook> getAllOldBook() {
        List<OldBook> books = new ArrayList<>();
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from oldbook";
            try (PreparedStatement statement = connection.prepareCall(query)) {

                set = statement.executeQuery();

                while (set.next()) {
                    books.add(
                            new OldBook(
                                    set.getInt("id"),
                                    set.getString("name"),
                                    set.getString("author"),
                                    set.getString("category"),
                                    set.getString("photo"),
                                    set.getInt("price"),
                                    set.getInt("userid"),
                                    set.getString("userName"),
                                    set.getTimestamp("addedAt")
                            ));
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get books.Please try again!");
            logger.error("Could not get books.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return books;
    }
    
    @Override
    public List<OldBook> getAllOldBookOfUser(int id) {
        List<OldBook> books = new ArrayList<>();
        ResultSet set = null;
        try (Connection connection = ConnectionProvider.getConnection()) {

            String query = "select * from oldbook where userid = ?";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setInt(1, id);
                set = statement.executeQuery();

                while (set.next()) {
                    books.add(
                            new OldBook(
                                    set.getInt("id"),
                                    set.getString("name"),
                                    set.getString("author"),
                                    set.getString("category"),
                                    set.getString("photo"),
                                    set.getInt("price"),
                                    set.getInt("userid"),
                                    set.getString("userName"),
                                    set.getTimestamp("addedAt")
                            ));
                }

            }
        } catch (SQLException ex) {
            ErrorMessage.clear();
            ErrorMessage.setMsg("Could not get books.Please try again!");
            logger.error("Could not get books.Error : " + ex.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    logger.error("Could not close result set.Error : " + ex.getMessage());
                }
            }
        }

        return books;
    }

}
