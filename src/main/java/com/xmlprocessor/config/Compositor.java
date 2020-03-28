package com.xmlprocessor.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xmlprocessor.service.api.FileReaderInt;
import com.xmlprocessor.service.api.PrinterInt;
import com.xmlprocessor.service.api.XmlServiceInt;


/**
 * Initializes the Spring Application Context that provides required beans 
 */
public final class Compositor {

        
    /** Path to Spring config file. */
    private static final String SPRING_CONFIG = "spring-config.xml";
    //private static final String SPRING_CONFIG = "/config/spring-config.xml";

    /** Spring Application Context. */
    private static ApplicationContext ctx = initAppContext();

    /**
     * Initializes the Spring Application Context.
     * 
     * @return initialized Spring Application Context.
     */
    private static ApplicationContext initAppContext() {
        synchronized (Compositor.class) {
            ApplicationContext appContext;           
            appContext = new ClassPathXmlApplicationContext(SPRING_CONFIG);
            return appContext;
        } 
    } 

    /**
     *  Constructor.
     */
    private Compositor() {
        super();
    } 

    /**
     * 
     * @return
     */
    public static FileReaderInt getFileReader() {
        return (FileReaderInt) ctx.getBean("fileReader");
    } 

   /**
    * 
    * @return
    */
    public static XmlServiceInt getXmlService() {
        return (XmlServiceInt) ctx.getBean("xmlService");
    } 

    /**
     * 
     * @return
     */
    public static PrinterInt getPrinter() {
        return (PrinterInt) ctx.getBean("printer");
    } 

} 
