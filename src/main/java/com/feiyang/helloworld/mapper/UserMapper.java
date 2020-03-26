package com.feiyang.helloworld.mapper;

import com.feiyang.helloworld.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })

    @Select("select * from user order by id")
        //查询所有的用户
    List<User> getAllUser ( );

    @Options(useGeneratedKeys = true, keyProperty = "id")//是指定主键生成的并且主键是id
    @Insert("insert into user(name,gender,age,address,qq,email) values (#{name},#{gender},#{age},#{address},#{qq},#{email})")
    int insertUser (User user);

    //删作用户数据
    @Delete("delete from user where id=#{id}")
    public int delUserById(Integer id);

    //更新用户数据

    @Update("update user set gender=#{gender},age=#{age},address=#{address},qq=#{qq},email=#{email} where name=#{name}")
    public int updateUser(User user);


}