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
public class attendance implements Serializable{
    private  int att_id;
    private  int emp_id;
    private  String att_date;
    
    public attendance (int att_id, int emp_id, String att_date) {
        this.att_id = att_id;
        this.emp_id = emp_id;
        this.att_date = att_date;
    }
    
    public int getAtt_id() {
        return att_id;
    }

    public void setAtt_id(int att_id) {
        this.att_id = att_id;
    }
 
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
    
    
    public String getAtt_date() {
        return att_date;
    }
    
    
    public void setAtt_date(String att_date) {
        this.att_date = att_date;
    }
         
    
}

