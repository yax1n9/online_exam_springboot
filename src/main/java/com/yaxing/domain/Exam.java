package com.yaxing.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author yx
 * @date 2022/12/12
 */
@Data
public class Exam {
    @TableId("exam_id")
    private Integer examId;
    private String title;
    private String cover;
    @TableField("subject_id")
    private Integer subjectId;
    @TableField("start_time")
    private Timestamp startTime;
    @TableField("end_time")
    private Timestamp endTime;
    @TableField("latest_enter_time")
    private Integer latestEnterTime;
    @TableField("shortest_submit_time")
    private Integer shortestSubmitTime;
    @TableField("pass_line")
    private Integer passLine;
    @TableLogic
    @TableField("is_delete")
    private int isDelete;
    @TableField("is_end")
    private int isEnd;
}
