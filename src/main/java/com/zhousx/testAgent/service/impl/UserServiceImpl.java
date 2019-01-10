package com.zhousx.testAgent.service.impl;

import com.zhousx.testAgent.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public String getName(int id) {
        System.out.println("---------getName---------");
        return "tom";
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("-----------getAge-------------");
        return 10;
    }
}
