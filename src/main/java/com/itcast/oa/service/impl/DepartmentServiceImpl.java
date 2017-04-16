package com.itcast.oa.service.impl;

import com.itcast.oa.base.service.impl.BaseService;
import com.itcast.oa.dao.IDepartmentDAO;
import com.itcast.oa.domain.Department;
import com.itcast.oa.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门管理
 * @author zhaoqx
 *
 */
@Service
public class DepartmentServiceImpl extends BaseService<Department> implements IDepartmentService {

	private IDepartmentDAO departmentDAO;

	@Autowired
	public void setEntityDAO(IDepartmentDAO departmentDAO){
		this.departmentDAO=departmentDAO;
		super.setDao(departmentDAO);
	}

	public List<Department> getAll() {
		return departmentDAO.getAll();
	}

    public Department getTopDepartment() {
        return departmentDAO.getTopDepartment();
    }
}
