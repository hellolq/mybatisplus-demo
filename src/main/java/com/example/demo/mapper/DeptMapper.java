package com.example.demo.mapper;

import com.example.demo.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author h1n1
 * @since 2020-01-03
 */
@Repository
//@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

}
