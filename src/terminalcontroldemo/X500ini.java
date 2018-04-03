/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminalcontroldemo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class X500ini {

    public static Map<String, String> VidPrefer = new LinkedHashMap<String, String>();
    public static Map<String, String> VidRes = new LinkedHashMap<String, String>();
    public static Map<String, String[]> mainVidPrefer = new LinkedHashMap<String, String[]>();
    public static Map<String, String[]> assVidPrefer = new LinkedHashMap<String, String[]>();
    public static Map<String, String> mainVidOutPAL = new LinkedHashMap<String, String>();
    public static Map<String, String> assVidOutPAL = new LinkedHashMap<String, String>();
    public static Map<String, String> audioFormat = new LinkedHashMap<String, String>();
    public static Map<String, String> VGAout = new LinkedHashMap<String, String>();
    public static Map<String, String> HDMI1out = new LinkedHashMap<String, String>();
    public static Map<String, String> HDMI2out = new LinkedHashMap<String, String>();
    public static Map<String, String> AudPrefer = new LinkedHashMap<String, String>();

    static {
        VidPrefer.put("H261", "0");
        VidPrefer.put("H262", "1");
        VidPrefer.put("H263", "2");
        VidPrefer.put("H263+", "3");
        VidPrefer.put("H264", "4");
        VidPrefer.put("H265", "6");
        VidPrefer.put("MPEG4", "5");

        VidRes.put("AUTO", "0");
        VidRes.put("SQCIF 88*72", "1");
        VidRes.put("QCIF 176*144", "2");
        VidRes.put("CIF(352*288)", "3");
        VidRes.put("2CIF(352*576)", "4");
        VidRes.put("4CIF(720*576)", "5");
        VidRes.put("16CIF(1408*1152)", "6");
        VidRes.put("SIF(352*240)", "7");
        VidRes.put("2SIF", "8");
        VidRes.put("4SIF(704*480)", "9");
        VidRes.put("VGA(640*480)", "10");
        VidRes.put("SVGA(800*600)", "11");
        VidRes.put("XGA(1024*768)", "12");
        VidRes.put("WCIF(512*288)", "13");
        VidRes.put("SQCIF(112*96)", "14");
        VidRes.put("SQCIF(96*80)", "15");
        VidRes.put("W4CIF(1024*576)", "16");
        VidRes.put("720P(1280*720)", "17");
        VidRes.put("SXGA(1280*1024)", "18");
        VidRes.put("UXGA(1600*1200)", "19");
        VidRes.put("1080I(1920*1080)", "20");
        VidRes.put("1080P(1920*1080)", "21");
        VidRes.put("WXGA(1280*800)", "22");
        VidRes.put("WSXGA(1440*900)", "23");
        VidRes.put("WXGA(1280*768)", "43");
        VidRes.put("WXGA(1366*768)", "44");
        VidRes.put("WSXGA1280*854", "45");
        VidRes.put("WSXGA+(1680*1050)", "46");
        VidRes.put("WUXGA(1920*1200)", "47");
        VidRes.put("4K*2K(3840*2160)", "48");
        VidRes.put("1280*600", "49");
        VidRes.put("1360*768", "50");

        mainVidPrefer.put("H265", new String[]{"AUTO", "1080P(1920*1080)", "720P(1280*720)", "W4CIF(1024*576)", "4CIF(704*576)", "WCIF(512*288)", "CIF(352*288)"});
        mainVidPrefer.put("H264", new String[]{"AUTO", "1080P(1920*1080)", "720P(1280*720)", "W4CIF(1024*576)", "4CIF(704*576)", "WCIF(512*288)", "CIF(352*288)"});
        mainVidPrefer.put("MPEG4", new String[]{"CIF(352*288)", "4CIF(704*576)"});
        mainVidPrefer.put("H261", new String[]{"CIF(352*288)"});
        mainVidPrefer.put("H263", new String[]{"CIF(352*288)"});

        assVidPrefer.put("H265", new String[]{"AUTO", "1080P(1920*1080)", "720P(1280*720)", "WSXGA+(1680*1050)", "UXGA(1600*1200)", "WSXGA(1440*900)", "WXGA(1366*768)", "SXGA(1280*1024)", "WXGA(1280*800)", "WXGA(1280*768)", "XGA(1024*768)"});
        assVidPrefer.put("H264", new String[]{"AUTO", "1080P(1920*1080)", "720P(1280*720)", "WSXGA+(1680*1050)", "UXGA(1600*1200)", "WSXGA(1440*900)", "WXGA(1366*768)", "SXGA(1280*1024)", "WXGA(1280*800)", "WXGA(1280*768)", "XGA(1024*768)"});
        assVidPrefer.put("MPEG4", new String[]{"CIF(352*288)", "4CIF(704*576)"});
        assVidPrefer.put("H263+", new String[]{"VGA(640*480)", "XGA(1024*768)"});
        assVidPrefer.put("H263", new String[]{"CIF(352*288)"});

        mainVidOutPAL.put("1080P60", "6");
        mainVidOutPAL.put("1080P24", "1");
        mainVidOutPAL.put("1080P25", "2");
        mainVidOutPAL.put("1080P29.97", "16");
        mainVidOutPAL.put("1080P30", "3");
        mainVidOutPAL.put("1080P50", "4");
        mainVidOutPAL.put("1080P59.94", "17");
        mainVidOutPAL.put("UXGA(1600*1200)", "30");
        mainVidOutPAL.put("WSXGA+(1680*1050)", "32");
        mainVidOutPAL.put("SXGA(1280*1024)", "24");
        mainVidOutPAL.put("WSXGA(1440*900)", "31");
        mainVidOutPAL.put("720P50", "9");
        mainVidOutPAL.put("720P60", "11");
        mainVidOutPAL.put("XGA(1024*768)", "22");
        mainVidOutPAL.put("WXGA(1366*768)", "29");
        mainVidOutPAL.put("WXGA(1280*800)", "27");

        assVidOutPAL.put("AUTO", "0");
        assVidOutPAL.put("1080P60", "6");
        assVidOutPAL.put("1080P24", "1");
        assVidOutPAL.put("1080P25", "2");
        assVidOutPAL.put("1080P29.97", "16");
        assVidOutPAL.put("1080P30", "3");
        assVidOutPAL.put("1080P50", "4");
        assVidOutPAL.put("1080P59.94", "17");
        //assVidOutPAL.put("UXGA(1600*1200)","30");
        assVidOutPAL.put("WSXGA+(1680*1050)", "32");
        assVidOutPAL.put("SXGA(1280*1024)", "24");
        assVidOutPAL.put("WSXGA(1440*900)", "31");
        assVidOutPAL.put("720P50", "9");
        assVidOutPAL.put("720P60", "11");
        assVidOutPAL.put("XGA(1024*768)", "22");
        assVidOutPAL.put("WXGA(1366*768)", "29");
        assVidOutPAL.put("WXGA(1280*800)", "27");

        audioFormat.put("Opus", "13");
        audioFormat.put("G711A", "0");
        audioFormat.put("G711U", "1");
        audioFormat.put("G722", "2");
        audioFormat.put("G728", "4");
        audioFormat.put("G729", "5");
        audioFormat.put("MP3", "6");
        audioFormat.put("G7221", "8");
        audioFormat.put("G719", "9");
        audioFormat.put("MPEGAACLC", "10");
        audioFormat.put("MPEGAACLD", "11");
//无输出, 主视频, 辅视频, VGA/YPbPr_1, 内置摄像机
        VGAout.put("无输出", "0");
        VGAout.put("主视频", "1");
        VGAout.put("辅视频", "3");
        VGAout.put("VGA/YPbPr_1", "24");
        VGAout.put("HDMI_1", "16");
        VGAout.put("内置摄像机", "11");

        HDMI1out.put("无输出", "0");
        HDMI1out.put("主视频", "1");
        HDMI1out.put("辅视频", "3");
        HDMI1out.put("HDMI1/YPbPr_1", "24");
        HDMI1out.put("HDMI_1", "16");
        HDMI1out.put("内置摄像机", "11");

        HDMI2out.put("无输出", "0");
        HDMI2out.put("主视频", "1");
        HDMI2out.put("辅视频", "3");
        HDMI2out.put("HDMI2/YPbPr_1", "24");
        HDMI2out.put("HDMI_1", "16");
        HDMI2out.put("内置摄像机", "11");

        AudPrefer.put("Opus", "12");
        AudPrefer.put("G722.1.C", "8");
        AudPrefer.put("G719", "9");
        AudPrefer.put("G722", "2");
        AudPrefer.put("G711A", "0");
        AudPrefer.put("G711U", "1");
        AudPrefer.put("G728", "4");
        AudPrefer.put("G729", "5");
        AudPrefer.put("MP4 LC", "10");
        AudPrefer.put("MP4 LD", "11");
        AudPrefer.put("MP4 LC立体声", "10");
        AudPrefer.put("MP4 LD立体声", "11");
        AudPrefer.put("MP3", "6");

    }

}
