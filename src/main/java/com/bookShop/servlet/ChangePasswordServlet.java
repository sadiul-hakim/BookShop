package com.bookShop.servlet;

import com.bookShop.entities.user.User;
import com.bookShop.entities.user.UserRepository;
import com.bookShop.entities.user.UserRepositoryImp;
import com.bookShop.helper.Encryptor;
import com.bookShop.helper.SecurityContext;
import com.bookShop.helper.Sha256Encryptor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Hakim
 */
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {

    Encryptor encryptor = new Sha256Encryptor();
    private final UserRepository repository = new UserRepositoryImp(encryptor);

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
            int userId = Integer.parseInt(request.getParameter("userId"));
            String oldPassword = request.getParameter("old");
            String newPassword = request.getParameter("new");
            String confirmPassword = request.getParameter("confirm");

            String oldHash = encryptor.encrypt(oldPassword);
            User user = repository.getUser(userId);

            if (!user.getPassword().equals(oldHash)) {
                request.setAttribute("errorMsg", "Wrong current password.");
                request.getRequestDispatcher("userChangePassword.jspx").forward(request, response);
            } else {
                if (!newPassword.equals(confirmPassword)) {
                    request.setAttribute("errorMsg", "New and Cofirm password should match.");
                    request.getRequestDispatcher("userChangePassword.jspx").forward(request, response);
                } else {
                    String newHash = encryptor.encrypt(newPassword);
                    int saved = repository.changePassword(userId, newHash);

                    if (saved < 0) {
                        request.setAttribute("errorMsg", "Could not change password.try again!");
                        request.getRequestDispatcher("userChangePassword.jspx").forward(request, response);
                    }else{
                        SecurityContext.logout(request);
                        response.sendRedirect("login.jspx");
                    }
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
