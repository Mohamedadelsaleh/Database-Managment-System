/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author moham
 */
public class EmployeeClass {
    int id;
    int rowNumber;
    String fname;
    String mname;
    String lname;
    String email;
    String pno;
    public EmployeeClass(int id, String fname, String mname, String lname, String email, String pno) {
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.email = email;
        this.pno = pno;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fname;
    }

    public String getmName() {
        return mname;
    }

    public String getlName() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return pno;
    }



}
