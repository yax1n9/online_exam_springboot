package com.yaxing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yaxing.domain.SingleChoose;

/**
 * @author yx
 * @date 2022/12/13
 */
public interface ISingleChooseService extends IService<SingleChoose> {
    IPage<SingleChoose> selectPageByCondition(int currentPage, int pageSize, SingleChoose singleChoose);
}
