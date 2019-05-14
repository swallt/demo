package com.zhousx.RMI.client;

import com.zhousx.RMI.server.RMIService;
import com.zhousx.RMI.server.RMIUser;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            RMIService service = (RMIService) Naming.lookup("rmi://127.0.0.1:6600/rmiservice");
            RMIUser user = service.getUserById("12345");
            System.out.println(user.getName());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
