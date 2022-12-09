package com.yaxing.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author yx
 * @date 2022/12/9
 */
@Data
public class Subject {
    @TableId
    @TableField("subject_id")
    private Integer subjectId;
    private String name;
    private int is_delete;
}
