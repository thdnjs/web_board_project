package test.main;

import test.mypac.WeaponImpl;

public class MainClass {
	
	public static void main(String[] args) {
		/*
		 * 무언가를 공격하고 싶다면?
		 * 어떻게 해야 할까? 
		 */
		WeaponImpl w1 = new WeaponImpl();//의존 객체를 직접 new해서 쓰는건 좋지 않다
		//그래서 객체 관리를 spring한테 맡기고 타입을 interface로 쓴다 
		w1.attack();
				 
	}
}
