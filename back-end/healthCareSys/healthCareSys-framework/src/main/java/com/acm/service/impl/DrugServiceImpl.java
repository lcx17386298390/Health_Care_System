package com.acm.service.impl;

import com.acm.entity.Disease;
import com.acm.entity.Drug;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.mapper.DrugMapper;
import com.acm.service.DrugService;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DrugMapper drugMapper;
    @Override
    public ResponseResult druglist(Integer pageNum, Integer pageSize) {
        Page<Drug> page = new Page(pageNum, pageSize);
        page(page);
        List<Drug> drugs = page.getRecords();
        return ResponseResult.okResult(drugs);
    }

//    根据用途查询药品,价格升序
    @Override
    public ResponseResult getByAscUsageDrugs(Integer pageNum,Integer pageSize,String drugUsage) {
        LambdaQueryWrapper<Drug> queryWrapper = new LambdaQueryWrapper<>();
        Page<Drug> page = new Page(pageNum, pageSize);
        queryWrapper.eq(Drug::getDrugUsage,drugUsage).orderByAsc(Drug::getDrugPrice);
        drugMapper.selectPage(page, queryWrapper);

        List<Drug> matchedDrugs =  page.getRecords();


        if (matchedDrugs.isEmpty()) {
            return ResponseResult.errorResult(AppHttpCodeEnum.valueOf("未找到符合该药品用途的药品"));
        } else {
            return ResponseResult.okResult(matchedDrugs);
        }
    }
//    根据用途查询药品,价格降序

    @Override
    public ResponseResult getByDescUsageDrugs(Integer pageNum, Integer pageSize, String drugUsage) {
        LambdaQueryWrapper<Drug> queryWrapper=new LambdaQueryWrapper<>();
        Page<Drug> page=new Page<>(pageNum,pageSize);
        queryWrapper.eq(Drug::getDrugName,drugUsage).orderByDesc(Drug::getDrugPrice);
        drugMapper.selectPage(page,queryWrapper);
        List<Drug> matchedDrugs = page.getRecords();
        if (matchedDrugs.isEmpty()){
            return ResponseResult.errorResult(AppHttpCodeEnum.valueOf("未找到符合改用途的药品"));
        }else {
            return ResponseResult.okResult(matchedDrugs);
        }

    }
}
