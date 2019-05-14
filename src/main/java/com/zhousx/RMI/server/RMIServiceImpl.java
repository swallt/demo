package com.zhousx.RMI.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 第三步 实现接口
 */
public class RMIServiceImpl extends UnicastRemoteObject implements RMIService {

    private static final long serialVersionUID = 9876543210L;

    public RMIServiceImpl() throws RemoteException{
        super();
    }

    @Override
    public RMIUser getUserById(String id) throws RemoteException {
        RMIUser user = new RMIUser();
        user.setId(id);
        user.setName("test");
        user.setAge(20);
        return user;
    }
}
