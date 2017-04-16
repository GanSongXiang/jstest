package com.itcast.oa.dao;

import com.itcast.oa.base.dao.func.IEntityDAO;
import com.itcast.oa.domain.Role;

import java.util.List;

public interface IRoleDAO extends IEntityDAO<Role, Role> {
     List<Role> getAll();
}