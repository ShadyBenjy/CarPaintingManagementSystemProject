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
public class client implements Serializable{
  private  int cli_id;
  private  String cli_name;
  private  String cli_city;
  private  String cli_contact;

    public client(int cli_id, String cli_name, String cli_city, String cli_contact) {
        this.cli_id = cli_id;
        this.cli_name = cli_name;
        this.cli_city = cli_city;
        this.cli_contact = cli_contact;
    }

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }
 
   

    public String getCli_name() {
        return cli_name;
    }

    public void setCli_name(String cli_name) {
        this.cli_name = cli_name;
    }

    public String getCli_city() {
        return cli_city;
    }

    public void setCli_city(String cli_city) {
        this.cli_city = cli_city;
    }

    public String getCli_contact() {
        return cli_contact;
    }

    public void setCli_contact(String cli_contact) {
        this.cli_contact = cli_contact;
    }
  
}
