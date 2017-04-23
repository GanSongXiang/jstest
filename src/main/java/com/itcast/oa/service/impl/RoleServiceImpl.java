package com.itcast.oa.service.impl;

import com.itcast.oa.base.service.impl.BaseService;
import com.itcast.oa.dao.IRoleDAO;
import com.itcast.oa.domain.Privilege;
import com.itcast.oa.domain.Role;
import com.itcast.oa.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 岗位管理
 * @author zhaoqx
 *
 */
@Service
public class RoleServiceImpl extends BaseService<Role> implements IRoleService {
	private IRoleDAO roleDAO;

	@Autowired
	public void setEntityDAO(IRoleDAO roleDAO){
		this.roleDAO=roleDAO;
		super.setDao(roleDAO);
	}

	public List<Role> getAll() {
		return roleDAO.getAll();
	}

	@Override
	public void save(Role role) {
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());
		super.save(role);
	}

	@Override
	public void update(Role role) {
		role.setUpdateTime(new Date());
		super.update(role);
	}
}
