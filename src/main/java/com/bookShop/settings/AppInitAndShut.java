package com.bookShop.settings;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Hakim
 */
public class AppInitAndShut implements ServletContextListener{
    private final Logger logger=LoggerFactory.getLogger(AppInitAndShut.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.warn("### App launched at - Date : "+new Date().toString());
        System.out.println(sce.getServletContext().getVirtualServerName()+"is connected");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.warn("### App shut down.Date : "+new Date().toString());
    }
    
}
