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
    @Update("update exam set is_end=#{isEnd}, is_begin=#{isBegin} where exam_id = #{examId};")
    void updateStatus(Integer examId, int isEnd, int isBegin);
}
