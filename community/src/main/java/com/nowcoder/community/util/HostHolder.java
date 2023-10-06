package com.nowcoder.community.util;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Component;



//作用：持有用户的信息，用于代替session对象
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user){  //存到ThreadLocal里
        users.set(user);
    }

    public User getUser(){   //从ThreadLocal里取
        return users.get();
    }

    //清除掉
    public void clear(){
        users.remove();
    }
}
