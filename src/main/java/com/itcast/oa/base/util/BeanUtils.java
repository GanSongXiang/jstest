package com.itcast.oa.base.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by ichoice on 2017/2/18.
 */
public class BeanUtils implements BeanFactoryAware {
    // Spring的bean工厂
    private static BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory factory) throws BeansException {
        beanFactory=factory;
    }

    public static<T> T getBean(String beanName){
        return (T) beanFactory.getBean(beanName);
    }
}
