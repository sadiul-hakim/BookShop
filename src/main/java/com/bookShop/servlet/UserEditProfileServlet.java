package com.bookShop.servlet;

import com.bookShop.entities.user.UpdateDTO;
import com.bookShop.entities.user.UserRepository;
import com.bookShop.entities.user.UserRepositoryImp;
import com.bookShop.helper.FileUploader;
import com.bookShop.helper.PathLocator;
import com.bookShop.helper.Sha256Encryptor;
import com.bookShop.helper.ValidationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 *
 * @author Hakim
 */
@WebServlet(name = "UserEditProfileServlet", urlPatterns = {"/UserEditProfileServlet"})
@MultipartConfig
public class UserEditProfileServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            int userId = Integer.parseInt(request.getParameter("userId"));
            String name = request.getParameter("name");
            Part part = request.getPart("photo");
            String photo = part.getSubmittedFileName();

            String fullPath = PathLocator.getUserPicUploadPath(request, userId,photo);

            UpdateDTO dto = new UpdateDTO(name, photo);

            Map<String, String> errors = ValidationUtil.getINSTANCE().validate(dto);

            if (!errors.isEmpty()) {
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("userEditProfile.jspx");
            } else {
                boolean upload = FileUploader.upload(part.getInputStream(), fullPath);
                if (!upload) {
                    request.setAttribute("errorMsg", "Could not upload file.");
                    request.getRequestDispatcher("userEditProfile.jspx");
                } else {
                    int updateUser = repository.updateUser(dto, userId);
                    if (updateUser < 0) {
                        request.setAttribute("errorMsg", "Could not update profile.");
                        request.getRequestDispatcher("userEditProfile.jspx");
                    } else {
                        request.getSession().setAttribute("successMsg", "Profile updated successfully.");
                        response.sendRedirect("userEditProfile.jspx");
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
