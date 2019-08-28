package com.example.demo.Service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
    Object info(String code, HttpServletRequest res, HttpServletResponse response);
}
