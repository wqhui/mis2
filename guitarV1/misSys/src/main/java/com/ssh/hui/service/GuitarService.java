package com.ssh.hui.service;

import java.util.List;

import com.ssh.hui.po.Guitar;

public interface GuitarService extends BaseService<Guitar>{

    List<Guitar> queryGuitarListByGuitar(Guitar gtar);

   

}
