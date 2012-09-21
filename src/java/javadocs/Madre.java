/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javadocs;

import javadocs.MadreDAO;
import javadocs.Utils;

/**
 *
 * @author clopez
 */
public class Madre {
    
   public static String login(String usuario,String clave,String empresa){
        String idUsuario = "";
    String mensaje = "";
    String id_empresa = "";
    Object[][] result = null;
    
    
    try{
      String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
      if(!conec.equals("ok")){
        return "Error de conexion";
      }
      result = MadreDAO.funcionSQLBD("ADN","ML-01", empresa+"@#");

      if(Utils.validaResult(result)){
          id_empresa  =  result[0][1].toString();
          String servicio   =  result[0][2].toString();
          result = MadreDAO.funcionSQLBD(id_empresa ,"ML-02", usuario+"@#");
          if(Utils.validaResult(result)){
            idUsuario = result[0][1].toString();
            //nombreUsuario = resUsuario[0];
            
            result = MadreDAO.funcionSQLBD(id_empresa ,"ML-03", idUsuario+"@#");

            String llv = result[0][0].toString();
            llv=(llv==null)?"*":llv;
            
            result = MadreDAO.funcionSQLBD(id_empresa ,"ML-04", clave+"@#"+idUsuario+"@#");
            String pwd = result[0][0].toString();

            if (llv.equals(pwd)){
               result = MadreDAO.funcionSQLBD("ADN" ,"ML-05", id_empresa+"@#");
               String psw_base = result[0][0].toString();

               return idUsuario+"|"+id_empresa+"|"+psw_base+"@#";
            }
            return "Error al validar la contraseña@#";
          }else{
            return "Error al validar la persona@#";
          }
        }else{
          return "Error al validar la empresa@#";
        }
      }catch(Exception e){
        return "Error login: "+mensaje+"/Excepcion: "+e;
      }
    }
   
   public static String getSistemas(String idUsuario,String idEmpresa){
      String res = "";
      Object[][] result =new Object[1][1];
      
      String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_","adn");
      if(!conec.equals("ok")){
        return "Error de conexion";
      }
      
      try{
        result = MadreDAO.funcionSQLBD(idEmpresa ,"MS-01", idUsuario+"@#");
        if(Utils.validaResult(result)){
              res = Utils.arrayToChain(result);
              return res;
        }else{
          return "Error en MAdreDAO. No es posible cargar sistemas de empresa:"+result[0][0] +"@#";
        }
      }catch(Exception e){
        return "MAdreDAO. Error cargarSistemas: "+e;
      }
   }
   
   public static String cargarOpciones(String idUsuario,String idEmpresa){
      String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
      if(!conec.equals("ok")){
        return "Error de conexion";
      }
      Object[][] result =new Object[1][1];
      String idGrpUsr;
      
      try{
        result = MadreDAO.funcionSQLBD(idEmpresa ,"MO-01", idUsuario+"@#");
      
        if(Utils.validaResult(result)){
          idGrpUsr=result[0][0].toString();
          
          result = MadreDAO.funcionSQLBD(idEmpresa ,"MO-02", idUsuario+"@#"+idGrpUsr+"@#");
          
          return Utils.arrayToChain(result); 
          
        }else{
          return "Error al traer datos del grpo de usuario.@#";
        }
      }catch(Exception e){
        return "Error al traer opciones .@#";
      }
   }
   
