/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBController;

import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class DataBaseConnector {
    private static DataBaseConnector connector= null;
    
    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
    private static final String PASSWORD = "";
//    private static final String CONN_STRING = "jdbc:mysql://localhost:3333/sales_inventory";  
    private static final String CONN_STRING = "jdbc:mysql://localhost/salesinventory";  
    Connection conn = null;
    Statement statement = null;
    ResultSet rst = null;
    PreparedStatement pst = null;
       
    public Connection startConnection() throws SQLException{       
        
                
       
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
            statement = conn.createStatement();
            
            return conn;
        
    }
    
    public void createTable(){
        String sql = " create table tutorials_tbl(\n" +
"   tutorial_id INT NOT NULL AUTO_INCREMENT,\n" +
"   tutorial_title VARCHAR(100) NOT NULL,\n" +
"   tutorial_author VARCHAR(40) NOT NULL,\n" +
"   submission_date DATE,\n" +
"   PRIMARY KEY ( tutorial_id )\n" +
"); ";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public String retreveLastRecord(String tableName,String coloumn,String orderBy){
       String sql = "SELECT "+coloumn+" FROM "+tableName+" ORDER BY "+orderBy+" DESC LIMIT 1;" ;
        
        String ID=null;
       try {
            statement = conn.createStatement();
            rst = statement.executeQuery(sql);
            if(rst.next()){
                ID = rst.getString(coloumn);         
            }else if(tableName == "users"){
                ID = "U000";
            }else if(tableName == "Orders"){
                ID = "A0000";
            }                      
            return ID;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "LastRecordRetreval Error" + ex.getMessage());
        }
        return null;    
    }
    
    public boolean insertRecord(String tableName,ArrayList list){
        String values = "" ;
        
//        for(int counter = 0;counter<list.size();counter++){
//            values+="\"";
//            values+=list.get(counter);
//            values+="\"";
//            if(counter <list.size()-1){
//                values+=",";
//            }
//        }

        for (int i = 0; i < list.size(); i++) {
             
             values+="?";
             
             if (i < list.size() - 1) {
                values+=",";
            }
        }
        
        String sql = "INSERT INTO "+tableName+" values("+values+")";
        System.out.println("SQL : "+sql);
        
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                pst.setString(i+1,String.valueOf(list.get(i)));
            }
//            statement.executeUpdate(sql);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in insertion to Table : "+tableName+" "+ex.getMessage() );
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
    public boolean insertRecordColoumnCount(String tableName,ArrayList list,ArrayList list2){
        String values2 = "" ;
        String values1 = "";
        
        for (int i = 0; i < list2.size(); i++) {
            values1+=list2.get(i);
            if(i <list2.size()-1){
                values1+=",";
            }
            
        }
        
        for(int counter = 0;counter<list.size();counter++){
            values2+="\"";
            values2+=list.get(counter);
            values2+="\"";
            if(counter <list.size()-1){
                values2+=",";
            }
        }
        
        
        
        
        String sql = "INSERT INTO "+tableName+"("+values1+") values("+values2+")";
        System.out.println("SQL : "+sql);
        try {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in insertion to Table : "+tableName+" "+ex.getMessage() );
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
    public ArrayList retreveDataColumn(String tableName,String coloumnName){
        String sql = "SELECT "+coloumnName+" from "+tableName+" ";
        
        try {
            statement = conn.createStatement();
            rst = statement.executeQuery(sql);
            ArrayList list = new ArrayList();
            while(rst.next()){
                list.add(rst.getString(coloumnName));                
            }
           
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error in retreveDataColoumn "+tableName+" :"+ex.getMessage());
        }
        
        return null;
        
        
    }
    
    public String getRelavantRecord(String tableName,String columnName1,String columnName2,String value){
        String sql = "Select "+columnName1+" from "+tableName+" where "+columnName2+" like "+"\""+value+"\"";
        
        
        String record=null;
        try {
            statement = conn.createStatement();
            rst = statement.executeQuery(sql);
            
            if(rst.next()){
                record = rst.getString(columnName1);
            }
            return record;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList readRow(String tableName,String coloumn,String condition){
        String sql = "Select * from "+tableName+" where "+coloumn+" like "+"\""+condition+"\"";
        
        
        ArrayList list = new ArrayList();
        try {
            statement = conn.createStatement();
            rst = statement.executeQuery(sql);

            if (rst.next()) {
                ResultSetMetaData meta = rst.getMetaData();
                
                for (int i = 1; i<meta.getColumnCount(); i++) {
                    list.add(rst.getString(i));
                }                     
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error In read Row method : "+ex.getMessage());
        }
        return null;
    }
    
    public boolean editRecordInTable(String tableName,String coloumnName,String coloumn2,String value,String condition){
        String sql = "UPDATE "+tableName+"\n"
                + "SET "+coloumn2+"='"+value+"'\n"
                + "WHERE "+coloumnName+" like "+"\""+condition+"\"";
        
        System.out.println("SQL query : "+sql+"\n");
        try {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in insertion to Table : " + tableName + " " + ex.getMessage());
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean editRecordWithColoumns(String tableName,String coloumnName,String condition,ArrayList data,ArrayList coloumns){
        
        String value = "";
        for (int i = 0; i < coloumns.size(); i++) {
            String coloumnData = String.valueOf(data.get(i+1));
            String coloumn = String.valueOf(coloumns.get(i));
            value+=(coloumn+"=\""+coloumnData+"\"");
            if((coloumns.size()-1)>i){
                value+=",";
            }
           
        }
        String sql = "UPDATE " + tableName + "\n"
                + "SET " + value+ "\n"
                + "WHERE " + coloumnName + " like " + "\"" + condition + "\"";

        System.out.println("SQL query : " + sql + "\n");
        try {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in insertion to Table : " + tableName + " " + ex.getMessage());
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList retreveDataColoumnWithCondition(String tableName,String coloumnName,String coloumn2,String condition){
        String sql = "SELECT "+coloumnName+" from "+tableName+" where "+coloumn2+" like " + "\""+condition+ "\"";
        System.out.println("SQL" + sql);
        
        try {
            statement = conn.createStatement();
            rst = statement.executeQuery(sql);
            ArrayList list = new ArrayList();
            while(rst.next()){
                list.add(rst.getString(coloumnName));                
            }
           
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error in retreveDataColoumn "+tableName+" :"+ex.getMessage());
        }
        
        return null;
        
        
    }
    
    public ArrayList retreveDataColoumnWithTwoCondition(String tableName,String coloumnName,String coloumn2,String condition1,String coloumn3,String condition2){
        String sql = "SELECT "+coloumnName+" from "+tableName+" where "+coloumn2+" like " + "\""+condition1+ "\" AND "+coloumn3+" like "+"\""+condition2+ "\"";
        
        System.out.println("SQL : "+sql);
        try {
            statement = conn.createStatement();
            rst = statement.executeQuery(sql);
            ArrayList list = new ArrayList();
            while(rst.next()){
                list.add(rst.getString(coloumnName));                
            }
           
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error in retreveDataColoumn "+tableName+" :"+ex.getMessage());
        }
        
        return null;
        
        
    }
    
    public String sqlExecution(String sql,String coloumn){
        

        String record = null;
        try {
            statement = conn.createStatement();
            rst = statement.executeQuery(sql);

            if (rst.next()) {
                record = rst.getString(coloumn);
            }
            return record;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public ArrayList sqlExecutionaArray(String sql,String coloumn){
        

        ArrayList data = new ArrayList();
        try {
            statement = conn.createStatement();
            rst = statement.executeQuery(sql);

            if (rst.next()) {
                data.add(rst.getString(coloumn));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
