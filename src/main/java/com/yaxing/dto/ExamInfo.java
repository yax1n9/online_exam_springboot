package com.yaxing.dto;

import com.yaxing.domain.Exam;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author yx
 * @date 2022/12/19
 */
@Data
public class ExamInfo{
    private Exam exam;
    private ArrayList<Integer> questionIds;
}
