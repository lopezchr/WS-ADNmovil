/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javadocs;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author clopez
 */
public class Utils {
    public static boolean validaResult(Object[][] result){

    if(result[0][0].equals("") || result[0][0].toString().indexOf("Error")>0){
      return false;
    }else{
      return true;
    }

  }

  public static Object[][] ResultSetToArray(ResultSet rs){
    Object obj[][]=null;
    try
    {
    rs.last();
    ResultSetMetaData rsmd = rs.getMetaData();
    int numCols = rsmd.getColumnCount();
    int numFils =rs.getRow();
    obj=new Object[numFils][numCols];
    int j = 0;
    rs.beforeFirst();
    while (rs.next())        {
        for (int i=0;i<numCols;i++)            {
            obj[j][i]=rs.getObject(i+1);
        }
        j++;
    }
    }
    catch(Exception e)        {

    }
    return obj;
  }

  public static String arrayToChain(Object[][] result){
        String chainRes = "";
        for(int i=0; i < result.length ;i++){
            for(int j=0 ; j< result[i].length; j++){
                if(result[i][j] != null ){
                    chainRes += result[i][j].toString() + "|";
                }else{
                    chainRes += "|";
                }
            }
            chainRes = chainRes.substring(0,chainRes.length()-1);
            chainRes += "@#";
        }
        return chainRes;
  }
  
  public static Object[][] chainToArray(String cad){
      
      String cadena = cad.substring(0,cad.length()-2);
      
      String[] arrayCadena = cadena.split("@#");
      int numFilas = arrayCadena.length;
      
      String[] dummy = arrayCadena[0].split("\\|");
      int numCols = dummy.length;
      
      Object[][] res= new Object[numFilas][numCols];
      
      for(int i=0; i <numFilas;i++){
          String subCadena =  arrayCadena[i];
          //se una una expresion regular para validar el pipe
          String[] arraySubCadena = subCadena.split("\\|");
          
          for(int j=0 ; j< arraySubCadena.length ; j++){
              res[i][j] = arraySubCadena[j];
          }
      }
      return res;
  }    
}
