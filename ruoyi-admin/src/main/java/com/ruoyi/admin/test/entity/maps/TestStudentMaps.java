package com.ruoyi.admin.test.entity.maps;

import com.ruoyi.admin.test.entity.param.teststudent.TestStudentSaveOrUpdateParam;
import com.ruoyi.admin.test.entity.po.TestStudentEntity;
import com.ruoyi.admin.test.entity.vo.teststudent.TestStudentDetailVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestStudentMaps {

    TestStudentEntity saveOrUpdateParamToPo(TestStudentSaveOrUpdateParam saveOrUpdateParam);

    TestStudentDetailVO poToDetailVo(TestStudentEntity testStudentEntity);
}
