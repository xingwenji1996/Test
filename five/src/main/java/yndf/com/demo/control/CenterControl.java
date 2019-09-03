package yndf.com.demo.control;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.net.www.http.HttpClient;
import yndf.com.demo.UsersData.UserData;
import yndf.com.demo.pojo.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin  //跨域
public class CenterControl {
    @Autowired
    UserData userData;
    @RequestMapping(value = "/searchAll" )
    public List searchAll() {
        System.out.println(1);
        System.out.println(userData.getUserData());
//        userData.getUserData().entrySet();
        System.out.println(2);
        //System.out.println(userData.getUserData().entrySet());
        System.out.println(3);
        //System.out.println(userData.getUserData().keySet());
        System.out.println(4);
        //System.out.println(userData.getUserData().values());
        return userData.getUserData();
    }


    @RequestMapping(value = "/insertAll" )
    public void insertAll() {
//        String url = "http://localhost:8080/searchAll";
//        HttpClient
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("http://localhost:8080/searchAll");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("a1:"+responseEntity);

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
               // System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
              //  List<Users> list=new ArrayList<Users>()；
               Object obj=JSONObject.fromObject(responseEntity);
               // System.out.println(obj.toString());
               // JSONArray obj2 = JSONArray.fromObject(EntityUtils.toString(responseEntity));
   //           System.out.println(obj2.toArray()[0].toString());
               List<Users> list=  (ArrayList<Users>) obj;
                for (Users u:list){
     //             JSONObject object = (JSONObject) obj2.get(i);     //将array中的数据进行逐条转换
       //           Users users = (Users) JSONObject.toBean(object, Users.class);  //通过JSONObject.toBean()方法进行对象间的转换
         //         list.add(users);
                    System.out.println("list"+u.toString()    );
                }
//                System.out.println("dd"+obj2.toString());
              //  System.out.println(list.toArray()[0].toString());
                //JSONArray json = JSONArray.fromObject(EntityUtils.toString(responseEntity));
              //  System.out.println("a1:"+json);
//                for (Users users:list){
//
//                    System.out.println(users.toString());
//                }

            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
