package com.itcast.oa.service;

import com.itcast.oa.base.service.IBaseService;
import com.itcast.oa.domain.Privilege;
import com.itcast.oa.service.req.F100101Req;

import java.util.List;

/**
 * Created by GanSX on 2017/3/21.
 */
public interface IPrivilegeService extends IBaseService<Privilege>{

    List<Privilege> getTopPrivilege();

    List<Privilege> getPrivilegesByRoleId(Long roleId);

    List<Privilege> getAllPrivilege();

    /**
     * 为某一个角色设置权限
     * @param f100101Req
     */
    void setRolePrivilege(F100101Req f100101Req);
}
