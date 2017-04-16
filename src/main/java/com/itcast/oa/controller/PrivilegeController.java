package com.itcast.oa.controller;

import com.itcast.oa.base.controller.BaseController;
import com.itcast.oa.domain.Privilege;
import com.itcast.oa.service.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by GanSX on 2017/3/21.
 */
@Controller
@RequestMapping("/Privilege")
public class PrivilegeController extends BaseController{
    @Autowired
    private IPrivilegeService privilegeService;

    @RequestMapping("/getTopPrivilege")
    @ResponseBody
    public List<Privilege> getTopPrivilege(){
        List<Privilege> privileges=privilegeService.getTopPrivilege();
        return privileges;
    }


}
