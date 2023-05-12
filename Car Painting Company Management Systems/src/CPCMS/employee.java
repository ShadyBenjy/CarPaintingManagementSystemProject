/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CPCMS;

import java.io.Serializable;

/**
 *
 * @author Arshad
 */
public class employee implements Serializable{
  private  int emp_id;
  private  String emp_name;
  private  String emp_surname;
  private  String gender;
  private  String birthday;

    public employee(int emp_id, String emp_name, String emp_surname, String gender, String birthday) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_surname = emp_surname;
        this.gender = gender;
        this.birthday = birthday;
    }


   
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
 
   

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_surname() {
        return emp_surname;
    }

    public void setEmp_surname(String emp_surname) {
        this.emp_surname = emp_surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

 
  
}
