package com.cumt.ec.hui.model;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {

		System.out.println("不会叫");
		
	}

}
