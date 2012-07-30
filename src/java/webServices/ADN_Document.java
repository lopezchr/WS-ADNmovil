/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import javadocs.Madre;
import javadocs.SecurityHelper;
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
    @WebMethod(operationName = "setDocument")
    public String setDocument(
            @WebParam(name = "user") String usuario,
            @WebParam(name = "pwd") String clave,
            @WebParam(name = "emp") String empresa,
            @WebParam(name = "isSistema") String isSistema,
            @WebParam(name = "document") String document,
            @WebParam(name = "hash") String hash
            ) {
        String[] args = {usuario,clave,empresa,document};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            String validalogin = Madre.login(usuario, clave, empresa);
            if(validalogin.indexOf("Error") == 0){
                //se extrae el idEmpresa
                String[] res = validalogin.split("\\|");
                String idEmpresa = res[1];
                String idUsuario = res[0];
                return Madre.setDocument(idEmpresa, isSistema, document);
            }else{
                return "error al validar usuario";
            }
        }
    }
}
