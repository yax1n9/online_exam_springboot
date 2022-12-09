package com.yaxing.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author yx
 * @date 2022/12/5
 */
@Data
public class Student {
    @TableId
    @TableField("student_id")
    private Integer studentId;
    private String username;
    private String password;
    private String avatar;
    private String name;
    private String tel;
    private int gender;
    private int isDelete;
    private int role;
}
