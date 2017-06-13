package com.ssh.hui.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssh.hui.po.Guitar;
import com.ssh.hui.po.spec.GuitarSpec;

@Component("inventory")
public class Inventory {
    /**
     * 根据条件和已有的列表查询符合条件的guitar
     * @param searchSpec :TODO(查询条件)
     * @param guitars :TODO(已有列表)
     * @return 符合查询的Guitar类
     * */
    public List<Guitar> search(GuitarSpec searchSpec,List<Guitar> guitars) { 
        List<Guitar> matchingGuitars = new LinkedList<Guitar>(); 
        for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) { 
            Guitar guitar = i.next();
            if(guitar.getSpec().matches(searchSpec)){
                matchingGuitars.add(guitar);
            }
             
        } 
        return matchingGuitars; 
    }


}
