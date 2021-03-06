package com.zx.mebatis;

import com.zx.mebatis.session.Configuration;
import com.zx.test.domian.Blog;

import java.sql.*;

public class Executor {
    private Configuration configuration;

    public Executor(Configuration configuration) {
        this.configuration = configuration;
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        String driver = configuration.getPropertiesValue("driver");
        String url = configuration.getPropertiesValue("url");
        String username = configuration.getPropertiesValue("username");
        String password = configuration.getPropertiesValue("password");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public <T> T query(String sql, Object param) {
        Connection conn =null;
                Statement stmt = null;
        Blog blog = new Blog();

        try {

              conn =   getConnection() ;
            // 执行查询
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( String.format(sql,param));

            // 获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
             System.out.println(blog);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T) blog;
    }
}