   public static String cosultaCartera(String idEmpresa,String filtro,String idSistema){
        String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MC-01", filtro+"@#"+idSistema+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de cartera.@#";
        }  
   }
   
   public static String cosultaTotalCartera(String idEmpresa,String filtro,String idSistema){
        String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MC-03", filtro+"@#"+idSistema+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de cartera.@#";
        }  
   }
   
   public static String carteraDetalle(String idEmpresa,String idTercero){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MC-02", idTercero+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }  
   }
   
   public static String getProveedores(String idEmpresa, String filtro, String idSistema){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result = new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MP-01", filtro+"@#"+idSistema+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }
   }
   
   public static String getTotalProveedores(String idEmpresa, String filtro, String idSistema){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result = new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MP-03", filtro+"@#"+idSistema+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }
   }
   
   public static String getCuentasPorPagar(String idEmpresa, String idTercero){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MP-02", idTercero+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }  
   }
   
   public static String getInventario(String idEmpresa, String filtro,String idSistema,String grupo, String bodega){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result = new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MI-01", filtro+"@#"+idSistema+"@#"+grupo+"@#"+bodega+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }
   }
   
   public static String getDetalleArticulo(String idEmpresa,String codigo){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MI-02", codigo+"@#");
            if(Utils.validaResult(result)&&!result[0][0].toString().equals("MAL")){
                
                result = MadreDAO.funcionSQLBD(idEmpresa ,"MI-03", codigo+"@#");
                
                if(Utils.validaResult(result)){
                    return Utils.arrayToChain(result); 
                }else{
                    return "Error al procesar datos articulo.@#";   
                }
            }else{
                return "Error al generar vista articulo.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }  
   }
   
   public static String getMovimientos(String idEmpresa, String filtro,String idSistema){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result = new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MM-01", filtro+"@#"+idSistema+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }
   }
   
   public static String getDetalleMovimientos(String idEmpresa, String idTipoDoc){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result = new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MM-02", idTipoDoc+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }
   }
   
   public static String getBalance(String idEmpresa, String filtro,String idSistema, String chainDate){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result = new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MB-01", filtro+"@#"+idSistema+"@#"+chainDate+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }
   }
   
   public static String getUtilidad(String idEmpresa, String filtro,String idSistema, String chainDate){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result = new Object[1][1];

        String month = chainDate.substring(2,4).replace("0","");
        String year = chainDate.substring(4,chainDate.length());
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MU-01", filtro+"@#"+idSistema+"@#"+month+"@#"+year+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }
   }
   
    public static String getAuxiliar(String idEmpresa,String codigo,String idSistema,String chainDate){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        String month = chainDate.substring(2,4).replace("0","");
        String year = chainDate.substring(4,chainDate.length());
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"AUX_CON", codigo+"@#"+idSistema+"@#"+month+"@#"+year+"@#");
            
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result);
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }  
   }
   
   public static String consultaFactura(String idEmpresa,String documento){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"CON_FAC", documento+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }  
   }
   
   public static String setFactDocument(String idEmpresa, String documento, String ideDoc){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            //result = MadreDAO.funcionSQLBD(idEmpresa ,"DO-01", documento+"@#");
            result = MadreDAO.funcionFACT(idEmpresa,documento);
            
            if(Utils.validaResult(result)){
                if(result[0][0].toString().indexOf("Error") < 1){
                    Object[][] obj = MadreDAO.consultarBD("SELECT OBSER FROM "+idEmpresa+".TMP_MOVIL_CONSULTAS WHERE ID_REGISTRO='"+ideDoc+"'");
                    return Utils.arrayToChain(obj);
                    //return Madre.verifyDocument(idEmpresa,ideDoc);
                }else{
                    return "error en la durante el envio del documento";
                }      
            }else{
                return "Error al validar respuesta del procedimiento DB.@#";
            }   
        }catch(Exception e){
            return "Error durante la generacion del documento: "+e.toString()+"@#";
        }  
   }
   
   public static String setBillDocument(String idEmpresa, String documento, String ideDoc){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            //result = MadreDAO.funcionSQLBD(idEmpresa ,"DO-01", documento+"@#");
            result = MadreDAO.funcionBILL(idEmpresa,documento);
            
            if(Utils.validaResult(result)){
                if(result[0][0].toString().indexOf("Error") < 1){
                    Object[][] obj = MadreDAO.consultarBD("SELECT OBSER FROM "+idEmpresa+".TMP_MOVIL_CONSULTAS WHERE ID_REGISTRO='"+ideDoc+"'");
                    return Utils.arrayToChain(obj);
                    //return Madre.verifyDocument(idEmpresa,ideDoc);
                }else{
                    return "error en la durante el envio del documento";
                }      
            }else{
                return "Error al validar respuesta del procedimiento DB.@#";
            }   
        }catch(Exception e){
            return "Error durante la generacion del documento: "+e.toString()+"@#";
        }  
   }
   
   public static String verifyDocument(String idEmpresa, String idDoc){
       String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"DO-02", idDoc+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar datos de detalle Cartera.@#";
            }   
        }catch(Exception e){
            return "Error en cosulta de detaller cartera.@#";
        }  
   }
   
   public static String cosultaCliente(String idEmpresa,String filtro,String idSistema){
        String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"CON_CLI", filtro+"@#"+idSistema+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar consulta de usuarios.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de clientes.@#";
        }  
   }
   
   public static String factValidateData(
           String idEmpresa,
           String idSistema,
           String codTdoc,
           String codCliente,
           String codCcosto,
           String idbodega,
           String idVendedor,
           String idlprecios
           )
   {
        String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MF-01", 
                    idSistema+"@#"+codTdoc+"@#"+codCliente+"@#"+codCcosto+"@#"+idbodega+"@#"+idVendedor+"@#"+idlprecios+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar consulta de usuarios.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de clientes.@#";
        }  
   }
   
   public static String getFactDetalleArticulo(String idEmpresa, String idArticlo,String bodega, String idLista ){
        String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MF-02", idArticlo+"@#"+bodega+"@#"+idLista+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result);
          
            }else{
                return "Error al procesar consulta de usuarios.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de clientes.@#";
        }  
   }
   
   public static String billDataValidation(
           String idEmpresa,
           String idSistema,
           String codTdoc,
           String codCcosto,
           String idVendedor
           )
   {
        String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MR-01", 
                    idSistema+"@#"+codTdoc+"@#"+codCcosto+"@#"+idVendedor+"@#");
      
            if(Utils.validaResult(result)){
          
                return Utils.arrayToChain(result); 
          
            }else{
                return "Error al procesar consulta de usuarios.@#";
            }
        }catch(Exception e){
            return "Error en cosulta de clientes.@#";
        }  
   }
   
   public static String getBillDocuments(String idEmpresa, String idTercero ){
        String conec = MadreDAO.conexionDB("adn","Pzs5wlrd_", "adn");
        if(!conec.equals("ok")){
            return "Error de conexion";
        }
        Object[][] result =new Object[1][1];
        
        try{
            result = MadreDAO.funcionSQLBD(idEmpresa ,"MR-02", idTercero+"@#");
      
            if(result[0][0].toString().indexOf("Error")>0){
                return "Error al procesar consulta de Documentos.@#";
            }else if(result[0][0].equals("")){
                return "No hay registros@#";
            }else{
                return Utils.arrayToChain(result);
            }
            
        }catch(Exception e){
            return "Error en cosulta de Documentos.@#";
        }  
   }
}