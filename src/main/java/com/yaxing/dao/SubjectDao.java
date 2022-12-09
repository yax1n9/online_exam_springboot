package com.yaxing.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yaxing.domain.Subject;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yx
 * @date 2022/12/9
 */
@Mapper
public interface SubjectDao extends BaseMapper<Subject> {
}
