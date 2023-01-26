package com.bookShop.servlet;

import com.bookShop.entities.address.AddressDTO;
import com.bookShop.entities.address.AddressRepository;
import com.bookShop.entities.address.AddressRepositoryImp;
import com.bookShop.helper.ErrorMessage;
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
@WebServlet(name = "AddAddressServlet", urlPatterns = {"/AddAddressServlet"})
public class AddAddressServlet extends HttpServlet {

    private final AddressRepository repository = new AddressRepositoryImp();

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
            //Joduboira,Kumarkhali,Kushtia,Khulna
            String userIdStr = request.getParameter("userId");
            int userId = Integer.parseInt(userIdStr);
            String division = request.getParameter("division");
            String district = request.getParameter("district");
            String subdistrict = request.getParameter("subdistrict");
            String unionname = request.getParameter("unionname");
            int zip = Integer.parseInt(request.getParameter("zip"));
            String address = request.getParameter("address");

            AddressDTO dto = new AddressDTO(userId, division, district, subdistrict, unionname, zip, address);
            Map<String, String> errors = ValidationUtil.getINSTANCE().validate(dto);

            if (!errors.isEmpty()) {
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("addAddress.jspx").forward(request, response);
            }

            int saved = repository.save(dto);

            if (saved < 0) {
                request.setAttribute("errorMsg", ErrorMessage.getMsg());
                request.getRequestDispatcher("addAddress.jspx").forward(request, response);
            } else {
                request.getSession().setAttribute("successMsg", "Addess successfully added.");
                response.sendRedirect("addAddress.jspx");
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
