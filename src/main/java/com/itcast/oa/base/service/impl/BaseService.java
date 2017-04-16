package com.itcast.oa.base.service.impl;

import com.itcast.oa.base.dao.func.IEntityDAO;
import com.itcast.oa.base.service.IBaseService;

/**
 * Created by ichoice on 2017/2/18.
 */
public abstract class BaseService<T> implements IBaseService<T> {

    protected IEntityDAO<T,T> dao;

    public void setDao(IEntityDAO<T, T> baseDao) {
        this.dao = baseDao;
    }

    public T getById(long id) {
        return dao.getById(id);
    }

    public void save(T t) {
       dao.save(t);
    }

    public void delete(Long id) {
       dao.deleteById(id);
    }

    public void update(T t) {
       dao.update(t);
    }
}
