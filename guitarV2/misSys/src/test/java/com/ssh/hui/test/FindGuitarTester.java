package com.ssh.hui.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ssh.hui.domain.Inventory;
import com.ssh.hui.po.Builder;
import com.ssh.hui.po.Guitar;
import com.ssh.hui.po.Type;
import com.ssh.hui.po.Wood;
import com.ssh.hui.po.spec.GuitarSpec;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();   
    
    List<Guitar> allGuitars=initializeInventory();//添加guitar列表
      
    
    GuitarSpec whatErinLikes = 
      new GuitarSpec(Builder.JIANGSU, "Stratocastor", 
                     Type.ACOUSTIC, Wood.CAMPHOR, Wood.CAMPHOR);
    List matchingGuitars = inventory.search(whatErinLikes,allGuitars);
    if (!matchingGuitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars:");
      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("  We have a " +
          spec.getBuilder() + " " + spec.getModel() + " " +
          spec.getType() + " guitar:\n     " +
          spec.getBackWood() + " back and sides,\n     " +
          spec.getTopWood() + " top.\n  You can have it for only $" +
          guitar.getPrice() + "!\n  ----");
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }

  private static List<Guitar> initializeInventory() {
     List<Guitar> allGuitarList=new ArrayList<Guitar>();//手动添加的guitar列表
     allGuitarList.add(new Guitar("110", 110.0,
            new GuitarSpec(Builder.BEIJING, "CJ", Type.ACOUSTIC,Wood.BRICH, Wood.BRICH)) 
      );
     allGuitarList.add(new Guitar("119", 119.0, 
      new GuitarSpec(Builder.JIANGSU, "Stratocastor", Type.ACOUSTIC, Wood.CAMPHOR, Wood.CAMPHOR)));
     allGuitarList.add(new Guitar("V9512", 1549.95, 
      new GuitarSpec(Builder.GUANGZHOU, "Stratocastor", Type.ELECTRIC,Wood.KOREANPINE, Wood.KOREANPINE)));
    return allGuitarList;
  }
}
