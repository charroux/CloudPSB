package myApp;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions; 
import com.google.appengine.api.taskqueue.TaskOptions.Method;


@SuppressWarnings("serial")
public class BackEndServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		System.out.println("Into the  cluster");
		
	}
	
	
}
