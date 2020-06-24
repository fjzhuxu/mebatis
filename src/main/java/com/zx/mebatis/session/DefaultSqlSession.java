package com.zx.mebatis.session;

import com.zx.mebatis.Executor;
import com.zx.test.mapper.BlogMapper;

public class DefaultSqlSession {

    Configuration configuration;
    Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration(){
        return   configuration;
    }

    public <T> T getMapper(Class<T> clazz){
        return configuration.getMapper(clazz, this);
    }


    public  <T> T selectOne(String statementId, Object param){
        String sql=   configuration.sqlMappings.getString(statementId);

        System.out.println(sql);
        System.out.println(param);
        return  new Executor(configuration).query(sql,param);
    }


}
