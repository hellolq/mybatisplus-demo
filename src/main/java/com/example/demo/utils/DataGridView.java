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
public class DataGridView {

    private Integer code=0;
    private String msg="";
    private Long count=0L;
    private Object data;

    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }
    public DataGridView(Object data) {
        super();
        this.data = data;
    }
    public DataGridView(Integer code,String msg,Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
