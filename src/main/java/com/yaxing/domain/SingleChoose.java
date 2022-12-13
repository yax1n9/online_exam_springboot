package com.yaxing.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author yx
 * @date 2022/12/13
 */
@Data
public class SingleChoose {
    @TableId("question_id")
    private Integer questionId;
    @TableField("subject_id")
    private Integer subjectId;
    private String title;
    @TableField("answer_a")
    private String answerA;
    @TableField("answer_b")
    private String answerB;
    @TableField("answer_c")
    private String answerC;
    @TableField("answer_d")
    private String answerD;
    @TableField("real_answer")
    private String realAnswer;
    @TableLogic
    @TableField("is_delete")
    private int isDelete;
    private int type;
}
