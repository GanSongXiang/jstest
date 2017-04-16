package com.itcast.oa.service;

import com.itcast.oa.base.service.IBaseService;
import com.itcast.oa.domain.Department;

import java.util.List;

public interface IDepartmentService extends IBaseService<Department>{
    List<Department> getAll();
    Department getTopDepartment();
}
