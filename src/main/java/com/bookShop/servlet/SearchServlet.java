package com.bookShop.servlet;

import com.bookShop.entities.book.Book;
import com.bookShop.entities.book.BookRepository;
import com.bookShop.entities.book.BookRepositoryImp;
import com.bookShop.entities.book.OldBook;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Hakim
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {
    private final BookRepository repository=new BookRepositoryImp();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String term=request.getParameter("search");
            
            List<Book> comBook=repository.getAllBooks();
            List<OldBook> userBook=repository.getAllOldBook();
            
            List<Book> resultComBook=comBook.stream().filter(book->book.getName().contains(term) || book.getCategory().contains(term))
                    .collect(Collectors.toList());
            List<OldBook> resultUserBook=userBook.stream().filter(book->book.getName().contains(term) || book.getCategory().contains(term)).collect(Collectors.toList());
            
            HttpSession session = request.getSession();
            
            session.setAttribute("comBooks", resultComBook);
            session.setAttribute("oldBooks", resultUserBook);
            
            
            System.out.println(resultComBook);
            System.out.println(resultUserBook);
            
            response.sendRedirect("searchResult.jspx");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
