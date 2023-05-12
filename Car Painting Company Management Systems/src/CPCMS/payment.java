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
public class payment implements Serializable{
  private  int pay_id;
  private  int cli_id;
  private  String pay_amount;
  private  String pay_date;

    public payment (int pay_id, int cli_id, String pay_amount, String pay_date) {
        this.pay_id = pay_id;
        this.cli_id = cli_id;
        this.pay_amount = pay_amount;
        this.pay_date = pay_date;
    }

     public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }
    
    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }
 
   

    public String getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(String pay_amount) {
        this.pay_amount = pay_amount;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

  
}
