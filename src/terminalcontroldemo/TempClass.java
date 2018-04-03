/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminalcontroldemo;
import java.util.*;
import com.google.gson.*;
//import org.json.*;
import net.sf.json.*;



import static terminalcontroldemo.HttpUtils.httpGet;
import static terminalcontroldemo.HttpUtils.httpPost;
/**
 * 利用okhttp进行get和post的访问
 * 
 * @author cp
 *
 */
public class TempClass {
   public static void main(String[] args) {  
        javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView  
                .getFileSystemView();  
        System.out.println("桌面路径：" + fsv.getHomeDirectory());  
        System.out.println("默认路径：" + fsv.getDefaultDirectory());  
        //System.getProperties().list(System.out);  
            String str = "{"  
                    + "\"error\": 0,"  
                    + "\"status\": \"success\","  
                    + "\"date\": \"2014-05-10\","  
                    + "\"results\":["  
                    + "{"  
                    + "\"currentCity\":\"南京\","  
                    + "\"weather_data\":["  
                    + "{"  
                    + "\"date\":\"周六(今天, 实时：19℃)\","  
                    + "\"dayPictureUrl\": \"http://api.map.baidu.com/images/weather/day/dayu.png\","  
                    + "\"nightPictureUrl\": \"http://api.map.baidu.com/images/weather/night/dayu.png\","  
                    + "\"weather\": \"大雨\","  
                    + "\"wind\": \"东南风5-6级\","  
                    + "\"temperature\": \"18℃\""  
                    + "},"  
                    + "{"  
                    + "\"date\": \"周日\","  
                    + "\"dayPictureUrl\": \"http://api.map.baidu.com/images/weather/day/zhenyu.png\","  
                    + "\"nightPictureUrl\": \"http://api.map.baidu.com/images/weather/night/duoyun.png\","  
                    + "\"weather\": \"阵雨转多云\"," + "\"wind\": \"西北风4-5级\","  
                    + "\"temperature\": \"21 ~ 14℃\"" + "}" + "]" + "}" + "]"  
                    + "}";  
        
        
        String pri = "{ \"head\": { \"userid\": \"\", \"dwresult\": 0 }, \"body\": { \"atAssAudDecStatic\": [  ], \"atAssAudEncStatic\": [  ], \"atAssAudMixStatic\": [  ], \"atAssVidDecStatic\": [ { \"bVideoDecStart\": false, \"dwDecBitrate\": 0, \"dwFrameRate\": 0, \"dwLostPackRatio\": 0, \"dwLostPacks\": 0, \"dwPhysicalLostPackRatio\": 0, \"dwRcvFrames\": 0, \"dwVidHeight\": 0, \"dwVidWidth\": 0, \"emVidDecId\": 0, \"emVidDecType\": 7, \"emVideoProfile\": 0 } ], \"atAssVidEncStatic\": [ { \"bVideoEncStart\": false, \"dwEncBitrate\": 0, \"dwFrameRate\": 0, \"dwVidHeight\": 0, \"dwVidWidth\": 0, \"emVidEncId\": 0, \"emVidEncType\": 7, \"emVideoProfile\": 0 } ], \"atAssVidMixStatic\": [  ], \"atMainAudDecStatic\": [ { \"bAudioDecStart\": true, \"dwDecRate\": 30, \"dwLostPackRatio\": 0, \"dwLostPacks\": 0, \"dwPhysicalLostPackRatio\": 0, \"dwRecFrames\": 19568, \"emAudChanDecType\": 0, \"emAudDecId\": 0, \"emAudDecType\": 12, \"emChnl_num\": 0 } ], \"atMainAudEncStatic\": [ { \"bAudioEncStart\": true, \"dwEncRate\": 8, \"emAudEncId\": 0, \"emAudEncType\": 12, \"emChnl_num\": 0 } ], \"atMainAudMixStatic\": [  ], \"atMainVidDecStatic\": [ { \"bVideoDecStart\": true, \"dwDecBitrate\": 525, \"dwFrameRate\": 60, \"dwLostPackRatio\": 0, \"dwLostPacks\": 0, \"dwPhysicalLostPackRatio\": 0, \"dwRcvFrames\": 23415, \"dwVidHeight\": 1080, \"dwVidWidth\": 1920, \"emVidDecId\": 0, \"emVidDecType\": 6, \"emVideoProfile\": 0 } ], \"atMainVidEncStatic\": [ { \"bVideoEncStart\": true, \"dwEncBitrate\": 510, \"dwFrameRate\": 30, \"dwVidHeight\": 1080, \"dwVidWidth\": 1920, \"emVidEncId\": 0, \"emVidEncType\": 6, \"emVideoProfile\": 1 } ], \"atMainVidMixStatic\": [  ], \"byAssAudDecCount\": 0, \"byAssAudEncCount\": 0, \"byAssAudMixCount\": 0, \"byAssVidDecCount\": 1, \"byAssVidEncCount\": 1, \"byAssVidMixCount\": 0, \"byMainAudDecCount\": 1, \"byMainAudEncCount\": 1, \"byMainAudMixCount\": 0, \"byMainVidDecCount\": 1, \"byMainVidEncCount\": 1, \"byMainVidMixCount\": 0 } }";

 String joStr = "{name:\"张三\",age:\"20\"}";  
       Gson gson = new Gson();
       //user pr = gson.fromJson(joStr,class);
       JSONObject json = JSONObject.fromObject(pri);  
       System.out.println(json.getString("body"));
    }  
   public class user{
        ArrayList name;
        ArrayList age;
   
   }
}
