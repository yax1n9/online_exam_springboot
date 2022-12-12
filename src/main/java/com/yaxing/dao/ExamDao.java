package com.yaxing.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yaxing.domain.Exam;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yx
 * @date 2022/12/12
 */
@Mapper
public interface ExamDao extends BaseMapper<Exam> {
}
