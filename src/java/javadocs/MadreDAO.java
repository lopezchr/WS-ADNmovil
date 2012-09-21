/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javadocs;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author clopez
 */
public class MadreDAO {
    public static Connection conex = null;

  public static String conexionDB(String user, String pwd, String db){
    String result="";
    String bdAddress = "192.168.10.14:1521";
     try{
            Properties dbProp = new Properties();
            dbProp.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("configDB.properties"));  

            bdAddress = dbProp.getProperty("dataBaseAddress");
            
            System.out.println("Se cargo correctamente la direccion"+bdAddress );     
        }catch(Exception e){
            System.out.println("No fue posible cargar la direccion de la base de datos");
            e.printStackTrace();
        }

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        java.util.Properties props = new java.util.Properties();
        
        props.put("user", user);
        props.put("password", pwd);
        props.put("SetBigStringTryClob", "true");
        
        
        conex = DriverManager.getConnection (
                    "jdbc:oracle:thin:@"+bdAddress+":"+db, props);
        if(conex != null){
            System.out.println("WSADNMovil.Conexion a bd "+user+" establecida");
            result= "ok";
        }else{
            result= "Error de conexiòn a base de datos de usuario "+user;
        }

    }catch (ClassNotFoundException e1) {
        result ="ERROR:No encuentro el driver de la BD : " +e1.toString();
        System.out.println("Conexion a bd "+user+" establecida "+result);
        e1.printStackTrace();
    }
    catch (SQLException e3) {
        result ="Error en conectarBD SQLException: "+e3.toString();
        System.out.println("WSADNMovil. Error en conectarBD SQLException: "+e3.toString());
        e3.printStackTrace();
    }
    finally {
       return result;
    }
  }

  public static void cerrarConexion(){
    try{
      conex.close();
    }catch(SQLException e){
      System.out.println("WSADNMovil. Error en cerrarConexion() SQLException: "+e.toString());
    }
  }

  public static Object[][] consultarBD(String sql){
    Object[][] result =new Object[1][1];
    System.out.print("Consulta: "+sql);
    try {
      java.sql.Statement stm = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      ResultSet rset = stm.executeQuery(sql);
      if (rset.next()){
        result = Utils.ResultSetToArray(rset);
        return result;
      }else{
        System.out.println("WSADNMovil.Error consultarBD:  no hay resultados");
        result[0][0] = "";
        return result;
      }
    }catch (Exception e) {
      System.out.println("WSADNMovil.Error consultarBD: "+ e +" /SQL: "+ sql );
      e.printStackTrace();
      result[0][0] = "WSADNMovil.Error consultarBD: "+e+" SQL: "+sql;
      return result;
    }
  }

  public static Object[][] funcionSQLBD(String emp, String functionCode, String parameters){
    Object resultado = "";
    CallableStatement cs= null;
    
    Object[][] res = new Object[1][1];

    //functionCode = dbfunctionality.getFunctionCode(nameFunction);
    try{
      cs = conex.prepareCall("{call DB (?,?,?,?)}");
     
      cs.registerOutParameter(4, java.sql.Types.VARCHAR);
      cs.setString(1, emp);
      cs.setString(2, functionCode);
      cs.setString(3, parameters);
      
      cs.execute();
      resultado = cs.getObject(4);
      
       if(resultado != null && !resultado.equals("MAL")){
        res = Utils.chainToArray(resultado.toString());
        return res;  
      }else{
        res[0][0] = "";
        return res;
      }
      
      
    }catch(SQLException sqle){
        res[0][0] = "WSADNMovil.Error funcionSQLBD: "+sqle+" /funcion: "+functionCode;
        return res;
    }catch(Exception e){
        res[0][0] = "WSADNMovil.Error funcionSQLBD: "+e+" /function: "+functionCode;
        return res;
    }
    
  }
  
  public static Object[][] funcionFACT(String idEmpresa, String documento){
    Object resultado = "";
    CallableStatement cs= null;
    
    Object[][] res = new Object[1][1];

    //functionCode = dbfunctionality.getFunctionCode(nameFunction);
    try{
      cs = conex.prepareCall("{call "+idEmpresa+".CREA_DOCUM.FACT (?)}");
      cs.registerOutParameter(1, java.sql.Types.VARCHAR);
      cs.setString(1, documento);
      cs.execute();
      
      res[0][0]= "ok";      
      return res;
      
    }catch(SQLException sqle){
        res[0][0] = "WSADNMovil.Error funcionEDI: " + sqle.toString();
        return res;
    }catch(Exception e){
        res[0][0] = "WSADNMovil.Error funcionEDI: "+e.toString();
        return res;
    }
    
  }
  public static Object[][] funcionBILL(String idEmpresa, String documento){
    Object resultado = "";
    CallableStatement cs= null;
    
    Object[][] res = new Object[1][1];

    //functionCode = dbfunctionality.getFunctionCode(nameFunction);
    try{
      cs = conex.prepareCall("{call "+idEmpresa+".CREA_DOCUM.FACT (?)}");
      cs.registerOutParameter(1, java.sql.Types.VARCHAR);
      cs.setString(1, documento);
      cs.execute();
      
      res[0][0]= "ok";      
      return res;
      
    }catch(SQLException sqle){
        res[0][0] = "WSADNMovil.Error funcionEDI: " + sqle.toString();
        return res;
    }catch(Exception e){
        res[0][0] = "WSADNMovil.Error funcionEDI: "+e.toString();
        return res;
    }
    
  }
}
