package com.yaxing.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author yx
 * @date 2022/12/9
 */
@Data
public class Subject {
    @TableId("subject_id")
    private Integer subjectId;
    private String name;
    @TableLogic
    @TableField("is_delete")
    private int isDelete;
}
