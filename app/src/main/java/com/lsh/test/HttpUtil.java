package com.lsh.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by LSH on 2016/10/12.
 */

public class HttpUtil {

    public static byte[] loadJson(String path){
        try {
            URL url=new URL(path);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            if(conn.getResponseCode()==200){
                InputStream is = conn.getInputStream();
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                int len=0;
                byte[] buffer=new byte[1024];
                while((len=is.read(buffer))!=-1){
                    baos.write(buffer,0,len);
                    baos.close();
                }
                is.close();
                baos.close();
                return baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
