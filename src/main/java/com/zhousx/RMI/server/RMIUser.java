package com.zhousx.RMI.server;

import lombok.Data;

import java.io.Serializable;

/**
 * 第一步 定义要传输的实体类，由于要网络传输，必须实现序列化
 */
@Data
public class RMIUser implements Serializable {
    private static final long serialVersionUID = 1234567890L;
    private String id;
    private String name;
    private int age;
}
