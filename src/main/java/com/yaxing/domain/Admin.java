package com.yaxing.domain;

import lombok.Data;

/**
 * @author yx
 * @date 2022/12/5
 */
@Data
public class Admin {
    private Integer adminId;
    private String username;
    private String password;
    private String avatar;
    private String name;
    private String tel;
    private int gender;
    private int isDelete;
    private int role;
}
