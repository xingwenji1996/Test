package yndf.com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yndf.com.demo.UsersData.UserData;

@SpringBootApplication
//@MapperScan(value ={"yndf.com.demo.dao"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		UserData userData=new UserData();
//		userData.getUserData();
//		System.out.println(userData.getUserData());
	}

}
