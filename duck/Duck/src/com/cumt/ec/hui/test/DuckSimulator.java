package com.cumt.ec.hui.test;

import org.junit.Test;

import com.cumt.ec.hui.model.Duck;
import com.cumt.ec.hui.model.FlyNoWay;
import com.cumt.ec.hui.model.FlyWithWings;
import com.cumt.ec.hui.model.MallardDuck;
import com.cumt.ec.hui.model.Quack;
import com.cumt.ec.hui.model.RedHatDuck;
import com.cumt.ec.hui.model.RubberDuck;
import com.cumt.ec.hui.model.Squeak;

public class DuckSimulator {

	@Test
	public void test(){
		
        Duck mallardDuck=new MallardDuck();        
        mallardDuck.display();
        mallardDuck.swim();
        mallardDuck.performFly();
        mallardDuck.performQuack();	
        
        System.out.println("------------");
        
        Duck redHatDuck =  new RedHatDuck ();
        redHatDuck.display();
        redHatDuck.swim();
        redHatDuck.performFly();
        redHatDuck.performQuack();	
        System.out.println("------------");
        
        Duck rubberDuck= new RubberDuck();
        rubberDuck.display();
        rubberDuck.swim();
        rubberDuck.performFly();
        rubberDuck.performQuack();	
        System.out.println("------------");
	}

}
