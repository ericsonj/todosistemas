package net.ericsonj.save.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import net.ericsonj.save.DBSaveUtil;
import org.hibernate.SessionFactory;

/**
 *
 * @author ejoseph
 */
public class HORMListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {  
        SessionFactory sf = DBSaveUtil.getSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBSaveUtil.closeSessionFactory();
    }

}
