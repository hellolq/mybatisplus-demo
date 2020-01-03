package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by H1N1 on 2020-01-02.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {

    // 新增信息定义
    public static final ResultObj ADD_SUCCESS = new ResultObj(Constast.OK,"新增成功");
    public static final ResultObj ADD_FAIL = new ResultObj(Constast.FAIL,"新增失败");

    // 删除信息定义
    public static final ResultObj DEL_SUCCESS = new ResultObj(Constast.OK,"删除成功");
    public static final ResultObj DEL_FAIL = new ResultObj(Constast.FAIL,"删除失败");

    // 更新信息定义
    public static final ResultObj UPDATE_SUCCESS = new ResultObj(Constast.OK,"更新成功");
    public static final ResultObj UPDATE_FAIL = new ResultObj(Constast.FAIL,"更新失败");


    private Integer code;
    private String msg;



}
