package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //                                             起始行行号      每页显示多少条数据
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>（动态标签拼接）里使用,则必须加别名.
    //查询帖子的行数
    int selectDiscussPostRows(@Param("userId") int userId);

}
