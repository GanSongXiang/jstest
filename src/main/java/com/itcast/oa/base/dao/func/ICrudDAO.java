package com.itcast.oa.base.dao.func;

import java.io.Serializable;

/**
 * Created by ichoice on 2017/2/18.
 */
public interface ICrudDAO <T>{
    public abstract T getById(Serializable paramSerializable);

    public abstract void save(T paramT);

    public abstract void update(T paramT);

    public abstract void deleteById(Serializable paramSerializable);
}
