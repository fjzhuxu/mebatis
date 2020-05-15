package com.zx.mebatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession = null;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理的方法");
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface + "." + methodName;

        System.out.println(statementId);
        return sqlSession.selectOne(statementId, args[0]);
    }
}
