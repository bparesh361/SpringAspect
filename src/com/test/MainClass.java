package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.jdbc.CircleJdbc;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
//		Circle c = context.getBean(Circle.class);
//		c.draw();
//		c.drawTest(1);
//		Rectangle r = context.getBean(Rectangle.class);
//		r.draw();
		
		CircleJdbc jdbc = context.getBean(CircleJdbc.class);
		System.out.println(jdbc.getCircleCount());
		System.out.println(jdbc.getCircleById(1));
		System.out.println(jdbc.getAllCircle());

	}

}
