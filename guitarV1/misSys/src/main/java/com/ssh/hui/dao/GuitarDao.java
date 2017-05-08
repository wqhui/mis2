package com.ssh.hui.dao;

import java.util.List;

import com.ssh.hui.po.Guitar;

public interface GuitarDao extends BaseDao<Guitar>{

    List<Guitar> queryGuitarListByGuitar(Guitar gtar);

}
