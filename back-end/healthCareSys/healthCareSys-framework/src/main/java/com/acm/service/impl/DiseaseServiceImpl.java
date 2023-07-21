package com.acm.service.impl;

import com.acm.entity.Disease;
import com.acm.mapper.DiseaseMapper;
import com.acm.service.DiseaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Disease)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("diseaseService")
public class DiseaseServiceImpl extends ServiceImpl<DiseaseMapper, Disease> implements DiseaseService {

}
