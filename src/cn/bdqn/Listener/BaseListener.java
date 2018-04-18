package cn.bdqn.Listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class BaseListener
 *
 */
@WebListener
public class BaseListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public BaseListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent sessionEvent)  { 
         ServletContext context=sessionEvent.getSession().getServletContext();
         Object obj = context.getAttribute("count");
         if(obj==null){
        	 context.setAttribute("count", 1);
         }else{
        	 Integer i = Integer.parseInt(obj.toString());
        	 i++;
        	 context.setAttribute("count", i);
         }
         System.out.println("sessionCreated");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
