package com.yaxing.domain;

import lombok.Data;

/**
 * @author yx
 * @date 2022/12/9
 */
@Data
public class Register {
    private String username;
    private String password;
    private String avatar;
    private String name;
    private String tel;
    private int gender;
    private int isDelete;
    private int role;
}
