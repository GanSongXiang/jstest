package com.itcast.oa.controller;

import com.itcast.oa.base.exception.BizServiceException;
import com.itcast.oa.base.util.MD5Utils;
import com.itcast.oa.domain.User;
import com.itcast.oa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ichoice on 2017/2/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

//    @RequestMapping("/showUser")
//    public String toIndex(HttpServletRequest request, Model model){
//        int userId = Integer.parseInt(request.getParameter("id"));
//        //User user = this.userService.getUserById(userId);
//        model.addAttribute("user", user);
//        System.out.print(user.toString());
//        return "showUser";
//    }

    @RequestMapping("/getAll")
    @ResponseBody
    private List<User> getAll(){
        return  userService.getAll();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void deleteDepart(Long id){
        userService.delete(id);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(User user){
        userService.save(user);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public  void edit(User user){
        if(null == user.getId()){
          throw new BizServiceException("123","用户编号不能为空");
        }
    }

    /**
     * 初始化密码
     */
    @RequestMapping("/initialPassword")
    @ResponseBody
    public String intiPassword(Long userId){
        //先查询
        User user = userService.getById(userId);
        user.setPassword(MD5Utils.md5("1234"));//设置密码为1234

        userService.update(user);
        return "toList";
    }

    /**
     * 查询当前登录名是否存在
     * @return
     */
    @RequestMapping("/findByLoginName")
    @ResponseBody
    public Integer findByLoginName(String loginName){
        int count = userService.getByLoginName(loginName);
        return count;
    }
}
