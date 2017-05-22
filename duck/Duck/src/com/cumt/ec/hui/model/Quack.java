package com.cumt.ec.hui.model;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {

		System.out.println("呱呱叫");
	}

}
