/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.CarDAO;
import models.CarDTO;

/**
 *
 * @author Vader
 */
public class UpdateCarController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String CAR_UPDATE_PAGE = "car_update.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = CAR_UPDATE_PAGE;
        try {
            CarDAO carDAO = new CarDAO();
            int carID = Integer.parseInt(request.getParameter("UpdateCarID"));
            String carName = request.getParameter("UpdateCarName");
            String manufacturer = request.getParameter("UpdateManufacturer");
            double price = Double.parseDouble(request.getParameter("UpdatePrice"));
            int releasedYear = Integer.parseInt(request.getParameter("UpdateReleasedYear"));

            boolean result = carDAO.updateCar(carID, carName, manufacturer, price, releasedYear);

            if (result) {
                CarDTO carDTO = carDAO.carDetails(carID);
                request.setAttribute("UPDATE_SUCCESS_MESSAGE", "Cập nhật xe thành công");

                request.setAttribute("CAR_DETAILS", carDTO);

            } else {
                request.setAttribute("UPDATE_SUCCESS_MESSAGE", "Cập nhật xe thất bại");

            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
