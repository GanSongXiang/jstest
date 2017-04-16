 
package com.itcast.oa.base.session;

public class SessionUser extends UserDetail {
    private Long user_id;
    
    private String app_id;
    
    public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    
}
