package com.itcast.oa.base.session;

/**
 * 真正的会话提供者 
 */
public interface SessionProvider {
    
	String SESSION_KEY_USER = "user";
    
    String SESSION_KEY_OSS_USER = "ossUser";
    
    String SESSION_KEY_OSS_MENU = "ossMenu";
    

    /**
     * 存放登录用户信息
     * 
     * @param userDetail 
     */
    public void setUserDetail(UserDetail userDetail);
    
    /**
     * 存放oss登录用户信息
     * 
     * @param ossUserDetail 
     */
    public void setOssUserDetail(UserDetail ossUserDetail);
    
    /**
     * 存放oss用户缓存的菜单信息
     * 
     * @param ossMenuDetail 
     */
    public void setOssMenuDetail(MenuDetail ossMenuDetail);
    
    /**
     * 移除用户信息
     *
     */
    public void removeUserDetail();
    
    /**
     * 移除用户信息通过API token
     *
     * @history:
     */
    public void removeUserDetailByToken(String token);

    /**
     * 获取用户对象
     * @return  
     */
    public UserDetail getUserDetail();
    
    /**
     * 获取oss用户对象
     * @return 
     * @create: 2016-8-5 cjw
     * @history:
     */
    public UserDetail getOssUserDetail();
    
    /**
     * 获取oss用户缓存的菜单对象
     * @return 
     * @create: 2016-8-10 cjw
     * @history:
     */
    public MenuDetail getOssMenuDetail();
    
    /**
     * 存放值
     * 
     * @param name
     * @param value 
     */
    public void setAttribute(String name, Object value);

    /**
     * 获取key为name的值
     *
     * @param name 
     */
    public Object getAttribute(String name);

    /**
     * 移除某个值
     * 
     * @param name 
     */
    public void removeAttribute(String name);

}
