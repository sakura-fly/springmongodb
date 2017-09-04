package com.bob.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.bob.base.MongoGenDao;
import com.bob.model.Member;



public class MemberDao extends MongoGenDao<Member>{
	
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
    public List<Member> queryPage(Member member, Integer start, Integer size) {
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
    public Long queryPageCount(Member member){
        Query query = new Query();
        return this.getPageCount(query);
    }
    
    /**
	 * 实现钩子方法,返回反射的类型
	 * 
	 */
	@Override
    protected Class<Member> getEntityClass() {
        return Member.class;
    }


}
