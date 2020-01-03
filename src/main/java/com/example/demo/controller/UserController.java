package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.example.demo.utils.Constast;
import com.example.demo.utils.DataGridView;
import com.example.demo.utils.ResultObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author h1n1
 * @since 2019-12-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService _service;

    @RequestMapping("/saveUser")
    public ResultObj saveUser(@RequestBody User model) {
        try {
            this._service.save(model);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultObj.ADD_FAIL;
        }

    }

    @RequestMapping("/delUser")
    public ResultObj delUser(@RequestBody User model) {
        try {
            this._service.removeById(model);
            return ResultObj.DEL_SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultObj.DEL_FAIL;
        }

    }

    @RequestMapping("/updateUser")
    public ResultObj updateUser(@RequestBody User model) {
        try {
            this._service.updateById(model);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultObj.UPDATE_FAIL;
        }

    }

    /*
    * 不分页查询
    * */
    @RequestMapping("/selectUserList")
    public DataGridView selectUserList(@RequestBody User model) {
        try {
            QueryWrapper queryWrapper = new QueryWrapper(model);
            List<User> list = this._service.list(queryWrapper);
            return new DataGridView(Constast.OK, Constast.MSG_OK, (long) list.size(), list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new DataGridView(Constast.FAIL, Constast.MSG_ERROR, e.getMessage());
        }

    }

    /*
    * 分页查询
    * */
    @RequestMapping("/selectUserListByPage")
    public DataGridView selectUserListByPage(@RequestBody User model) {
        try {

            Page<User> page = new Page(model.getPage(),model.getLimit());
            QueryWrapper queryWrapper = new QueryWrapper(model);
            IPage page1 = this._service.page(page, queryWrapper);
            return new DataGridView(Constast.OK, Constast.MSG_OK, (long) page1.getRecords().size(), page1);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new DataGridView(Constast.FAIL, Constast.MSG_ERROR, e.getMessage());
        }

    }

}

