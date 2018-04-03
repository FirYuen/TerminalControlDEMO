/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminalcontroldemo;

/**
 *
 * @author FIR
 */
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;

public class TelnetUtil {

    private TelnetClient telnet = new TelnetClient();// telnet有VT100 VT52 VT220 VTNT ANSI等协议。  
    private InputStream in;
    private PrintStream out;
    private static final String KDPrompt = "kdvmt->";
    private String port; // telnet 端口   
    private String user;   // 用户名  
    private String password; // 密码  
    private String ip;  // IP 地址  
    private static final int DEFAULT_TELNET_PORT = 23;      // 缺省端口  

    public TelnetUtil(String ip, String user, String password) {
        this.ip = ip;
        
        this.user = user;
        this.password = password;
    }

    /**
     * @return boolean 连接成功返回true，否则返回false
     */
    private boolean connect() {
        boolean isConnect = true;
        try {
            telnet.connect(ip, Integer.parseInt("2501"));
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());
            readUntil("sername:");
            write("\n");
            readUntil("assword:");
            write("\n");
   
            try {
                char ch = (char) in.read();
                char fakepromt = '>';
                char fp2 = ':';
                StringBuffer sb = new StringBuffer();

                System.out.println(ch);
                while (true) {
                    //System.out.println(ch);
                    sb.append(ch);
                    
                    if (ch == fp2 && sb.toString().contains("ser")) {
                        //readUntil("sername:");
                        System.out.println("found uerinput");
                        write(user);
                        readUntil("assword:");
                        write(password);

                        readUntil(KDPrompt);
                        System.out.println("2501 connected");
                        return isConnect;
                    } else if (ch == fakepromt) {

                        telnet.connect(ip, Integer.parseInt("2500"));
                        in = telnet.getInputStream();
                        out = new PrintStream(telnet.getOutputStream());
                        readUntil("sername:");
                        write(user);
                        readUntil("assword:");
                        write(password);

                        readUntil(KDPrompt);
                        System.out.println("2500 connected");
                        return isConnect;

                    }
                    ch = (char) in.read();
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            isConnect = false;
            e.printStackTrace();
            return isConnect;
        }
        return isConnect;
    }

    public String readUntil(String pattern) {
        try {
            char lastChar = pattern.charAt(pattern.length() - 1);
            StringBuffer sb = new StringBuffer();
            char ch = (char) in.read();
            while (true) {
                sb.append(ch);
                if (ch == lastChar) {
                    if (sb.toString().endsWith(pattern)) {
                        // 处理编码，界面显示乱码问题  
                        byte[] temp = sb.toString().getBytes("iso8859-1");
                        System.out.println(new String(temp, "GBK"));
                        return new String(temp, "GBK");
                    }
                }
                ch = (char) in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(String value) {
        try {
            out.println(value);
            out.flush();
            // System.out.println(value);// ---需要注释掉  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendCommand(String command) {
        try {
            write(command);
            return readUntil(KDPrompt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void disconnect() {
        try {
            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void su(String user, String password) {
        try {
            write("su" + " - " + user);
            readUntil("Password:");
            write(password);
            readUntil(KDPrompt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        public String mtupgrade() {
        this.connect();
        String result = this.sendCommand("mtupgrade");
        this.disconnect();
        // 去除命令提示符  
        return result.substring(0, result.indexOf(KDPrompt));
    }

    public String vencstatus() {
        this.connect();
        String result = this.sendCommand("vencstatus");
        this.disconnect();
        // 去除命令提示符  
        return result.substring(0, result.indexOf(KDPrompt));
    }
        public String vencstatis() {
        this.connect();
        String result = this.sendCommand("vencstatuis");
        this.disconnect();
        // 去除命令提示符  
        return result.substring(0, result.indexOf(KDPrompt));
    }
public String doPreSetting() {
        this.connect();
        this.sendCommand("mtsetblockreboot 0");
        this.sendCommand("setssh on");
        this.sendCommand("setftp on");
        this.sendCommand("setftp off");
        this.sendCommand("setftp on");
        String result = this.sendCommand("osdlog 1");
        this.disconnect();
        // 去除命令提示符  
        return result.substring(0, result.indexOf(KDPrompt));
    }
    
    public static void main(String[] args) {
        TelnetUtil telnet = new TelnetUtil("172.16.178.217", "admin", "admin");

        System.out.println(telnet.vencstatus());
    }

}
