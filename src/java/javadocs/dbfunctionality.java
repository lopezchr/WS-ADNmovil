/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javadocs;

/**
 *
 * @author clopez
 */
public class dbfunctionality {
    public static String getFunctionCode(String FunctionName){
    if(FunctionName.equals("getDataEmpByAlias")){
      return "ML01";
    }else if(FunctionName.equals("getDataClientByAlias")){
      return "ML02";
    }else{
       return "000";
    }
  }
}
