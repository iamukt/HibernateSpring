package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;

/**
 * Application Lifecycle Listener implementation class HibSFCtxListeners
 *
 */
//@WebListener
public class HibSFCtxListener implements ServletContextListener {

    

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  {
    	System.out.println("ctx destroyed");
         HibernateUtils.getSf().close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         //create singleton , immutable inst of SF
    	System.out.println("ctx inited");
    	HibernateUtils.getSf();
    }
	
}
