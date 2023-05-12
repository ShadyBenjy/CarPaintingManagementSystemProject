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
public class car implements Serializable{
  private  int car_id;
  private  int cli_id;
  private  String car_name;
  private  String car_date;

    public car(int car_id, int cli_id, String car_name, String car_date) {
        this.car_id = car_id;
        this.cli_id = cli_id;
        this.car_name = car_name;
        this.car_date = car_date;
    }

     public int getCar_id() {
        return cli_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }
    
    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }
 
   

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_date() {
        return car_date;
    }

    public void setCar_date(String car_date) {
        this.car_date = car_date;
    }

  
}