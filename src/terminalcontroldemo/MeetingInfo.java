/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminalcontroldemo;

import java.util.*;
import com.google.gson.*;
import terminalcontroldemo.HttpUtils;
import terminalcontroldemo.Sky300ini;

/**
 *
 * @author FIR
 */
public class MeetingInfo {

    public static String getKey(Map map, Object value) {
        String keys = "";
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object obj = entry.getValue();
            if (obj != null && obj.equals(value)) {
                keys = (String) entry.getKey();
            }

        }
        return keys;
    }

    static public void main(String args[]) {

        Gson gson = new Gson();
        String meetingInfo = HttpUtils.httpGet("http://172.16.177.240/mtapi/callinfo/callstatisticsinforeq?{\"head\":{\"sessionid\":\"undefined\",\"userid\":\"\",\"freeloginuser\":true,\"seqid\":null},\"body\":{\"eventid\":\"EV_GET_CALLSTATISTICSINFO_REQ\"}}");
        //JsonObject jsonData = new JsonParser().parse(meetingInfo).getAsJsonObject();
        JsonObject body = new JsonParser().parse(meetingInfo).getAsJsonObject().get("body").getAsJsonObject();

        JsonObject mainAudDec = body.get("atMainAudDecStatic").getAsJsonArray().get(0).getAsJsonObject();
        JsonObject mainAudEnc = body.get("atMainAudEncStatic").getAsJsonArray().get(0).getAsJsonObject();
        String mainAudEncFormat = getKey(Sky300ini.AudPrefer, mainAudEnc.get("emAudEncType").getAsString());
        String mainAudDecFormat = getKey(Sky300ini.AudPrefer, mainAudDec.get("emAudDecType").getAsString());

        JsonObject assVidDec = body.get("atAssVidDecStatic").getAsJsonArray().get(0).getAsJsonObject();
        JsonObject assVidEnc = body.get("atAssVidEncStatic").getAsJsonArray().get(0).getAsJsonObject();
        JsonObject mainVidDec = body.get("atMainVidDecStatic").getAsJsonArray().get(0).getAsJsonObject();
        JsonObject mainVidEnc = body.get("atMainVidEncStatic").getAsJsonArray().get(0).getAsJsonObject();

        String mainVidEncFormat = getKey(Sky300ini.VidPrefer, mainVidEnc.get("emVidEncType").getAsString());
        String mainVidDecFormat = getKey(Sky300ini.VidPrefer, mainVidDec.get("emVidDecType").getAsString());
        String assVidEncFormat = getKey(Sky300ini.VidPrefer, assVidEnc.get("emVidEncType").getAsString());
        String assVidDecFormat = getKey(Sky300ini.VidPrefer, assVidDec.get("emVidDecType").getAsString());

        String mainVidEncPAL = mainVidEnc.get("dwVidWidth").getAsString() + "*" + mainVidEnc.get("dwVidHeight").getAsString();
        String mainVidDecPAL = mainVidDec.get("dwVidWidth").getAsString() + "*" + mainVidDec.get("dwVidHeight").getAsString();
        String assVidEncPAL = assVidEnc.get("dwVidWidth").getAsString() + "*" + assVidEnc.get("dwVidHeight").getAsString();
        String assVidDecPAL = assVidDec.get("dwVidWidth").getAsString() + "*" + assVidDec.get("dwVidHeight").getAsString();

        String mainVidEncBitrate = mainVidEnc.get("dwEncBitrate").getAsString();
        String mainVidDecBitrate = mainVidDec.get("dwDecBitrate").getAsString();
        String assVidEncBitrate = mainVidEnc.get("dwEncBitrate").getAsString();
        String assVidDecBitrate = mainVidDec.get("dwDecBitrate").getAsString();

        String mainVidEncFrameRate = mainVidEnc.get("dwFrameRate").getAsString();
        String mainVidDecFrameRate = mainVidDec.get("dwFrameRate").getAsString();
        String assVidEncFrameRate = mainVidEnc.get("dwFrameRate").getAsString();
        String assVidDecFrameRate = mainVidDec.get("dwFrameRate").getAsString();

        System.out.println(mainVidEncFormat);
        System.out.println(assVidEncFormat);
        System.out.println(mainVidEncPAL);
    }
}
