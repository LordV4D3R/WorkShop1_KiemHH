/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.CarDAO;

/**
 *
 * @author tranq
 */
public class DeleteCarController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String CAR_DELETE_PAGE = "car_delete.jsp";
    private static final String CAR_MANAGEMENT_CONTROLLER = "LoadCarController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = CAR_DELETE_PAGE;

        try {

            String carIDString = request.getParameter("CarID");

            if (carIDString != null && !carIDString.isEmpty()) {
                int carID = Integer.parseInt(carIDString);

                CarDAO dao = new CarDAO();
                boolean result = dao.deleteCar(carID);

                if (result) {
                    request.setAttribute("DELETE_MESSAGE", "Xóa xe thành công!");
                    url = CAR_MANAGEMENT_CONTROLLER;
                } else {
                    request.setAttribute("DELETE_MESSAGE", "Không thể xóa xe. Xe không tồn tại!");
                }
            } else {
                request.setAttribute("DELETE_MESSAGE", "Không tìm thấy ID xe!");
            }

        } catch (NumberFormatException e) {
            log("Invalid CarID format: " + e.toString());
            request.setAttribute("ERROR", "ID xe không hợp lệ!");
        } catch (Exception e) {
            log("Error at DeleteCarController: " + e.toString());
            e.printStackTrace();
            request.setAttribute("ERROR", "Lỗi hệ thống khi xóa xe!");
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
