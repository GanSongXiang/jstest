package com.itcast.oa.base.dao.func.impl;

import com.itcast.oa.base.dao.func.IEntityDAO;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.lang.reflect.ParameterizedType;

/**
 * Created by ichoice on 2017/2/18.
 */
public abstract class EntityDAO<T> extends SqlSessionDaoSupport implements IEntityDAO<T,T>{
    protected Class<T> entityClass;
    protected String className;

    public EntityDAO(){
        entityClass=(Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        className=entityClass.getName();
    }
}
