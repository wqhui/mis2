package com.cumt.ec.hui.model;

public class RedHatDuck extends Duck {
	/**
	 * 构造红帽鸭
	 * */
	public RedHatDuck(){
        quackBehavior=new MuteQuack();
        flyBehavior=new FlyWithRocket();
	}
	@Override
	public void display(){
		System.out.println("我是一只红帽鸭 ！");
	};
}
