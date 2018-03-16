/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminalcontroldemo;
import java.util.*;
/**
 *
 * @author Administrator
 */


public class sky300 {
    static Map mediaType = new HashMap(); 
    public static class videoSettings{
        videoSettings(){
        mediaType.put("0","H261");
        mediaType.put("1","H262");
        mediaType.put("2","H263");
        mediaType.put("4","H264");
        mediaType.put("5","MPEG4");
        mediaType.put("6","H265");}
    }
    sky300(){
      
   }  

}
 
