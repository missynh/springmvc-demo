package com.ynh.myproject.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * 调用rest接口
 * @author ynh on 2017/10/24.
 */
public class RestUtil {

    public String load(String url, String query) {

        try {

            //将url转变成URL类对象
            URL restUrl = new URL(url);
            //打开URL连接
            HttpURLConnection conn = (HttpURLConnection) restUrl.openConnection();
            //设置连接参数
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setAllowUserInteraction(false);

            //发送URL请求
            OutputStream outputStream = conn.getOutputStream();

            PrintStream ps = new PrintStream(outputStream);
            ps.print(query);
            ps.close();

            //获取响应
            InputStream inputStream = conn.getInputStream();

            BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder resultStr = new StringBuilder();

            while (null != (line = bReader.readLine())) {

                resultStr.append(line);
            }

            bReader.close();

            return resultStr.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static void main(String []args) {

        try {

            RestUtil restUtil = new RestUtil();

            String jsonStr = "{\"cmd\":\"cn_member/user/isAloneRole\",\"parameters\":{\"mobile\":\"17321204910\"}}";
            String resultString = restUtil.load("http://api.dev/cgi/", jsonStr);

            System.out.print(resultString);
        } catch (Exception e) {

            // TODO: handle exception

            System.out.print(e.getMessage());

        }

    }

}
