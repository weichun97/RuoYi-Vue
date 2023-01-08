package com.ruoyi.web.test.maps;

import com.ruoyi.web.test.entity.param.student.StudentSaveOrUpdateParam;
import com.ruoyi.web.test.entity.po.StudentEntity;
import com.ruoyi.web.test.entity.vo.student.StudentDetailVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMaps {

    StudentEntity saveOrUpdateParamToPo(StudentSaveOrUpdateParam saveOrUpdateParam);

    StudentDetailVO poToDetailVo(StudentEntity studentEntity);
}
