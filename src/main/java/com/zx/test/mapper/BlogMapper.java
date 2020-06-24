package com.zx.test.mapper;

import com.zx.mebatis.annotaion.Entity;
import com.zx.mebatis.annotaion.Select;
import com.zx.test.domian.Blog;

@Entity(Blog.class)
public interface BlogMapper {
    @Select("select * from blog where bid = ?")
    public Blog selectBlogById(Integer bid);


}
