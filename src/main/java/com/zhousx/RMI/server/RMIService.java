package com.zhousx.RMI.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 第二步 定义实体接口，必须继承java.rmi.Remote
 */
public interface RMIService extends Remote {
    public RMIUser getUserById(String id) throws RemoteException;
}
