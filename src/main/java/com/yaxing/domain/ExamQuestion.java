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
public class ExamQuestion {
    @TableId("exam_question_id")
    private Integer examQuestionId;
    @TableField("question_id")
    private Integer questionId;
    @TableField("exam_id")
    private Integer examId;
    private Integer score;
    @TableLogic
    @TableField("is_delete")
    private int isDelete;
}
