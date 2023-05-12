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

public class inventory implements Serializable{
  private  int prod_id;
  private  int dept_id;
  private  String prod_name;
  private  String prod_code;

    public inventory(int prod_id, int dept_id, String prod_name, String prod_code) {
        this.prod_id = prod_id;
        this.dept_id = dept_id;
        this.prod_name = prod_name;
        this.prod_code = prod_code;
    }

     public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }
    
    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
 
   

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_code() {
        return prod_code;
    }

    public void setProd_code(String prod_code) {
        this.prod_code = prod_code;
    }

  
}
