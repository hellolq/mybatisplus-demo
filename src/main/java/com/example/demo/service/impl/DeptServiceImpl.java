package com.example.demo.service.impl;

import com.example.demo.entity.Dept;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author h1n1
 * @since 2020-01-03
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
