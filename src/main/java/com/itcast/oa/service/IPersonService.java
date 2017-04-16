package com.itcast.oa.service;

import com.itcast.oa.base.service.IBaseService;
import com.itcast.oa.domain.Person;

import javax.xml.ws.ServiceMode;

/**
 * Created by ichoice on 2017/2/18.
 */
@ServiceMode
public interface IPersonService extends IBaseService<Person> {

}
