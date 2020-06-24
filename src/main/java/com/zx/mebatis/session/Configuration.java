package com.zx.mebatis.session;

import com.zx.mebatis.MapperProxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Configuration {
    public  static  final ResourceBundle sqlMappings;
    public  static  final ResourceBundle propertiesValue;

    // 所有Mapper接口
    private List<Class<?>> mapperList = new ArrayList<>();
    static {

        System.out.println("static");
        sqlMappings=ResourceBundle.getBundle("sql");
        propertiesValue=ResourceBundle.getBundle("db");
    }

    public Configuration() {
        //构造方法
        System.out.println("Configuration");
       //解析构造方法中的mapper

       //解析注解的中的mapper



    }

    public <T>T getMapper(Class clazz,DefaultSqlSession sqlSession){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));

    }



    public String  getPropertiesValue(String key){
        return  propertiesValue.getString(key);
    }

}
