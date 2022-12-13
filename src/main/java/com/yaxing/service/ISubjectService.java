package com.yaxing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yaxing.domain.Subject;

/**
 * @author yx
 * @date 2022/12/9
 */
public interface ISubjectService extends IService<Subject> {
    /**
     * 按条件分页查询
     *
     * @param currentPage 当前页
     * @param pageSize    页容量
     * @param subject     条件
     * @return 查询到的数据
     */
    IPage<Subject> getPageByCondition(Integer currentPage, Integer pageSize, Subject subject);
}
