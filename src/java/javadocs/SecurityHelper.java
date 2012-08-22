/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javadocs;

import java.security.Key; 
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
 
public class SecurityHelper{
    public static String getHash(String[] arg){
        String chain ="";
        
        for(int i=0;i<arg.length;i++){
            chain += arg[i];
        }
        
        try{
            return getHmacMD5("key",chain ,"HmacMD5");
        }catch(Exception e){
            return e.toString();
        }
    }
    
    public static String getDocHash(String[] arg){
        String chain ="";
        
        for(int i=0;i<arg.length;i++){
            chain += arg[i];
        }
        
        try{
            return getHmacMD5("docRegisterKey",chain ,"HmacMD5");
        }catch(Exception e){
            return e.toString();
        }
    }
    
    //Metodos internos para la generacion del hash
    private static String getHmacMD5(String privateKey, String input, String algorithm) throws Exception{
            byte[] keyBytes = privateKey.getBytes();
            Key key = new SecretKeySpec(keyBytes, 0, keyBytes.length, algorithm); 
            Mac mac = Mac.getInstance(algorithm);
            mac.init(key); 
            return byteArrayToHex(mac.doFinal(input.getBytes()));
    }
    
    private static String byteArrayToHex(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }
}
