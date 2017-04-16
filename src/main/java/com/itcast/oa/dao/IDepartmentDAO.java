package com.itcast.oa.dao;

import com.itcast.oa.base.dao.func.IEntityDAO;
import com.itcast.oa.domain.Department;

import java.util.List;

public interface IDepartmentDAO extends IEntityDAO<Department, Department> {
    List<Department> getAll();
    Department getTopDepartment();
}