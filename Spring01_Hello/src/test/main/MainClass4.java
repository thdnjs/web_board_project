package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Car;

public class MainClass4 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/main/init.xml");
		
		Car c1= (Car)context.getBean(Car.class);//아이디를 부여하지않고 type을 넣어줌
		
		c1.drive();
		
	}
}
