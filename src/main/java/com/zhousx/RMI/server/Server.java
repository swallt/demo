package com.zhousx.RMI.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            RMIService service = new RMIServiceImpl();
            //注册通讯端口
            LocateRegistry.createRegistry(6600);
            //注册通讯路径
            Naming.rebind("rmi://127.0.0.1:6600/rmiservice",service);
            System.out.println("service start!");
        } catch (RemoteException e){
            System.out.println("创建远程对象发生异常！");
            e.printStackTrace();
        } catch (MalformedURLException e){
            System.out.println("发生URL畸形异常！");
            e.printStackTrace();
        }
    }
}
