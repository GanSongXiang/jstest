package com.itcast.oa.base.service;

/**
 * Created by ichoice on 2017/2/18.
 */
public interface IBaseService<T> {
    T getById(long id);

    void save(T t);

    public void delete(Long id);

    public void update(T t);
}
