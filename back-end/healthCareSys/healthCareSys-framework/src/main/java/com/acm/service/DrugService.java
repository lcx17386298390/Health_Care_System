package com.acm.service;

import com.acm.entity.Drug;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * (Drug)表服务接口
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
public interface DrugService extends IService<Drug> {

    ResponseResult druglist(Integer pageNum, Integer pageSize);
}
