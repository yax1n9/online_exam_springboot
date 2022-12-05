package com.yaxing.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yaxing.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yx
 * @date 2022/12/5
 */
@Mapper
public interface AdminDao extends BaseMapper<Admin> {
}
