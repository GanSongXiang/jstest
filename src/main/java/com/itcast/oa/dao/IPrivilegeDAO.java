package com.itcast.oa.dao;

import com.itcast.oa.base.dao.func.IEntityDAO;
import com.itcast.oa.domain.Privilege;

import java.util.List;

public interface IPrivilegeDAO extends IEntityDAO<Privilege, Privilege> {
    List<Privilege> getTopPrivilege();

    List<Privilege> getPrivilegesByRoleId(Long roleId);

    List<Privilege> getAll();
}