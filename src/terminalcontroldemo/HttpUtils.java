/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminalcontroldemo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author Administrator
 */
public class HttpUtils {

    /**
     * 发起get请求
     *
     * @param url
     * @return
     */
    public static String httpGet(String url) {
        String result = null;
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送httppost请求
     *
     * @param url
     * @param data 提交的参数为key=value&key1=value1的形式
     * @return
     */
    public static String httpPost(String url, String data) {
        String result = null;
        Response response = null;
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/html;charset=utf-8"), data);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            response = httpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    static public void main(String args[]) {
        System.out.println(httpPost("http://172.16.177.176/mtapi/conf/makecall", "{\"head\":{\"sessionid\":\"undefined\",\"userid\":\"2cV8lI4UycvqiZv9bjga5Yrv698tZSG\",\"freeloginuser\":true,\"seqid\":null},\"body\":{\"param1\":{\"basetype\":\"172.16.177.239\"},\"param2\":{\"basetype\":1024},\"param3\":{\"basetype\":1}}}"));
        System.out.println(httpGet("http://172.16.177.176/mtapi/entity/globalstate?{%22head%22:{%22sessionid%22:%22undefined%22,%22userid%22:%22%22,%22freeloginuser%22:true,%22seqid%22:null},%22body%22:{}}"));
    }
}
