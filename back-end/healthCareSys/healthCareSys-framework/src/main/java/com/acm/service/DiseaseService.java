package com.acm.service;

import com.acm.entity.Disease;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.Data;


/**
 * (Disease)表服务接口
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
public interface DiseaseService extends IService<Disease> {

    ResponseResult diseaseInfo(Integer pageNo, Integer pageSize, String patientId);

    //ResponseResult adddisease(String pid, String diseasename, Data data, String did);

    ResponseResult diseaserevise(String pidId, String diseaseName);
}
