package com.bookShop.servlet;

import com.bookShop.entities.user.LoginDTO;
import com.bookShop.entities.user.User;
import com.bookShop.entities.user.UserRepository;
import com.bookShop.entities.user.UserRepositoryImp;
import com.bookShop.helper.ErrorMessage;
import com.bookShop.helper.SecurityContext;
import com.bookShop.helper.Sha256Encryptor;
import com.bookShop.helper.ValidationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 *
 * @author Hakim
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final UserRepository repository = new UserRepositoryImp(new Sha256Encryptor());

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
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            LoginDTO dto = new LoginDTO(email, password);
            Map<String, String> errors = ValidationUtil.getINSTANCE().validate(dto);

            if (!errors.isEmpty()) {
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("login.jspx").include(request, response);
            }

            User user = repository.login(dto);

            if (user == null) {
                request.setAttribute("errorMsg", ErrorMessage.getMsg());
                request.getRequestDispatcher("login.jspx").forward(request, response);
            } else {
                SecurityContext.login(request, user, response);
                if (user.getRole().equals("admin")) {
                    response.sendRedirect("admin.jspx");
                }else{
                    response.sendRedirect("index.jspx");
                }
            }

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
