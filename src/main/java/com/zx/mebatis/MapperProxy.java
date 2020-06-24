package com.zx.mebatis;

import com.zx.mebatis.session.DefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {

    private DefaultSqlSession sqlSession = null;

    public MapperProxy(DefaultSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理的方法");
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
//        method.getAnnotatedReturnType()
        System.out.println(method.getAnnotatedReturnType());
        String statementId = mapperInterface + "." + methodName;

        System.out.println(statementId);
        return sqlSession.selectOne(statementId, args[0]);
    }
}
