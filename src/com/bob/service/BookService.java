package com.bob.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.bob.dao.BookDao;
import com.bob.model.Book;
import com.bob.model.Member;
import com.bob.model.PageModel;


public class BookService {
	@Autowired
	private BookDao bookDao;
	
	
	
	
	public void addBook(Book book) {
		bookDao.save(book);
	}
	
	public void updateBook(Book book) {
		Query query = Query.query(   Criteria.where("_id").is( new ObjectId(book.getId())) );
		Update up = new Update();
		up.set("BookName",book.getBookName());
		up.set("BookType",book.getBookType());
		up.set("ResCount",book.getResCount());
		up.set("Author",book.getAuthor());
		up.set("Publisher",book.getPublisher());
		up.set("PublishDate",book.getPublishDate());
		bookDao.updateFirst(query , up);
	}
	
	public void deleteBook(Book book) {
		bookDao.deleteById(book.getId());
	}
	public PageModel<Book>  queryBookPager(Book book , int pageNo , int pageSize) {
			PageModel<Book> page = new PageModel<Book>();
			try {
		            List<Book> list = this.bookDao.queryPage(book, pageNo, pageSize);
		            Long recordTotal = this.bookDao.queryPageCount(book);
		            //System.out.println("List=" + list.toString() + "  recordTotal=[" + recordTotal + "]");
		            page.setPageNo(pageNo);
		            page.setPageSize(pageSize);
		            page.setData(list);
		            page.setRecordTotal(recordTotal);
		            page.setnResult(1);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }finally{
		        }
			return page;
	}
	
	public void delList(List<String> id){
		bookDao.deleteList(id);
	}
}
