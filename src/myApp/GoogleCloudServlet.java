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
public class GoogleCloudServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String name = req.getParameter("name");
		String a = req.getParameter("age");
		int age = Integer.parseInt(a);
		
		System.out.println("name=" + name + ", age=" + age);
		
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		
		Entity person = new Entity("Person");
		person.setProperty("name", name);
		person.setProperty("age", age);
		
		dataStore.put(person);
		
		Queue queue = QueueFactory.getDefaultQueue();
		queue.add(TaskOptions.Builder.withUrl("/backend").method(Method.GET)); 

		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
