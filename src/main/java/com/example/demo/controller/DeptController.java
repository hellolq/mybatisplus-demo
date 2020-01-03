package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Dept;
import com.example.demo.service.IDeptService;
import com.example.demo.utils.Constast;
import com.example.demo.utils.DataGridView;
import com.example.demo.utils.ResultObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author h1n1
 * @since 2020-01-03
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

	private final static Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
    private IDeptService _service;
	
	@RequestMapping("/saveDept")
    public ResultObj saveDept(@RequestBody Dept model) {
        try {
            this._service.save(model);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultObj.ADD_FAIL;
        }

    }
	
	@RequestMapping("/delDept")
    public ResultObj delDept(@RequestBody Dept model) {
        try {
            this._service.removeById(model);
            return ResultObj.DEL_SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultObj.DEL_FAIL;
        }

    }
	
	@RequestMapping("/updateDept")
    public ResultObj updateDept(@RequestBody Dept model) {
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
    @RequestMapping("/selectDeptList")
    public DataGridView selectDeptList(@RequestBody Dept model) {
        try {
            QueryWrapper queryWrapper = new QueryWrapper(model);
            List<Dept> list = this._service.list(queryWrapper);
            return new DataGridView(Constast.OK, Constast.MSG_OK, (long) list.size(), list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new DataGridView(Constast.FAIL, Constast.MSG_ERROR, e.getMessage());
        }

    }/*
    * 分页查询
    * */
    @RequestMapping("/selectDeptListByPage")
    public DataGridView selectDeptListByPage(@RequestBody Dept model) {
        try {

            Page<Dept> page = new Page(model.getPage(),model.getLimit());
            QueryWrapper queryWrapper = new QueryWrapper(model);
            IPage page1 = this._service.page(page, queryWrapper);
            return new DataGridView(Constast.OK, Constast.MSG_OK, (long) page1.getRecords().size(), page1);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new DataGridView(Constast.FAIL, Constast.MSG_ERROR, e.getMessage());
        }

    }


}

