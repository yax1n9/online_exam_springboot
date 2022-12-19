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

    public ExamQuestion() {
    }

    public ExamQuestion(Integer examQuestionId, Integer questionId, Integer examId, Integer score, int isDelete) {
        this.examQuestionId = examQuestionId;
        this.questionId = questionId;
        this.examId = examId;
        this.score = score;
        this.isDelete = isDelete;
    }

    public ExamQuestion(Integer questionId, Integer examId, Integer score) {
        this.questionId = questionId;
        this.examId = examId;
        this.score = score;
    }

    public ExamQuestion(Integer questionId, Integer examId) {
        this.questionId = questionId;
        this.examId = examId;
    }
}
