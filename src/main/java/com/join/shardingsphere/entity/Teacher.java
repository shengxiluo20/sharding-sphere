package com.join.shardingsphere.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author chi  2019-06-12 10:33
 **/
@Data
@Accessors(chain = true)
@TableName("teacher")
public class Teacher {

    /**
     * 主键Id
     */
    private int id;

    /**
     * 名称
     */
    private String name;

}
