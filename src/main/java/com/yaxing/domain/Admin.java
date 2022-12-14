package com.yaxing.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author yx
 * @date 2022/12/5
 */
@Data
public class Admin {
    @TableId("admin_id")
    private Integer adminId;
    private String username;
    private String password;
    private String avatar;
    private String name;
    private String tel;
    private int gender;
    @TableLogic
    @TableField("is_delete")
    private int isDelete;
    private int role;
}
