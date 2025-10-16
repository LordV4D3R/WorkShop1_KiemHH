/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Vader
 */
public class CarDAO {

    private static final String GET_ALL_CARS = "SELECT carID, carName, manufacturer, price, releasedYear FROM Cars";
    private static final String ADD_CAR = "INSERT INTO Cars(carID, carName, manufacturer, price, releasedYear) VALUES(?,?,?,?,?)";
    private static final String DETAIL_CAR = "SELECT carID, carName, manufacturer, price, releasedYear FROM Cars WHERE CarID = ?";
    private static final String UPDATE_CAR = "UPDATE Cars SET carName=?, manufacturer=?, price=?, releasedYear=? WHERE carID=?";
    private static final String DELETE_CAR = "DELETE FROM Cars WHERE carID=?";

    public List<CarDTO> getAllCars() throws SQLException {
        List<CarDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_CARS);
                rs = ptm.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("carID");
                    String carName = rs.getString("carName");
                    String manufacturer = rs.getString("manufacturer");
                    double price = rs.getDouble("price");
                    int releasedYear = rs.getInt("releasedYear");
                    list.add(new CarDTO(id, carName, manufacturer, price, releasedYear));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean addCar(int cardID, String carName, String manufacturer, double price, int releasedYear) throws SQLException {
        boolean result = false; // đặt kết quả mặc định là chưa thành công để trả return
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_CAR);
                ptm.setInt(1, cardID);
                ptm.setString(2, carName);
                ptm.setString(3, manufacturer);
                ptm.setDouble(4, price);
                ptm.setInt(5, releasedYear);

                int rows = ptm.executeUpdate(); //chạy insert vào DB add dữ liệu mới register.
                if (rows > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public CarDTO carDetails(int carID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        CarDTO car = new CarDTO();

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DETAIL_CAR);
                ptm.setInt(1, carID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("carID");
                    String carName = rs.getString("carName");
                    String manufacturer = rs.getString("manufacturer");
                    double price = rs.getDouble("price");
                    int releasedYear = rs.getInt("releasedYear");
                    car = new CarDTO(id, carName, manufacturer, price, releasedYear);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return car;
    }

    public boolean updateCar(int carID, String carName, String manufacturer, double price, int releasedYear) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_CAR);

                // Set các giá trị mới
                ptm.setString(1, carName);
                ptm.setString(2, manufacturer);
                ptm.setDouble(3, price);
                ptm.setInt(4, releasedYear);

                // Set WHERE clause - carID để xác định record cần update
                ptm.setInt(5, carID);

                // Execute update
                int rows = ptm.executeUpdate();
                if (rows > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return result;
    }

    public boolean deleteCar(int carID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_CAR);

                // Chỉ cần set carID cho WHERE clause
                ptm.setInt(1, carID);

                // Execute delete
                int rows = ptm.executeUpdate();
                if (rows > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return result;
    }
}
