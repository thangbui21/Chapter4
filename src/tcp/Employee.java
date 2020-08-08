/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

/**
 *
 * @author Thắng Bùi
 */
public class Employee {

    private String fullName;
    private String dateOfBirth;
    private String department;

    public Employee() {
    }

    public Employee(String fullName, String dateOfBirth, String department) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String showInfo() {
        return "Tên nhân viên: " + fullName + "\n"
                + "Ngày sinh: " + dateOfBirth + "\n"
                + "Chức vụ: " + department + "\n"
                + "------------------------------\n";
    }

    @Override
    public String toString() {
        return "Employee{" + "fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", department=" + department + '}';
    }

}
