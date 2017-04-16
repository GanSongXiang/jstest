package com.itcast.oa.service.impl;

import com.itcast.oa.base.service.impl.BaseService;
import com.itcast.oa.dao.IBookDAO;
import com.itcast.oa.domain.Book;
import com.itcast.oa.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends BaseService<Book> implements IBookService {
	
	private IBookDAO bookDAO;

	@Autowired
	public void setEntityDAO(IBookDAO bookDAO){
		this.bookDAO=bookDAO;
		super.setDao(bookDAO);
	}

}
