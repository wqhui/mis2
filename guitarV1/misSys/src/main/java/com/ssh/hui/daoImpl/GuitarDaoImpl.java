package com.ssh.hui.daoImpl;

import java.util.List;

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
        return null;
    }

}
