package com.ssh.hui.service.impl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ssh.hui.domain.Inventory;
import com.ssh.hui.po.Guitar;
import com.ssh.hui.service.GuitarService;

import net.sf.json.JSONArray;

@Lazy(true)
@Service("guitarService")
public class GuitarServiceImpl extends BaseServiceImpl<Guitar> implements GuitarService{

    @Override
    public List<Guitar> queryGuitarListByGuitar(Guitar gtar) {  
        Inventory inventory = new Inventory();   
        List <Guitar> lg=guitarDao.queryAll();
        for(Guitar g:lg) {
            System.out.println(g.getSpec().getType());
            System.out.println(g.getSpec().getBackWood()+"-----------------------");
        }
        List <Guitar> matchingGuitars = inventory.search(gtar.getSpec(),lg );
        return matchingGuitars;
    }




}
