package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author h1n1
 * @since 2019-12-18
 */
@Repository
//@Mapper
public interface UserMapper extends BaseMapper<User> {

}
