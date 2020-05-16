package com.zx.mebatis;



public class SqlSession {

    Configuration configuration;
    Executor executor;


    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }



    public  <T> T selectOne(String statementId, Object param){
       String sql=   configuration.sqlMappings.getString(statementId);

        System.out.println(sql);
        System.out.println(param);
        return  executor.query(sql,param);
    }

    public  <T> T getMapper(Class clazz){

        return  configuration.getMapper(clazz,this);
    }
}
