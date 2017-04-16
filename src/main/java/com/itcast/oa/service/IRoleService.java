package com.itcast.oa.service;

import com.itcast.oa.base.service.IBaseService;
import com.itcast.oa.domain.Role;

import java.util.List;

public interface IRoleService extends IBaseService<Role>{
    List<Role> getAll();
}
