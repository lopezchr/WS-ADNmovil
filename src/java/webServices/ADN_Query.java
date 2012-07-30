/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import javadocs.MadreDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author clopez
 */
@WebService(serviceName = "ADN_Query")
public class ADN_Query {
    
     /**
   * Web service operation
   */
  @WebMethod(operationName = "consulta")
  public String consulta(
          @WebParam(name = "user") String user,
          @WebParam(name = "pwd") String pwd,
          @WebParam(name = "db") String db,
          @WebParam(name = "sql") String sql
          )
  {
    try{
      String con = MadreDAO.conexionDB(user, pwd, db);
      if(!con.equals("ok")){
        return con;
      }
      String sb="";
      Object[][] result =new Object[1][1];
      result = MadreDAO.consultarBD(sql);
      for(int i =0; i < result.length;i++){
        String row = "";
        for(int j =0; j < result[i].length;j++){
          row += result[i][j].toString() + "º";
        }
        sb += row.substring(0, row.length() - 1)+"¬";
      }
      return sb;
    }catch(Exception e){
      return e.toString();
    }finally{
      MadreDAO.cerrarConexion();
    }
  }
}
