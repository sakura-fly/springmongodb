package com.bob.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="book")
public class Book {
	
	//@Id
	@Field("_id")
	private String Id;
	@Field("BookName")
	private String bookName;
	@Field("BookType")
	private String bookType;
	@Field("ResCount")
	private int resCount;
	@Field("Author")
	private String author;
	@Field("Publisher")
	private String publisher;
	@Field("PublishDate")
	private String publishDate;
	//@DBRef
	@Field("Member")
	private Member member;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public int getResCount() {
		return resCount;
	}
	public void setResCount(int resCount) {
		this.resCount = resCount;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	
	

	
	
}	
