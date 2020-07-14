package com.mapper;

import com.entity.QuerryVo;
import com.entity.User;
import com.entity.UserCustom;

import java.util.List;

public interface UserMapper {
    public List<User> selectAll();

    public User findById(Integer id);

    public List<User> findByName(String name);

    public void saveUser(User user);

    public void deleteUserById(Integer id);

    public void updateUser(User user);

    public List<UserCustom> selectByQuerryVo(QuerryVo vo);
}
