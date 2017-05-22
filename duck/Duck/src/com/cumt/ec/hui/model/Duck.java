package com.cumt.ec.hui.model;

public abstract class Duck {
	QuackBehavior quackBehavior;//叫声
    FlyBehavior flyBehavior;//飞行方式
	/**
	 * 鸭子游泳
	 * */
	public void swim(){
		System.out.println("游泳");
	}
	/**
	 * 鸭子外观
	 * */
	public void display(){
		System.out.println("外观");
	}
	/**
	 * 鸭子叫
	 * */
    public void performQuack(){
        quackBehavior.quack();
    }
    /**
     * 鸭子飞
     * */
    public void performFly(){
    	flyBehavior.fly();
    }  
    /**
     * 动态设置鸭子叫方式
     * */
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	 /**
     * 动态设置鸭子飞行方式
     * */
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}


}
