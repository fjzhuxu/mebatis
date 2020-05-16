package com.zx.mebatis;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class Configuration {
    public  static  final ResourceBundle sqlMappings;
    public  static  final ResourceBundle dbMappings;
    static {
        sqlMappings=ResourceBundle.getBundle("sql");
        dbMappings=ResourceBundle.getBundle("db");
    }

    public <T> T getMapper(Class clazz,SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));
    }
}
