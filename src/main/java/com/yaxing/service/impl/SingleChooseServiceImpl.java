package com.yaxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaxing.dao.SingleChooseDao;
import com.yaxing.domain.SingleChoose;
import com.yaxing.service.ISingleChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author yx
 * @date 2022/12/13
 */
@Service
public class SingleChooseServiceImpl extends ServiceImpl<SingleChooseDao, SingleChoose> implements ISingleChooseService {

    @Autowired
    private SingleChooseDao singleChooseDao;

    @Override
    public IPage<SingleChoose> selectPageByCondition(int currentPage, int pageSize, SingleChoose singleChoose) {
        LambdaQueryWrapper<SingleChoose> lqm = new LambdaQueryWrapper<>();
        lqm.like(singleChoose.getTitle() != null, SingleChoose::getTitle, singleChoose.getTitle());
        IPage<SingleChoose> page = new Page<>(currentPage, pageSize);
        return singleChooseDao.selectPage(page, lqm);
    }
}
