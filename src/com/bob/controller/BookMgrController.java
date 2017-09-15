package com.bob.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bob.util.*;

import net.sf.json.JSONArray;

//import com.bob.dao.BookDao;
import com.bob.model.Book;
import com.bob.model.Member;
import com.bob.model.PageModel;
import com.bob.service.BookService;

import java.io.PrintWriter;

@Controller
@Scope("prototype")
@RequestMapping("/service")
public class BookMgrController {

	// private static int index = 120;
	// @Autowired
	// private BookDao bookDao;
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/bookadd.do", method = RequestMethod.POST)
	public void BookAddMgr(HttpServletRequest request, HttpServletResponse response) {
		int nResult = -1;
		PrintWriter pr = null;
		try {
			pr = response.getWriter();
			String bookName = request.getParameter("bookname");
			System.out.println("bookname=" + bookName);
			String bookType = request.getParameter("booktype");
			String resCount = request.getParameter("rescount");
			String author = request.getParameter("author");
			String publisher = request.getParameter("publisher");
			String publishDate = request.getParameter("publishdt");
			String member = request.getParameter("member");

			Book book = new Book();
			book.setBookName(bookName);
			book.setBookType(bookType);
			book.setResCount(Integer.parseInt(resCount));
			book.setAuthor(author);
			book.setPublisher(publisher);
			book.setPublishDate(publishDate);
			Member m = new Member();
			m.setId("aaa");
			m.setRealName(member);
			book.setMember(m);
			bookService.addBook(book);
			nResult = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pr.print("{\"result\":\"" + nResult + "\"}");
		}

	}

	@RequestMapping(value = "/bookquery.do", method = RequestMethod.POST)
	public void BookQueryMgr(HttpServletRequest request, HttpServletResponse response) {
		// int nResult = -1;
		PrintWriter pr = null;
		try {
			pr = response.getWriter();

			String page = request.getParameter("page");
			if (page == null || page.equals("") || page.equals("0")) {
				page = "1";
			}

			Book book = new Book();
			PageModel<Book> pageBean = bookService.queryBookPager(book, Integer.parseInt(page),
					ConstantsUtil.SYS_PAGE_SIZE);
			System.out.println("返回结果信息=" + JsonUtil.bean2json(pageBean));
			pr.print(JsonUtil.bean2json(pageBean));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	@RequestMapping(value = "/bookupdate.do", method = RequestMethod.POST)
	public void BookUpdateMgr(HttpServletRequest request, HttpServletResponse response) {
		int nResult = -1;
		PrintWriter pr = null;
		try {
			pr = response.getWriter();
			String _id = request.getParameter("_id");
			String bookName = request.getParameter("bookname");
			System.out.println("bookname=" + bookName);
			String bookType = request.getParameter("booktype");
			String resCount = request.getParameter("rescount");
			String author = request.getParameter("author");
			String publisher = request.getParameter("publisher");
			String publishDate = request.getParameter("publishdt");
			String member = request.getParameter("member");

			Book book = new Book();
			book.setId(_id);
			book.setBookName(bookName);
			book.setBookType(bookType);
			book.setResCount(Integer.parseInt(resCount));
			book.setAuthor(author);
			book.setPublisher(publisher);
			book.setPublishDate(publishDate);
			Member m = new Member();
			m.setId("11");
			m.setRealName(member);
			book.setMember(m);
			bookService.updateBook(book);
			nResult = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pr.print("{\"result\":\"" + nResult + "\"}");
		}

	}

	@RequestMapping(value = "/bookdelete.do", method = RequestMethod.POST)
	public void BookDeleteMgr(HttpServletRequest request, HttpServletResponse response) {
		int nResult = -1;
		PrintWriter pr = null;
		try {
			pr = response.getWriter();
			String _id = request.getParameter("_id");
			System.out.println("deleteId=[" + _id + "]");

			Book book = new Book();
			book.setId(_id);
			bookService.deleteBook(book);
			nResult = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pr.print("{\"result\":\"" + nResult + "\"}");
		}
	}

	@RequestMapping(value = "/bookdeletelist.do", method = RequestMethod.POST)
	public void BookDeleteListMgr(PrintWriter pr, String idList) {
		int nResult = -1;
		try {
			JSONArray jsonArray = JSONArray.fromObject(idList);
			bookService.delList(jsonArray);
			nResult = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pr.print("{\"result\":\"" + nResult + "\"}");
		}
	}

}
