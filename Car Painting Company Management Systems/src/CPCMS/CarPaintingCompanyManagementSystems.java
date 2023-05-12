/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CPCMS;

import com.mysql.cj.protocol.Resultset;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Arshad
 */
public class CarPaintingCompanyManagementSystems {
    
    public static List employee, payment, car, client, department, inventory, attendance;
    public static Connection connection;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        employee = new ArrayList();
        client = new ArrayList();
        department = new ArrayList();
        car = new ArrayList();
        attendance = new ArrayList();
        inventory = new ArrayList();
        payment = new ArrayList();
        
        
        //test_employee();
        //test_department();
        //test_car();
        //test_inventory();
        //test_attendance();
        //test_client();
        //test_payment();
        
        create_employee();
        create_department();
        create_attendance();
        create_car();
        create_client();
        create_payment();
        create_inventory();
        new Menu().setVisible(true);
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpcms","puser", "itec314");
        } catch (SQLException ex) {
          Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
         System.out.printf("\n");
        
    }
    
    public static Boolean check_employee(int emp_id){
      ResultSet res;
      String strSQL;
      Boolean ret=false;
      try {
            strSQL="select count(*) from employees where employee.emp_id = ?";
            
            PreparedStatement prepStatement = connection.prepareStatement(strSQL); 
            prepStatement.setInt(1, emp_id); 
            res = prepStatement.executeQuery();
            
           res.next();
            
           
            if (res.getInt(1)>0) ret=true;
            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
    return ret;
    }

    
    public static void create_employee() {
        
        
        System.out.printf("\n Add_employee()\n\n");
        add_employee(1,"Mike","Luke","Male","21/07/2000");
        add_employee(2,"Lisa","Udoye","Female", "15/11/1999");
        add_employee(3,"Lucas","Sulemane","Male", "11/09/1998");
        System.out.printf("\n List_employee()\n\n");
        list_employees();}

    /*public static void test_employee() {
        try {
        System.out.printf("\n Tests for Class Employee\n\n");
        System.out.printf("\n Add_employee()\n\n");
        add_employee(1,"Mike","Luke","Male","21/07/2000");
        add_employee(2,"Lisa","Udoye","Female", "15/11/1999");
        add_employee(3,"Lucas","Sulemane","Male", "11/09/1998");
        System.out.printf("\n List_employee()\n\n");
        list_employees();
        System.out.printf("\n Edit_employee()\n\n");
        edit_employee(3, "Luke","Sulemane","Male", "11/09/1998");
        System.out.printf("\n List_employee()\n\n");
        list_employees();
        backup_employee();
        
        System.out.printf("\n Delete_employee(1)\n\n");
        delete_employee(1);
        
        System.out.printf("\n List_employee()\n\n");
        list_employees();
        
        retrieve_employee();
        System.out.printf("\n List_employee()\n\n");
        list_employees();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
                }
    }*/

    public static void retrieve_employee() throws IOException, ClassNotFoundException
    {
     File infile  = new File("employee.dat");
     FileInputStream infilestream = new FileInputStream(infile);
     ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
     employee = (ArrayList)inObjectStream.readObject();
     
     inObjectStream.close();
     
    }
    public static void backup_employee() throws IOException
    {
     File outfile  = new File("employee.dat");
     FileOutputStream outfilestream = new FileOutputStream(outfile);
     ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
     
     outObjectStream.writeObject(employee);
     outObjectStream.close();
     
    }
    
    public static void add_employee(int emp_id, String emp_name, String emp_surname, String gender, String birthday) {
            /*employee st =new employee(emp_id, emp_name, emp_surname, gender, birthday);
            employee.add(st);*/
            
            try {
            
            String strSQL = "insert into employee "+
                    "(emp_id, emp_name, emp_surname, gender, "+
                    " birthday) values "+
                    "(?, ?, ?, ?, ?)";
            
            PreparedStatement prepStatement = connection.prepareStatement(strSQL); 
                    
                    prepStatement.setInt(1, emp_id);        
                    prepStatement.setString(2, emp_name); 
                    prepStatement.setString(3, emp_surname); 
                    prepStatement.setString(4, gender);
                    prepStatement.setString(5, birthday);
                    
                    prepStatement.executeUpdate();
                    
             } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void edit_employee(int emp_id, String emp_name, String emp_surname, String gender, String birthday) {
      /*employee st=null;
      Boolean found=false;
      Iterator <employee> itr = employee.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(emp_id==st.getEmp_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          st.setEmp_name(emp_name);
          st.setEmp_surname(emp_surname);
          st.setGender(gender);
          st.setBirthday(birthday);
      }*/
      
       try {
            String strSQL="update employee set std_name=?, "+
                          "std_surname=?, gender=?, "+
                          "birthday=? where std_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(5, emp_id); 
             
            prepStatement.setString(1, emp_name); 
            prepStatement.setString(2, emp_surname); 
            prepStatement.setString(3, gender);
            prepStatement.setString(5, birthday);
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
      }

public static void delete_employee(int emp_id) {
      /*employee st=null;
      Boolean found=false;
      Iterator <employee> itr = employee.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(emp_id==(st.getEmp_id())) {
              found=true;
              break;
          }
      }
      if (found) employee.remove(st);*/
      
       try {
            String strSQL="delete from employee where emp_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(1, emp_id); 
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      }
    
    
    public static void draw_line(int num) {
        String ln="";
        for (int i=0; i<num; i++) ln+="=";
        System.out.printf("\n"+ln);
    }
    
    public static void list_employees() {
      
        ResultSet res;
      String strSQL;
      System.out.printf("\n%10s %10s %15s %12s %12s",
              "Employee Id","Emp. Name", "Emp. Surname", 
              "Gender", "Birthday");
      draw_line(90);

      try {
            strSQL="select * from students";
            Statement statement =
                    connection.createStatement();
             res = statement.executeQuery(strSQL);
             while (res.next()){
                   System.out.printf("\n%10d %10s %15s %12s %12s",
              res.getInt("emp_id"), res.getString("emp_name"), res.getString("emp_surname"),
              res.getString("gender"), res.getString("birthday"));  
             }
                    
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
        /*employee st;
      Iterator <employee> itr = employee.iterator();
      System.out.printf("\n%2s %10s %15s %10s  %12s",
              "Id", "Emp. Name", "Emp. Surname", 
              "Gender", "Birthday");
        draw_line(79);
        
      while (itr.hasNext()) {
          st = itr.next(); 
          System.out.printf("\n%2d %10s %15s %10s %12s", 
              st.getEmp_id(), 
              st.getEmp_name(), st.getEmp_surname(),
              st.getGender(), st.getBirthday());
      }
      draw_line(79);*/
        
 
    }
    
    public static Boolean check_department(int dept_id){
      ResultSet res;
      String strSQL;
      Boolean ret=false;
      try {
            strSQL="select count(*) from department where department.dept_id = ?";
            
            PreparedStatement prepStatement=connection.prepareStatement(strSQL); 
            prepStatement.setInt(1, dept_id); 
            res = prepStatement.executeQuery();
            
           res.next();
            
           
            if (res.getInt(1)>0) ret=true;
            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
    return ret;
    }
    
     public static void create_department() {
     
        System.out.printf("\n Tests for Class Department\n\n");
        System.out.printf("\n Add_Department()\n\n");
        add_department(1, "Accounting");
        add_department(2, "Painting");
	add_department(3, "Cleaning");
        System.out.printf("\n List_department()\n\n");
        list_departments();}

 /*public static void test_department() {
     try{
        System.out.printf("\n Tests for Class Department\n\n");
        System.out.printf("\n Add_Department()\n\n");
        add_department(1, "Accounting");
        add_department(2, "Painting");
	add_department(3, "Cleaning");
        System.out.printf("\n List_department()\n\n");
        list_departments();
        System.out.printf("\n Edit_department()\n\n");
        edit_department(2, "Paint Staff");
        System.out.printf("\n List_department()\n\n");
        list_departments();
        backup_department();
        System.out.printf("\n Delete_department(3)\n\n");
        delete_department(2);
        System.out.printf("\n List_department()\n\n");
        list_departments();
        retrieve_department();
        System.out.printf("\n List_department()\n\n");
        list_departments();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
                }
    }*/

    public static void retrieve_department() throws IOException, ClassNotFoundException
    {
     File infile  = new File("department.dat");
     FileInputStream infilestream = new FileInputStream(infile);
     ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
     department = (ArrayList)inObjectStream.readObject();
     
     inObjectStream.close();
     
    }

  public static void backup_department() throws IOException
    {
     File outfile  = new File("department.dat");
     FileOutputStream outfilestream = new FileOutputStream(outfile);
     ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
     
     outObjectStream.writeObject(department);
     outObjectStream.close();
     
    }

 public static void add_department(int dept_id, String dept_name) {
            /*department st =new department(dept_id, dept_name);
            department.add(st);*/
            
             try {
            
            String strSQL = "insert into departments "+
                    "(dept_id, dept_name) values "+
                    "(?, ?)";
            
            PreparedStatement prepStatement=            
                    connection.prepareStatement(strSQL); 
                    
                    prepStatement.setInt(1, dept_id);  
                    prepStatement.setString(2, dept_name); 
                    
                    
                    prepStatement.executeUpdate();
                    
             } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
  
  public static void edit_department(int dept_id, String dept_name) {
      /*department st=null;
      Boolean found=false;
      Iterator <department> itr = department.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(dept_id==st.getDept_id ()) {
              found=true;
              break;
          }
      }
      if (found) {
          st.setDept_name(dept_name);
        

      }*/
      
      
       try {
            String strSQL="update departments set dept_name=? where dept_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(2, dept_id); 
            prepStatement.setString(1, dept_name); 
           
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
      }

public static void delete_department( int dept_id) {
      /*department st=null;
      Boolean found=false;
      Iterator <department> itr = department.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(dept_id==(st.getDept_id())) {
              found=true;
              break;
          }
      }
      if (found) department.remove(st);*/
      
       try {
            String strSQL="delete from department where dept_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(1, dept_id); 
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      }
    
    
    public static void list_departments() {
      
        ResultSet res;
      String strSQL;
      System.out.printf("\n%10s %10s",
              "Department Id", "Department Name");
      draw_line(90);

      try {
            strSQL="select * from department";
            Statement statement =
                    connection.createStatement();
             res = statement.executeQuery(strSQL);
             while (res.next()){
                   System.out.printf("\n%10d %10s",
              res.getInt("dept_id"), res.getString("dept_name"));  
             }
                    
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
        /*department st;
      Iterator <department> itr = department.iterator();
      System.out.printf("\n%2s %10s",
              "Id", "Dept. Name");
        draw_line(50);
        
      while (itr.hasNext()) {
          st = itr.next(); 
          System.out.printf("\n%2d %10s", 
              st.getDept_id(),
              st.getDept_name());
      }
      draw_line(50);*/
        
    }
    
    public static Boolean check_attendance(int att_id){
      ResultSet res;
      String strSQL;
      Boolean ret=false;
      try {
            strSQL="select count(*) from attendance where attendance.att_id = ?";
            
            PreparedStatement prepStatement=connection.prepareStatement(strSQL); 
            prepStatement.setInt(1, att_id); 
            res = prepStatement.executeQuery();
            
           res.next();
            
           
            if (res.getInt(1)>0) ret=true;
            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
    return ret;
    }

    
    public static void create_attendance() {
        System.out.printf("\n Tests for Class Attendance\n\n");
        System.out.printf("\n Add_attendance()\n\n");
        add_attendance(1, 1, "19/04/2022");
        add_attendance(2, 2, "19/04/2022");
        add_attendance(3, 3, "19/04/2021");
        System.out.printf("\n List_attendance()\n\n");
        list_attendance();
    }
        
/*public static void test_attendance() {
        try {
        System.out.printf("\n Tests for Class Attendance\n\n");
        System.out.printf("\n Add_attendance()\n\n");
        add_attendance(1, 1, "19/04/2022");
        add_attendance(2, 2, "19/04/2022");
        add_attendance(3, 3, "19/04/2021");

        System.out.printf("\n List_attendance()\n\n");
        list_attendance();
        System.out.printf("\n Edit_attendance()\n\n");
        edit_attendance(3, 2, "23/04/2021");
        System.out.printf("\n List_attendance()\n\n");
        list_attendance();
        backup_attendance();
        
        System.out.printf("\n Delete_attendance(4)\n\n");
        delete_attendance(2);
        
        System.out.printf("\n List_attendance()\n\n");
        list_attendance();
        
        retrieve_attendance();
        System.out.printf("\n List_attendance()\n\n");
        list_attendance();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
                }
    }*/

     public static void retrieve_attendance() throws IOException, ClassNotFoundException{
     File infile  = new File("attendance.dat");
     FileInputStream infilestream = new FileInputStream(infile);
     ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
     attendance = (ArrayList)inObjectStream.readObject();
     
     inObjectStream.close();
     
    }

     public static void backup_attendance() throws IOException{
     File outfile  = new File("attendance.dat");
     FileOutputStream outfilestream = new FileOutputStream(outfile);
     ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
     
     outObjectStream.writeObject(attendance);
     outObjectStream.close();
     
    }

    public static void add_attendance(int att_id, int emp_id, String att_date){
        /*attendance st =new attendance(att_id, emp_id, att_date);
        attendance.add(st);*/
        
         try {
            
            String strSQL = "insert into attendance "+
                    "(att_id, emp_id, att_date) values "+
                    "(?, ?, ?)";
            
            PreparedStatement prepStatement=            
                    connection.prepareStatement(strSQL); 
                    
                    prepStatement.setInt(1, att_id); 
                    prepStatement.setInt(2, emp_id);  
                    prepStatement.setString(3, att_date); 
                    
                    
                    prepStatement.executeUpdate();
                    
             } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public static void edit_attendance(int att_id, int emp_id, String att_date) {
      /*attendance st=null;
      Boolean found=false;
      Iterator <attendance> itr = attendance.iterator();

      while (itr.hasNext()) {
          st = itr.next(); 
          if(att_id==st.getAtt_id ()) {
              found=true;
              break;
          }
      }
      if (found) {
          st.setEmp_id(emp_id);
          st.setAtt_date(att_date);
      }*/
      
      
      try {
            String strSQL="update attendance set emp_id=?, att_date=? where att_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(3, att_id); 
            prepStatement.setInt(1, emp_id);  
            prepStatement.setString(2, att_date); 
            
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
      }

   public static void delete_attendance(int att_id) {
      /*attendance st=null;
      Boolean found=false;
      Iterator <attendance> itr = attendance.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(att_id==(st.getAtt_id())) {
              found=true;
              break;
          }
      }
      if (found) attendance.remove(st);*/
      
      try {
            String strSQL="delete from attendance where att_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(1, att_id); 
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    
   
    
    public static void list_attendance() {
      /*attendance st;
      Iterator <attendance> itr = attendance.iterator();
      System.out.printf("\n%2s %5s %15s", "ID", "Emp ID","Att Date");
        draw_line(70);
        
      while (itr.hasNext()) {
          st = itr.next(); 
          System.out.printf("\n%2d %5d %15s", 
              st.getAtt_id(), st.getEmp_id(), st.getAtt_date());
      }
      draw_line(70);*/
        
      ResultSet res;
      String strSQL;
      System.out.printf("\n%10s %10s %12s",
              "Attendance Id", "Employee Id", "Attendance Date");
      draw_line(70);

      try {
            strSQL="select * from departments";
            Statement statement =
                    connection.createStatement();
             res = statement.executeQuery(strSQL);
             while (res.next()){
                   System.out.printf("\n%10d %10s  %12s",
              res.getInt("att_id"), res.getInt("emp_id"), 
              res.getString("att_date"));  
             }
                    
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static Boolean check_car(int car_id){
      ResultSet res;
      String strSQL;
      Boolean ret=false;
      try {
            strSQL="select count(*) from car where cars.car_id = ?";
            
            PreparedStatement prepStatement=connection.prepareStatement(strSQL); 
            prepStatement.setInt(1, car_id); 
            res = prepStatement.executeQuery();
            
           res.next();
            
           
            if (res.getInt(1)>0) ret=true;
            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
    return ret;
    }

    public static void create_car() {
      
       
        System.out.printf("\n Add_car()\n\n");
        add_car(1, 1, "11/05/2022", "Ford");
        add_car(2, 1, "11/05/2022", "Audi R8");
        add_car(3, 2, "13/05/2022", "Toyota D4D");

        System.out.printf("\n List_car()\n\n");
        list_cars();
    }
 
    /*public static void test_car() {
        try {
        System.out.printf("\n Tests for Class Car\n\n");
        System.out.printf("\n Add_car()\n\n");
        add_car(1, 1, "11/05/2022", "Ford");
        add_car(2, 1, "11/05/2022", "Audi R8");
        add_car(3, 2, "13/05/2022", "Toyota D4D");

        System.out.printf("\n List_car()\n\n");
        list_cars();
        System.out.printf("\n Edit_car()\n\n");
        edit_car(1, 3, "11/05/2022", "Ford Ranger");
                
        System.out.printf("\n List_car()\n\n");
        list_cars();
        backup_car();
        
        System.out.printf("\n Delete_car(2)\n\n");
        delete_car(2);
        
        System.out.printf("\n List_car()\n\n");
        list_cars();
        
        retrieve_car();
        System.out.printf("\n List_car()\n\n");
        list_cars();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
                }
    }*/
    
    public static void retrieve_car() throws IOException, ClassNotFoundException
    {
     File infile  = new File("car.dat");
     FileInputStream infilestream = new FileInputStream(infile);
     ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
     car = (ArrayList)inObjectStream.readObject();
     
     inObjectStream.close();
     
    }
    public static void backup_car() throws IOException
    {
     File outfile  = new File("car.dat");
     FileOutputStream outfilestream = new FileOutputStream(outfile);
     ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
     
     outObjectStream.writeObject(car);
     outObjectStream.close();
     
    }
    
    public static void add_car(int car_id, int cli_id, String car_name, String car_date) {
            /*car st =new car(car_id, cli_id, car_name, car_date);
            car.add(st);*/
            
            try {
            
            String strSQL = "insert into car "+
                    "(car_id, cli_id, car_name, car_date) values "+
                    "(?, ?, ?, ?)";
            
            PreparedStatement prepStatement=            
                    connection.prepareStatement(strSQL); 
                    
                    prepStatement.setInt(1, car_id); 
                    prepStatement.setInt(2, cli_id); 
                    prepStatement.setString(3, car_name); 
                    prepStatement.setString(4, car_date); 

                    
                    prepStatement.executeUpdate();
                    
             } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      public static void edit_car(int car_id, int cli_id, String car_name, String car_date) {
      /*car st=null;
      Boolean found=false;
      Iterator <car> itr = car.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(car_id==st.getCar_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          st.setCli_id(cli_id);
          st.setCar_name(car_name);
          st.setCar_date(car_date);
          
      }*/
      
      try {
            String strSQL="update car set cli_id=?, car_name=?, "+
                          "car_date=? where car_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(4, car_id); 
            prepStatement.setInt(1, cli_id); 
            prepStatement.setString(2, car_name); 
            prepStatement.setString(3, car_date); 
            
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }

      }

public static void delete_car(int car_id) {
      /*car st=null;
      Boolean found=false;
      Iterator <car> itr = car.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(car_id==(st.getCar_id())) {
              found=true;
              break;
          }
      }
      if (found) car.remove(st);*/
      
      try {
            String strSQL="delete from car where car_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(1, car_id); 
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }

      }
  
    
    public static void list_cars() {
      
        
        
        /*car st;
      Iterator <car> itr = car.iterator();
      System.out.printf("\n%2s %5s %15s %12s",
              "Id", "Client Id","Car Name", "Car date" 
             );
        draw_line(79);
        
      while (itr.hasNext()) {
          st = itr.next(); 
          System.out.printf("\n%2d %4d %15s %12s", 
              st.getCar_id(), st.getCli_id(), 
              st.getCar_name(), st.getCar_date());      }
      draw_line(79);*/
        
        ResultSet res;
      String strSQL;
      System.out.printf("\n%10s %10s %15s %15s",
              "Car Id", "Cli. Id", "Car. name", 
              "Car. date");
      draw_line(79);

      try {
            strSQL="select * from cars";
            Statement statement =
                    connection.createStatement();
             res = statement.executeQuery(strSQL);
             while (res.next()){
                   System.out.printf("\n%10d %10s %15s %15s",
              res.getInt("car_id"), res.getInt("cli_id"), 
              res.getString("car_name"), res.getString("car_date"));  
             }
                    
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    
    

    public static Boolean check_client(int cli_id){
      ResultSet res;
      String strSQL;
      Boolean ret=false;
      try {
            strSQL="select count(*) from clients where clients.cli_id = ?";
            
            PreparedStatement prepStatement=connection.prepareStatement(strSQL); 
            prepStatement.setInt(1, cli_id); 
            res = prepStatement.executeQuery();
            
           res.next();
            
           
            if (res.getInt(1)>0) ret=true;
            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
    return ret;
    }

    
     public static void create_client() {
      
        System.out.printf("\n Add_client()\n\n");
        add_client(1, "Jorge", "Famagusta", "jorgem@gmail.com");
        add_client(2, "Philip", "Nicosia", "5334555461");
        add_client(3, "Mike", "Girne", "5424356814");
        
        System.out.printf("\n List_client()\n\n");
        list_clients();}
     
    /*public static void test_client() {
        try {
        System.out.printf("\n Tests for Class Client\n\n");
        System.out.printf("\n Add_client()\n\n");
        add_client(1, "Jorge", "Famagusta", "jorgem@gmail.com ");
        add_client(2, "Philip", "Nicosia", "5334555461");
        add_client(3, "Mike", "Girne", "5424356814");
        
        System.out.printf("\n List_client()\n\n");
        list_clients();
        System.out.printf("\n Edit_client()\n\n");
        edit_client(1, "Jorge", "Famagusta", "5424467277");
        System.out.printf("\n List_client()\n\n");
        list_clients();
        backup_client();
        
        System.out.printf("\n Delete_client(2)\n\n");
        delete_client(2);
        
        System.out.printf("\n List_client()\n\n");
        list_clients();
        
        retrieve_client();
        System.out.printf("\n List_client()\n\n");
        list_clients();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
                }
    }
    
    public static void retrieve_client() throws IOException, ClassNotFoundException
    {
     File infile  = new File("client.dat");
     FileInputStream infilestream = new FileInputStream(infile);
     ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
     client = (ArrayList)inObjectStream.readObject();
     
     inObjectStream.close();
     
    }
    public static void backup_client() throws IOException
    {
     File outfile  = new File("client.dat");
     FileOutputStream outfilestream = new FileOutputStream(outfile);
     ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
     
     outObjectStream.writeObject(client);
     outObjectStream.close();
     
    }*/
    
    public static void add_client(int cli_id, String cli_name, String cli_city,
            String cli_contact) {
            /*client st =new client(cli_id, cli_name, cli_city,
                                    cli_contact);
            client.add(st);*/
            
            try {
            
            String strSQL = "insert into client "+
                    "(cli_id, cli_name, cli_city, cli_contact) values "+
                    "(?, ?, ?, ?)";
            
            PreparedStatement prepStatement=            
                    connection.prepareStatement(strSQL); 
                    
                    prepStatement.setInt(1, cli_id); 
                    prepStatement.setString(2, cli_name); 
                    prepStatement.setString(3, cli_city); 
                    prepStatement.setString(4, cli_contact); 

                    
                    prepStatement.executeUpdate();
                    
             } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      public static void edit_client(int cli_id, String cli_name, String cli_city, String cli_contact ) {
      /*client st=null;
      Boolean found=false;
      Iterator <client> itr = client.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(cli_id==st.getCli_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          
          st.setCli_name(cli_name);
          st.setCli_city(cli_city);
          
          st.setCli_contact(cli_contact);
          
      }*/
      
      try {
            String strSQL="update client set cli_name=?, "+
                          "cli_city=?, cli_contact=? where cli_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(4, cli_id); 
            prepStatement.setString(1, cli_name); 
            prepStatement.setString(2, cli_city); 
            prepStatement.setString(3, cli_contact); 
            
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }

      }

public static void delete_client(int cli_id) {
      /*client st=null;
      Boolean found=false;
      Iterator <client> itr = client.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(cli_id==(st.getCli_id())) {
              found=true;
              break;
          }
      }
      if (found) client.remove(st);*/
      
      try {
            String strSQL="delete from client where cli_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(1, cli_id); 
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    
    
    
    public static void list_clients() {
      /*client st;
      Iterator <client> itr = client.iterator();
      System.out.printf("\n%2s %10s %12s %12s",
              "Id", "Cli. Name", "Cli. City", 
              "Contact");
        draw_line(79);
        
      while (itr.hasNext()) {
          st = itr.next(); 
          System.out.printf("\n%2d %10s %12s %12s", 
              st.getCli_id(), 
              st.getCli_name(), st.getCli_city(),
              st.getCli_contact());
      }
      draw_line(79);*/
      
      ResultSet res;
      String strSQL;
      System.out.printf("\n%10s %10s %15s %15s",
              "Client Id", "Cli. Name", "Cli. City", 
              "Cli. Contact");
      draw_line(79);

      try {
            strSQL="select * from client";
            Statement statement =
                    connection.createStatement();
             res = statement.executeQuery(strSQL);
             while (res.next()){
                   System.out.printf("\n%10d %10s %15s %15s",
              res.getInt("cli_id"), res.getString("cli_name"), 
              res.getString("cli_city"), res.getString("cli_contact"));  
             }
                    
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }
    
    public static Boolean check_inventory(int prod_id){
      ResultSet res;
      String strSQL;
      Boolean ret=false;
      try {
            strSQL="select count(*) from inventory where inventory.prod_id = ?";
            
            PreparedStatement prepStatement=connection.prepareStatement(strSQL); 
            prepStatement.setInt(1, prod_id); 
            res = prepStatement.executeQuery();
            
           res.next();
            
           
            if (res.getInt(1)>0) ret=true;
            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
    return ret;
    }

    public static void create_inventory() {
        
        System.out.printf("\n Add_inventory()\n\n");
        add_inventory(1, 1,"I14", "print ink");
        add_inventory(2, 1, "C43", "Blue paint");
        System.out.printf("\n List_inventory()\n\n");
        list_inventory();}

    /*public static void test_inventory() {
        try {
        System.out.printf("\n Tests for Class Inventory\n\n");
        System.out.printf("\n Add_inventory()\n\n");
        add_inventory(1, 1,"I14", "print ink");
        add_inventory(2, 1, "C43", "Blue paint");
        System.out.printf("\n List_inventory()\n\n");
        list_inventory();
        System.out.printf("\n Edit_inventory()\n\n");
        edit_inventory(2,1, "B43", "Back paint");
        System.out.printf("\n List_inventory()\n\n");
        list_inventory();
        backup_inventory();
        
        System.out.printf("\n Delete_inventory(1)\n\n");
        delete_inventory(1);
        
        System.out.printf("\n List_inventory()\n\n");
        list_inventory();
        
        retrieve_inventory();
        System.out.printf("\n List_inventory()\n\n");
        list_inventory();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
                }
    }*/
    
    public static void retrieve_inventory() throws IOException, ClassNotFoundException
    {
     File infile  = new File("inventory.dat");
     FileInputStream infilestream = new FileInputStream(infile);
     ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
     inventory = (ArrayList)inObjectStream.readObject();
     
     inObjectStream.close();
     
    }
    public static void backup_inventory() throws IOException
    {
     File outfile  = new File("inventory.dat");
     FileOutputStream outfilestream = new FileOutputStream(outfile);
     ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
     
     outObjectStream.writeObject(inventory);
     outObjectStream.close();
     
    }
    
    public static void add_inventory(int prod_id, int dept_id, String prod_code, String prod_name) {
            /*inventory st =new inventory(prod_id, dept_id, prod_code, prod_name);
            inventory.add(st);*/
            
            try {
            
            String strSQL = "insert into inventorys "+
                    "(prod_id, dept_id, prod_code, prod_name) values "+
                    "(?, ?, ?, ?)";
            
            PreparedStatement prepStatement=            
                    connection.prepareStatement(strSQL); 
                    
                    prepStatement.setInt(1, prod_id); 
                    prepStatement.setInt(2, dept_id); 
                    prepStatement.setString(3, prod_code); 
                    prepStatement.setString(4, prod_name); 

                    
                    prepStatement.executeUpdate();
                    
             } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      public static void edit_inventory(int prod_id, int dept_id, String prod_code, String prod_name) {
      /*inventory st=null;
      Boolean found=false;
      Iterator <inventory> itr = inventory.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(prod_id==st.getProd_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          st.setDept_id(dept_id);
          st.setProd_code(prod_code);
          st.setProd_name(prod_name);
          
      }*/
      
      try {
            String strSQL="update inventory set dept_id=?, "+
                          "prod_code=?, prod_name=? where prod_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(4, prod_id); 
            prepStatement.setInt(1, dept_id); 
            prepStatement.setString(2, prod_code); 
            prepStatement.setString(3, prod_name); 
            
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }

      
      }public static void delete_inventory(int prod_id) {

      /*inventory st=null;
      Boolean found=false;
      Iterator <inventory> itr = inventory.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(prod_id==(st.getProd_id())) {
              found=true;
              break;
          }
      }
      if (found) inventory.remove(st);*/
      
      try {
            String strSQL="delete from inventory where prod_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(1, prod_id); 
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    
    
    public static void list_inventory() {
      /*inventory st;
      Iterator <inventory> itr = inventory.iterator();
      System.out.printf("\n%3s %10s %15s %12s",
              "Id", "Dept Id","Prod. code", "Prod. name");
        draw_line(79);
        
      while (itr.hasNext()) {
          st = itr.next(); 
          System.out.printf("\n%2d  %10d %15s %12s", 
              st.getProd_id(), st.getDept_id(), 
              st.getProd_code(), st.getProd_name()
              );
      }
      draw_line(79);*/
      
      ResultSet res;
      String strSQL;
      System.out.printf("\n%10s %10s %15s %15s",
              "Prod Id", "Dept. Id", "Prod. Code", 
              "Prod. Name");
      draw_line(79);

      try {
            strSQL="select * from inventory";
            Statement statement =
                    connection.createStatement();
             res = statement.executeQuery(strSQL);
             while (res.next()){
                   System.out.printf("\n%10d %10s %15s %15s",
              res.getInt("prod_id"), res.getInt("dept_id"), 
              res.getString("prod_code"), res.getString("prod_name"));  
             }
                    
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }
    
    public static Boolean check_payment(int pay_id){
      ResultSet res;
      String strSQL;
      Boolean ret=false;
      try {
            strSQL="select count(*) from payment where payment.pay_id = ?";
            
            PreparedStatement prepStatement=connection.prepareStatement(strSQL); 
            prepStatement.setInt(1, pay_id); 
            res = prepStatement.executeQuery();
            
           res.next();
            
           
            if (res.getInt(1)>0) ret=true;
            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
    return ret;
    }


     public static void create_payment() {
        
        System.out.printf("\n Add_payment()\n\n");
        add_payment(1, 1, "1900tl", "09/04/2021");
        add_payment(3, 2, "2000tl", "09/04/2021");
        add_payment(2, 2, "2100tl", "09/04/2021");
        System.out.printf("\n List_payment()\n\n");
        list_payments();
     }
        
    /*public static void test_payment() {
        try {
        System.out.printf("\n Tests for Class Payment\n\n");
        System.out.printf("\n Add_payment()\n\n");
        add_payment(1, 1, "1900tl", "09/04/2021");
        add_payment(3, 2, "2000tl", "09/04/2021");
        add_payment(2, 2, "2100tl", "09/04/2021");
        System.out.printf("\n List_payment()\n\n");
        list_payments();
        System.out.printf("\n Edit_payment()\n\n");
        edit_payment(3, 3, "2400tl", "11/04/2021");
        System.out.printf("\n List_payment()\n\n");
        list_payments();
        backup_payment();
        
        System.out.printf("\n Delete_payment(2)\n\n");
        delete_payment(2);
        
        System.out.printf("\n List_payment()\n\n");
        list_payments();
        
        retrieve_payment();
        System.out.printf("\n List_payment()\n\n");
        list_payments();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
                }
    }*/
    
    public static void retrieve_payment() throws IOException, ClassNotFoundException
    {
     File infile  = new File("payment.dat");
     FileInputStream infilestream = new FileInputStream(infile);
     ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
     payment = (ArrayList)inObjectStream.readObject();
     
     inObjectStream.close();
     
    }
    public static void backup_payment() throws IOException
    {
     File outfile  = new File("payment.dat");
     FileOutputStream outfilestream = new FileOutputStream(outfile);
     ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
     
     outObjectStream.writeObject(payment);
     outObjectStream.close();
     
    }
    
    public static void add_payment(int pay_id, int cli_id, String pay_amount,  String pay_date) {
            /*payment st =new payment(pay_id, cli_id, pay_amount, pay_date);
            payment.add(st);*/
            
            try {
            
            String strSQL = "insert into payment "+
                    "(pay_id, cli_id, pay_amount, pay_date) values "+
                    "(?, ?, ?, ?)";
            
            PreparedStatement prepStatement=            
                    connection.prepareStatement(strSQL); 
                    
                    prepStatement.setInt(1, pay_id); 
                    prepStatement.setInt(2, cli_id); 
                    prepStatement.setString(3, pay_amount); 
                    prepStatement.setString(4, pay_date); 

                    
                    prepStatement.executeUpdate();
                    
             } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      public static void edit_payment(int pay_id, int cli_id, String pay_amount, String pay_date) {
      /*payment st=null;
      Boolean found=false;
      Iterator <payment> itr = payment.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(pay_id==st.getPay_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          st.setCli_id(cli_id);
          st.setPay_amount(pay_amount);
          st.setPay_date(pay_date);
          
      }*/
      
               try {
            String strSQL="update payment set cli_id=?, "+
                          "pay_amount=?, pay_date=? where pay_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(4, pay_id); 
            prepStatement.setInt(1, cli_id); 
            prepStatement.setString(2, pay_amount); 
            prepStatement.setString(3, pay_date); 
            
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }

      }

public static void delete_payment(int pay_id) {
      /*payment st=null;
      Boolean found=false;
      Iterator <payment> itr = payment.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(pay_id==(st.getPay_id())) {
              found=true;
              break;
          }
      }
      if (found) payment.remove(st);*/
      
      try {
            String strSQL="delete from payment where pay_id=?";
            PreparedStatement prepStatement =
                    connection.prepareStatement(strSQL);

            prepStatement.setInt(1, pay_id); 
                    
            prepStatement.executeUpdate();            
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    
 
    
    public static void list_payments() {
      /*payment st;
      Iterator <payment> itr = payment.iterator();
      System.out.printf("\n%2s %10s %15s %15s",
              "Id", "Cli. ID","Pay Amount", "Pay date");
        draw_line(79);
        
      while (itr.hasNext()) {
          st = itr.next(); 
          System.out.printf("\n%2d %10d %15s %15s", 
              st.getPay_id(), st.getCli_id(), 
              st.getPay_amount(), st.getPay_date ());
      }
      draw_line(79);*/
      
      ResultSet res;
      String strSQL;
      System.out.printf("\n%10s %10s %15s %15s",
              "Payment Id", "Cli. Id", "Pay. amount", 
              "Pay. Date");
      draw_line(79);

      try {
            strSQL="select * from payment";
            Statement statement =
                    connection.createStatement();
             res = statement.executeQuery(strSQL);
             while (res.next()){
                   System.out.printf("\n%10d %10s %15s %15s",
              res.getInt("pay_id"), res.getInt("cli_id"), 
              res.getString("pay_amount"), res.getString("pay_date"));  
             }
                    
            } catch (SQLException ex) {
            Logger.getLogger(CarPaintingCompanyManagementSystems.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }




    
}
