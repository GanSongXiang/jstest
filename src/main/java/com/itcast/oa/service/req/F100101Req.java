package com.itcast.oa.service.req;

import java.util.List;

/**
 * Created by GanSX on 2017/3/22.
 */
public class F100101Req {
    private Long roleId;
    private List<Long> privilegeIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(List<Long> privilegeIds) {
        this.privilegeIds = privilegeIds;
    }
}
