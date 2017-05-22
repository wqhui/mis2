package com.cumt.ec.hui.model;

public class MallardDuck extends Duck {
	/**
	 * 构造野鸭
	 * */
	public MallardDuck(){
		 quackBehavior=new Quack();
	     flyBehavior=new FlyWithWings();
	}
    @Override
    public void display(){
        System.out.println("我是一只野鸭！");
    }
}
