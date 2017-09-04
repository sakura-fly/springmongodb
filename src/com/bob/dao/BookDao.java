package com.bob.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.bob.base.MongoGenDao;
import com.bob.model.Book;



public class BookDao extends MongoGenDao<Book>{
	
	/**
     * 分页查询   对应mongodb操作中的  db.member.find().skip(10).limit(10);
     *         
     * @param member
     *                     查询的条件
     * @param start    
     *                     用户分页查询的起始值
     * @param size
     *                     查询的数据数目
     * 
     * @return
     *                     返回查询到的数据集合
     */
    public List<Book> queryPage(Book member, int start, int size) {
        Query query = new Query();
        return this.getPage(query,(start-1)*size,size);
    }
    
    /**
     * 查询满足分页的记录总数
     *             
     * @param member
     *                     查询的条件
     * @return
     *                     返回满足条件的记录总数
     */
    public Long queryPageCount(Book member){
        Query query = new Query();
        return this.getPageCount(query);
    }
    
    /**
	 * 实现钩子方法,返回反射的类型
	 * 
	 */
	@Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }


}
