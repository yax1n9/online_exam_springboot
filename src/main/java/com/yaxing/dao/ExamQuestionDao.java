package com.yaxing.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yaxing.domain.ExamQuestion;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yx
 * @date 2022/12/13
 */
@Mapper
public interface ExamQuestionDao extends BaseMapper<ExamQuestion> {
}
