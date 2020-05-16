package com.zx.test;

import com.zx.mebatis.Configuration;
import com.zx.mebatis.Executor;
import com.zx.mebatis.SqlSession;
import com.zx.test.domian.Blog;
import com.zx.test.mapper.BlogMapper;

public class MeBatisTest {
    public static void main(String[] args) {
        Configuration configuration=  new Configuration();
        SqlSession  sqlSession=new SqlSession(configuration,new Executor(configuration));
        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
      Blog blog=  blogMapper.selectBlogById(2);
        System.out.println(blog);
    }
}
