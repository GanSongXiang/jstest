package com.itcast.oa.base.dao.func;

import java.util.List;

/**
 * Created by ichoice on 2017/2/18.
 */
public interface IQueryDAO<T,P> {
    public abstract List<T> queryWithPage(P paramP);
}
