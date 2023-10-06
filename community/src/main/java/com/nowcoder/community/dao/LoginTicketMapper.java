package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginTicketMapper {

    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    //声明sql相关的机制的注解@Options  useGeneratedKeys：自动生成主键  keyProperty：主键为谁
    @Options(useGeneratedKeys = true, keyProperty = "id")
    //插入一条数据  ticket是登录凭证，是客户端发给服务器的唯一标识
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    @Update({
            "<script>",
            "update login_ticket set status=#{status} where ticket=#{ticket} ",
            "<if test=\"ticket!=null\"> ",
            "and 1=1 ",
            "</if>",
            "</script>"
    })
    //修改凭证的状态 表示失效还是有效  ticket传进来，然后要变成什么状态。
    int updateStatus(String ticket, int status);

}
