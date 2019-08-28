package com.example.demo.Service;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ServiceImpl implements Service {

    @RequestMapping("/getinfo")
    public Object info(String code , HttpServletRequest res, HttpServletResponse response){
        String ss=res.getParameter("shu");
        response.setHeader("Access-Control-Allow-Origin","*");
        entiy user=new entiy();
        user.setCodeId(ss);
        user.setName("邢文极");
        user.setType("技术开发");
         JSONObject json=JSONObject.fromObject(user);
        System.out.print("返回的json"+json);
        return json;
    }
}
