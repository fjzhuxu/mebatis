package com.zx.test;

import com.zx.mebatis.session.DefaultSqlSession;
import com.zx.mebatis.session.SqlSessionFactory;
import com.zx.test.domian.Blog;
import com.zx.test.mapper.BlogMapper;

public class MeBatisTest {
    public static void main(String[] args) {
        SqlSessionFactory factory=new SqlSessionFactory();
        DefaultSqlSession sqlSession= factory.build().openSqlSession();
        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
      Blog blog=  blogMapper.selectBlogById(2);


//        Configuration configuration=  new Configuration();
//        SqlSession  sqlSession=new SqlSession(configuration,new Executor(configuration));
//        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
//      Blog blog=  blogMapper.selectBlogById(2);
//        System.out.println(blog);
    }
}
