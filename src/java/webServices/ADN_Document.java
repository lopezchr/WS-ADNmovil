/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import javadocs.Madre;
import javadocs.MadreDAO;
import javadocs.SecurityHelper;
import javadocs.Utils;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author clopez
 */
@WebService(serviceName = "ADN_EDIdocument")
public class ADN_Document {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "setFactDocument")
    public String setFactDocument(
            @WebParam(name = "user") String usuario,
            @WebParam(name = "pwd") String clave,
            @WebParam(name = "emp") String empresa,
            @WebParam(name = "ideDoc") String ideDoc,
            @WebParam(name = "document") String document,
            @WebParam(name = "hash") String hash
            ) {
        String[] args = {usuario,clave,empresa,ideDoc,document};
        String secHash = SecurityHelper.getDocHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            String validalogin = Madre.login(usuario, clave, empresa);
            
            if(validalogin.indexOf("Error") < 1){
                //se extrae el idEmpresa
                String[] res = validalogin.split("\\|");
                String idEmpresa = res[1];
                return Madre.setFactDocument(idEmpresa, document, ideDoc);
                
            }else{
                return "error al validar usuario";
            }
        }
    }
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "setBillDocument")
    public String setBillDocument(
            @WebParam(name = "user") String usuario,
            @WebParam(name = "pwd") String clave,
            @WebParam(name = "emp") String empresa,
            @WebParam(name = "ideDoc") String ideDoc,
            @WebParam(name = "document") String document,
            @WebParam(name = "hash") String hash
            ) {
        String[] args = {usuario,clave,empresa,ideDoc,document};
        String secHash = SecurityHelper.getDocHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            String validalogin = Madre.login(usuario, clave, empresa);
            
            if(validalogin.indexOf("Error") < 1){
                //se extrae el idEmpresa
                String[] res = validalogin.split("\\|");
                String idEmpresa = res[1];
                return Madre.setBillDocument(idEmpresa, document, ideDoc);
                
            }else{
                return "error al validar usuario";
            }
        }
    }
}