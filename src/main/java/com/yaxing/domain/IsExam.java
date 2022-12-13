package com.yaxing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yx
 * @date 2022/12/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IsExam {
    private boolean isExam;
    private long remainingTime;
}
