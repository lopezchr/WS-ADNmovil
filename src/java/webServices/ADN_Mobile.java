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
@WebService(serviceName = "ADN_Mobile")
public class ADN_Mobile {
  
    /**
   * Web service operation
   */
    @WebMethod( operationName = "login")
    public String login(
            @WebParam(name = "user") String usuario,
            @WebParam(name = "pwd") String clave,
            @WebParam(name = "emp") String empresa,
            @WebParam(name = "hash") String hash
            )
    { 
        String[] args = {usuario,clave,empresa};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.login(usuario, clave, empresa);
        }
    } 

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSistemas")
    public String getSistemas(
            @WebParam(name = "idUsuario") String idUsuario,
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "hash") String hash
            ) 
    {
        String[] args = {idUsuario,idEmpresa};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getSistemas(idUsuario, idEmpresa);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cargarOpciones")
    public String cargarOpciones(
            @WebParam(name = "idUsuario") String idUsuario,
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "hash") String hash
            ) 
    {
        String[] args = {idUsuario,idEmpresa};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.cargarOpciones(idUsuario, idEmpresa);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cosultaCartera")
    public String cosultaCartera(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "filtro") String filtro,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "hash") String hash
                    ) 
    {  
        //filtro no se agrega como parametro de seguridad porque puede ser nullo
        String[] args = {idEmpresa,idSistema};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.cosultaCartera(idEmpresa,filtro,idSistema);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "cosultaTotalCartera")
    public String cosultaTotalCartera(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "filtro") String filtro,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "hash") String hash
                    ) 
    {  
        //filtro no se agrega como parametro de seguridad porque puede ser nullo
        String[] args = {idEmpresa,idSistema};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.cosultaTotalCartera(idEmpresa,filtro,idSistema);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "carteraDetalle")
    public String carteraDetalle(
            @WebParam(name = "idEmpresa") String idEmpresa, 
            @WebParam(name = "idTercero") String idTercero,
            @WebParam(name = "hash") String hash
            ) 
    {
        String[] args = {idEmpresa,idTercero};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.carteraDetalle(idEmpresa,idTercero);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getProveedores")
    public String getProveedores(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "filtro") String filtro,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "hash") String hash
            ) 
    {
        //filtro no se agrega como parametro de seguridad porque puede ser nullo
        String[] args = {idEmpresa,idSistema};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getProveedores(idEmpresa,filtro,idSistema);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTotalProveedores")
    public String getTotalProveedores(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "filtro") String filtro,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "hash") String hash
            ) 
    {
        //filtro no se agrega como parametro de seguridad porque puede ser nullo
        String[] args = {idEmpresa,idSistema};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getTotalProveedores(idEmpresa,filtro,idSistema);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCuentasPorPagar")
    public String getCuentasPorPagar(
            @WebParam(name = "idEmpresa") String idEmpresa, 
            @WebParam(name = "idTercero") String idTercero,
            @WebParam(name = "hash") String hash
            ) 
    {
        String[] args = {idEmpresa,idTercero};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getCuentasPorPagar(idEmpresa,idTercero);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getInventario")
    public String getInventario( 
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "filtro") String filtro,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "grupo") String grupo,
            @WebParam(name = "bodega") String bodega,
            @WebParam(name = "hash") String hash
            ) 
    {
        //filtro no se agrega como parametro de seguridad porque puede ser nullo
        String[] args = {idEmpresa,idSistema};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getInventario(idEmpresa,filtro,idSistema,grupo,bodega);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDetalleArticulo")
    public String getDetalleArticulo(
            @WebParam(name = "idEmpresa") String idEmpresa, 
            @WebParam(name = "idTercero") String codigo,
            @WebParam(name = "hash") String hash
            ) 
    {
        String[] args = {idEmpresa,codigo};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getDetalleArticulo(idEmpresa,codigo);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMovimientos")
    public String getMovimientos(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "filtro") String filtro,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "hash") String hash
            ) 
    {
        
        String[] args = {idEmpresa,filtro,idSistema};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getMovimientos(idEmpresa,filtro,idSistema);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDetalleMovimientos")
    public String getDetalleMovimientos(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "idTipoDoc") String idTipoDoc,
            @WebParam(name = "hash") String hash
            ) 
    {
        
        String[] args = {idEmpresa,idTipoDoc};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getDetalleMovimientos(idEmpresa,idTipoDoc);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getBalance")
    public String getBalance(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "filtro") String filtro,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "dateChain") String dateChain,
            @WebParam(name = "hash") String hash
            ) 
    {
        
        String[] args = {idEmpresa,filtro,idSistema,dateChain};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getBalance(idEmpresa,filtro,idSistema,dateChain);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUtilidad")
    public String getUtilidad(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "filtro") String filtro,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "dateChain") String dateChain,
            @WebParam(name = "hash") String hash
            ) 
    {
        
        String[] args = {idEmpresa,idSistema,dateChain};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getUtilidad(idEmpresa,filtro,idSistema,dateChain);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAuxiliar")
    public String getAuxiliar(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "filtro") String codigo,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "chainDate") String chainDate,
            @WebParam(name = "hash") String hash
            ) 
    {
        
        String[] args = {idEmpresa,idSistema,chainDate};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getAuxiliar(idEmpresa,codigo,idSistema,chainDate);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultaFactura")
    public String consultaFactura(
            @WebParam(name = "idEmpresa") String idEmpresa, 
            @WebParam(name = "idTercero") String documento,
            @WebParam(name = "hash") String hash
            ) 
    {
        String[] args = {idEmpresa,documento};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.consultaFactura(idEmpresa,documento);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "cosultaCliente")
    public String cosultaCliente(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "filtro") String filtro,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "hash") String hash
                    ) 
    {  
        //filtro no se agrega como parametro de seguridad porque puede ser nullo
        String[] args = {idEmpresa,idSistema};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.cosultaCliente(idEmpresa,filtro,idSistema);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "factValidateData")
    public String factValidateData(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "Codtdoc") String codTdoc,
            @WebParam(name = "idclient") String codCliente,
            @WebParam(name = "idccosto") String codCcosto,
            @WebParam(name = "idbodega") String idbodega,
            @WebParam(name = "idvendedor") String idVendedor,
            @WebParam(name = "idlprecios") String idlprecios,
            @WebParam(name = "hash") String hash
                    ) 
    {  
        //filtro no se agrega como parametro de seguridad porque puede ser nullo
        String[] args = {idEmpresa,idSistema,codTdoc,codCliente,codCcosto,idbodega,idVendedor,idlprecios};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.factValidateData(idEmpresa,idSistema,codTdoc,codCliente,codCcosto,idbodega,idVendedor,idlprecios);
        }
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFactDetalleArticulo")
    public String getFactDetalleArticulo(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "idtdoc") String idArticulo,
            @WebParam(name = "bodega") String bodega,
            @WebParam(name = "idLista") String idLista,
            @WebParam(name = "hash") String hash
                    ) 
    {  
        //filtro no se agrega como parametro de seguridad porque puede ser nullo
        String[] args = {idEmpresa,idArticulo,bodega,idLista};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getFactDetalleArticulo(idEmpresa,idArticulo,bodega,idLista);
        }
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "billDataValidation")
    public String billDataValidation(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "idSistema") String idSistema,
            @WebParam(name = "Codtdoc") String codTdoc,
            @WebParam(name = "idccosto") String codCcosto,
            @WebParam(name = "idvendedor") String idVendedor,
            @WebParam(name = "hash") String hash
                    ) 
    {  
        //filtro no se agrega como parametro de seguridad porque puede ser nullo
        String[] args = {idEmpresa,idSistema,codTdoc,codCcosto,idVendedor};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.billDataValidation(idEmpresa,idSistema,codTdoc,codCcosto,idVendedor);
        }
    }
    
    /**
     * Web service operation
     */
        @WebMethod(operationName = "getBillDocuments")
    public String getBillDocuments(
            @WebParam(name = "idEmpresa") String idEmpresa,
            @WebParam(name = "idTercero") String idTercero,
            @WebParam(name = "hash") String hash
                    ) 
    {  
        //filtro no se agrega como parametro de seguridad porque puede ser nullo
        String[] args = {idEmpresa,idTercero};
        String secHash = SecurityHelper.getHash(args);
        if(!secHash.equals(hash)){
            return "Error en validacion de Seguridad"; 
        }else{
            return Madre.getBillDocuments(idEmpresa,idTercero);
        }
    }
}
