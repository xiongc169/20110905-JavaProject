package com.yoong.web.mybatis.service.impl;

import com.yoong.web.mybatis.mapper.MenuMapper;
import com.yoong.web.mybatis.model.Menu;
import com.yoong.web.mybatis.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc MenuServiceImpl.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    public MenuMapper menuMapper;

    @Override
    public Menu insertMenu(Menu menu) {
        int effectRows = menuMapper.insert(menu);
        System.out.println("effectRows: " + effectRows + ", Id: " + menu.getId());
        //double aa = 10 / 0;
        menu.setId(null);
        int effectRows2 = menuMapper.insert(menu);
        System.out.println("effectRows2: " + effectRows2 + ", Id: " + menu.getId());
        return menu;
    }
}
