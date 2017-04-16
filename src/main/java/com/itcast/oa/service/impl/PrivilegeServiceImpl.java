package com.itcast.oa.service.impl;

import com.itcast.oa.base.service.impl.BaseService;
import com.itcast.oa.dao.IPrivilegeDAO;
import com.itcast.oa.dao.IRolePrivilegeDAO;
import com.itcast.oa.domain.Privilege;
import com.itcast.oa.domain.Role;
import com.itcast.oa.domain.RolePrivilege;
import com.itcast.oa.service.IPrivilegeService;
import com.itcast.oa.service.req.F100101Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GanSX on 2017/3/21.
 */
@Service
public class PrivilegeServiceImpl extends BaseService<Privilege> implements IPrivilegeService {
    private IPrivilegeDAO privilegeDAO;

    private IRolePrivilegeDAO rolePrivilegeDAO;

    @Autowired
    public void setEntityDAO(IPrivilegeDAO privilegeDAO) {
       this.privilegeDAO=privilegeDAO;
       super.setDao(privilegeDAO);
    }


    public List<Privilege> getTopPrivilege() {
        return privilegeDAO.getTopPrivilege();
    }

    public List<Privilege> getPrivilegesByRoleId(Long roleId) {
        return privilegeDAO.getPrivilegesByRoleId(roleId);
    }

    public List<Privilege> getAllPrivilege() {
        return privilegeDAO.getAll();
    }

    public void setRolePrivilege(F100101Req f100101Req) {
        for (int i=0;i<f100101Req.getPrivilegeIds().size();i++){
            RolePrivilege rolePrivilege= new RolePrivilege();
            rolePrivilege.setRoleId(f100101Req.getRoleId());
            rolePrivilege.setPrivilegeId(f100101Req.getRoleId());
            rolePrivilegeDAO.save(rolePrivilege);
        }
    }
}
