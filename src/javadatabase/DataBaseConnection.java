/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author moham
 */
public class DataBaseConnection {
    Connection con;
    String st;
    EmployeeClass emp = null;
    PreparedStatement sta;
    ResultSet rs;
    public static int rowNumber;

public DataBaseConnection() throws SQLException, ClassNotFoundException {
                     String host ="jdbc:postgresql://localhost:5432/ITIDataBase";
                     String username ="postgres";
                     String password = "MohamedAdel@77";
                     con = DriverManager.getConnection(host, username, password);
                        st = new String("Select * from contact");
    }

    public EmployeeClass getFirstEmployee() throws SQLException {

        sta = con.prepareStatement(st, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);;
        rs = sta.executeQuery();
        rowNumber = rs.getRow();
        EmployeeClass emp = null;
        if (rs.first()) {
            emp = new EmployeeClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            rowNumber = rs.getRow();

        } else {
            System.out.println("Not Found");

        }
        con.close();
        return emp;
    }

    public EmployeeClass getLastEmployee() throws SQLException {
        sta = con.prepareStatement(st, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);;
        rs = sta.executeQuery();

        if (rs.last()) {
            emp = new EmployeeClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            rowNumber = rs.getRow();
        } else {
            System.out.println("Not Found");
        }
        con.close();
        return emp;
    }
//

    public EmployeeClass getPreviousEmployee() throws SQLException {
        EmployeeClass emp = null;

        if (rowNumber > 1) {
            sta = con.prepareStatement(st, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);;
            rs = sta.executeQuery();

            if (rs.absolute(rowNumber - 1)) {
                emp = new EmployeeClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                rowNumber = rs.getRow();

            } else {
                System.out.println("Not Found");
            }

        }
        con.close();
        return emp;
    }
//

    public EmployeeClass getNextEmployee() throws SQLException {
        EmployeeClass emp = null;

        if (rowNumber >= 1) {
            sta = con.prepareStatement(st, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);;
            rs = sta.executeQuery();

            if (rs.absolute(rowNumber + 1)) {
                emp = new EmployeeClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                rowNumber = rs.getRow();

            } else {
                System.out.println("Not Found");
            }

        }
        con.close();
        return emp;
    }

    public void addNewRow(EmployeeClass newEmp) throws SQLException {
        if (newEmp != null) {
            String info = "'" + newEmp.fname + "','" + newEmp.mname + "','" + newEmp.lname + "','" + newEmp.email + "','" + newEmp.pno + "'";
            String str = "insert into contact (fname,mname,lname,email,pno) values (" + info + ")";
            PreparedStatement sta = con.prepareStatement(str);
            sta.execute();
            con.close();
        }

    }

    public void updateRow(EmployeeClass newEmp) throws SQLException {
        if (newEmp != null) {
            Integer empid = newEmp.id;
            String str = "update contact set fname='" + newEmp.fname + "'," + "mname='" + newEmp.mname + "'," + "lname='" + newEmp.lname + "',"
                    + "email='" + newEmp.email + "'," + "pno='" + newEmp.pno + "'" + "where id=" + empid.toString();
            PreparedStatement sta = con.prepareStatement(str);
            sta.execute();
            con.close();
        }

    }

    public void DeleteRow(String EmpID) throws SQLException {
        if (EmpID != null) {
            String str = "delete from contact where id=" + EmpID;
            PreparedStatement sta = con.prepareStatement(str);
            sta.execute();
            con.close();
        }

    }

}