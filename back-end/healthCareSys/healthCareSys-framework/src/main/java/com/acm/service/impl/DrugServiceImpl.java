package com.acm.service.impl;

import com.acm.entity.Drug;
import com.acm.mapper.DrugMapper;
import com.acm.service.DrugService;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Drug)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("drugService")
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements DrugService {
    /**
     * 药品列表展示
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ResponseResult druglist(Integer pageNum, Integer pageSize) {
        Page<Drug> page = new Page(pageNum, pageSize);
        page(page);
        List<Drug> drugs = page.getRecords();
        return ResponseResult.okResult(drugs);
    }
}
