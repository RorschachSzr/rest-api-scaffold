package spring.boot.rest.base_api.mapper;


import spring.boot.rest.common.mapper.MyMapper;
import spring.boot.rest.base_api.entity.User;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

    List<User> selectAll();
}