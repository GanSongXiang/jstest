package com.itcast.oa.service.impl;

import com.itcast.oa.base.dao.func.IEntityDAO;
import com.itcast.oa.base.service.impl.BaseService;
import com.itcast.oa.dao.IPersonDAO;
import com.itcast.oa.domain.Person;
import com.itcast.oa.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ichoice on 2017/2/18.
 */
@Service
public class PersonService extends BaseService<Person> implements IPersonService {

    private IPersonDAO personDAO;

    @Autowired
    public void setEntityDAO(IPersonDAO personDAO) {
        this.personDAO =  personDAO;
        super.setDao(personDAO);
    }
}
