package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass2 {
	public static void main(String[] args) {
		/*
		 *  무언가를 공격하고 싶은데..
		 *  Spring 방식으로 공격하자!
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("test/main/init.xml");
		
		/*
		 * 필요한 객체를 직접 new하지 않고
		 * Spring bean 컨테이너에서 필요한 객체를 얻어와서
		 * interface type으로 사용하기
		 */
		

		Weapon w1 = (Weapon)context.getBean("myWeapon");
		
		w1.attack();
		
		
		
	}
}
