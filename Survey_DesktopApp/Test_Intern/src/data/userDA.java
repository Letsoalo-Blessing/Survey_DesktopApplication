/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author letsoaloblessing2@gmail.com
 */
public class userDA {

    private static Connection myConn;
    private static ArrayList<userDA> arUser = new ArrayList();
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void initConnection() throws DataStorageException {

        final String USERNAME = "root";
        final String PASSWORD = "root";
        final String URL = "jdbc:mysql://localhost/InternTestDB";
        final String Driver = "com.mysql.jdbc.Driver";

        try {
            myConn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Class.forName(Driver);

        } catch (ClassNotFoundException e) {

            throw new DataStorageException("Database is Missing/n" + e.getMessage());

        } catch (SQLException e) {

            throw new DataStorageException("Connection Failed" + e.getMessage());
        }
    }

    public static void addUser(userPD objUser) throws DuplicateException {

        try {

            ps = myConn.prepareStatement("INSERT INTO tbluser(surname,firstname,phone,"
                                        + "date,age,fav_food,option_eat,answer_eat,option_movies,answer_movies,"
                                        + "option_tv,answer_tv,option_radio,answer_radio)"
                    + "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, objUser.getSurname());
            ps.setString(2, objUser.getFirstname());
            ps.setString(3, objUser.getPhone());
            ps.setString(4, objUser.getDate());
            ps.setInt(5, objUser.getAge());
            ps.setString(6, objUser.getFav_food());
            ps.setString(7, objUser.getOption_eat());
            ps.setString(8, objUser.getAnswer_eat());
            ps.setString(9, objUser.getOption_movies());
            ps.setString(10, objUser.getAnswer_movies());
            ps.setString(11, objUser.getOption_tv());
            ps.setString(12, objUser.getAnswer_tv());
            ps.setString(13, objUser.getOption_radio());
            ps.setString(14, objUser.getAnswer_radio());
            ps.executeUpdate();

        } catch (SQLException e) {

            throw new DuplicateException(e.getMessage());

        }
    }
    
    public static int cntSurvey() throws NotFoundException {

        int cntsurv = 0;

        try {

            ps = myConn.prepareStatement("SELECT COUNT(*) FROM tblUser");
            rs = ps.executeQuery();

            while (rs.next()) {

                cntsurv = rs.getInt(1);
            }
        } catch (SQLException e) {

            throw new NotFoundException(e.getMessage());
        }

        return cntsurv;
    }
    public static double AverageAge() throws NotFoundException {

        int avg = 0;

        try {

            ps = myConn.prepareStatement("SELECT AVG(age) FROM tblUser");
            rs = ps.executeQuery();

            while (rs.next()) {

                avg = rs.getInt(1);
            }
        } catch (SQLException e) {

            throw new NotFoundException(e.getMessage());
        }

        return avg;
    }
    
    public static int minAge() throws NotFoundException {

        int age = 0;

        try {

            ps = myConn.prepareStatement("SELECT MIN(age) FROM tblUser");
            rs = ps.executeQuery();

            while (rs.next()) {

                age = rs.getInt(1);
            }
        } catch (SQLException e) {

            throw new NotFoundException(e.getMessage());
        }

        return age;
    }
    
    public static int maxAge() throws NotFoundException {

        int age = 0;

        try {

            ps = myConn.prepareStatement("SELECT MAX(age) FROM tblUser");
            rs = ps.executeQuery();

            while (rs.next()) {

                age = rs.getInt(1);
            }
        } catch (SQLException e) {

            throw new NotFoundException(e.getMessage());
        }

        return age;
    }
    
    public static int cntPizza() throws NotFoundException {

        int cntP = 0;

        try {

            ps = myConn.prepareStatement("SELECT count(*) FROM tblUser WHERE fav_food like 'pizza'");
            rs = ps.executeQuery();

            while (rs.next()) {

                cntP = rs.getInt(1);
            }
        } catch (SQLException e) {

            throw new NotFoundException(e.getMessage());
        }

        return cntP;
    }
    public static int cntPasta() throws NotFoundException {

        int cntP = 0;

        try {

            ps = myConn.prepareStatement("SELECT count(*) FROM tblUser WHERE fav_food like 'pasta'");
            rs = ps.executeQuery();

            while (rs.next()) {

                cntP = rs.getInt(1);
            }
        } catch (SQLException e) {

            throw new NotFoundException(e.getMessage());
        }

        return cntP;
    }
    public static int cntPap() throws NotFoundException {

        int cntP = 0;

        try {

            ps = myConn.prepareStatement("SELECT count(*) FROM tblUser WHERE fav_food like 'pap and wors'");
            rs = ps.executeQuery();

            while (rs.next()) {

                cntP = rs.getInt(1);
            }
        } catch (SQLException e) {

            throw new NotFoundException(e.getMessage());
        }

        return cntP;
    }

    public static void terminate() throws DataStorageException {
        
        try {

            if (myConn != null) {

                myConn.close();
            }
        } catch (SQLException e) {

            throw new DataStorageException(e.getMessage());
        }

    }
}
