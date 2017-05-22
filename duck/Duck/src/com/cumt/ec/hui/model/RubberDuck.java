package com.cumt.ec.hui.model;

public class RubberDuck extends Duck {
	/**
	 * 构造橡皮鸭
	 * */
	public RubberDuck(){
        quackBehavior=new Squeak();
        flyBehavior=new FlyNoWay();
	}
	@Override
	public void display(){
		System.out.println("我是一只橡皮鸭 ！");
	};
}
