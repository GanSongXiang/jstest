package com.itcast.oa.ao;

/**
 * Created by ichoice on 2017/2/25.
 */
public interface ISysAO {
    /**
     * 用户登录
     * @param loginName
     * @param loginPwd
     */
    public Long doSysUserLogin(String loginName, String loginPwd);
}
