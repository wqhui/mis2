package com.ssh.hui.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ssh.hui.dao.GuitarDao;
import com.ssh.hui.po.Guitar;
import com.ssh.hui.service.GuitarService;
@Lazy(true)
@Repository("guitarDao")
public class GuitarDaoImpl extends BaseDaoImpl<Guitar> implements GuitarDao{

    @Override
    public List<Guitar> queryGuitarListByGuitar(Guitar gtar) {      	
    	Criteria cr = getSession().createCriteria(Guitar.class);
         if(null !=gtar.getBackWood() && !gtar.getBackWood().equals("")){
        	 cr.add(Restrictions.like("backWood", gtar.getBackWood()));
         };
         if(null !=gtar.getTopWood() && ! gtar.getTopWood().equals("")){
        	 cr.add(Restrictions.like("topWood", gtar.getTopWood()));
         };
         if(0.0!=gtar.getPrice()){
        	 cr.add(Restrictions.eq("price", gtar.getPrice()));
         };
         if(null !=gtar.getBuilder() && ! gtar.getBuilder().equals("")){
        	 cr.add(Restrictions.like("builder", gtar.getBuilder()));
         };
         if(null !=gtar.getModel() && ! gtar.getModel().equals("")){
        	 cr.add(Restrictions.like("model", gtar.getModel())); 
         };   	
         if(null !=gtar.getType() && ! gtar.getType().equals("")){
        	 cr.add(Restrictions.like("type", gtar.getType())); 
         };
         List<Guitar> gList=cr.list();
        return gList;  
    }



}
