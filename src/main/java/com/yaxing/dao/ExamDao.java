package com.yaxing.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yaxing.domain.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author yx
 * @date 2022/12/12
 */
@Mapper
public interface ExamDao extends BaseMapper<Exam> {
    @Update("update exam set is_end=1 where exam_id = #{examId};")
    void updateIsEnd(Integer examId);
}
