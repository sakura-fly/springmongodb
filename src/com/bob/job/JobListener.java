package com.bob.job;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JobListener implements ServletContextListener{
	 public void contextInitialized(ServletContextEvent arg0) {
		 
	 }
	 
	 public void contextDestroyed(ServletContextEvent arg0) {
		 System.out.println("-------------线程任务结束了----------");

	 }
	 
}
