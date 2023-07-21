package com.acm.service.impl;

import com.acm.entity.Drug;
import com.acm.mapper.DrugMapper;
import com.acm.service.DrugService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Drug)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("drugService")
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements DrugService {

}
