package com.itcast.oa.controller;

import com.itcast.oa.domain.Role;
import com.itcast.oa.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ichoice on 2017/2/18.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Role> getALL(){
        return roleService.getAll();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void deleteDepart(Long id){
        roleService.delete(id);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(Role role){
        roleService.save(role);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public void update(Role role){
        roleService.update(role);
    }
}
