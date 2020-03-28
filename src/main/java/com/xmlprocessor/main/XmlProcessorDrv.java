package com.xmlprocessor.main;

import java.io.File;
import java.util.List;

import org.fusesource.jansi.Ansi.Attribute;

import com.xmlprocessor.config.Compositor;
import com.xmlprocessor.service.api.PrinterInt;
import com.xmlprocessor.service.api.XmlServiceInt;
import com.xmlprocessor.util.CommandLineArgs;

/**
 * Program entry point. 
 */
public class XmlProcessorDrv {
	       
    /** Name of the program */
    private static final String PROG_NAME = XmlProcessorDrv.class.getSimpleName();
    /** Version of the Program */
    private static final String PROG_VERSION = "1.0 (XmlProcessor v1.000)";
    /** Exit Status {@value} for OK. */
    private static final int EXIT_STATUS_OK = 0;
    /** Exit Status {@value} for not OK. */
    private static final int EXIT_STATUS_NOT_OK = -1;    
	
	/**
     * Main entry point. Evaluates command line args and validates provided xml files 
     * 
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {     	
    	
        // execution status
    	int exitStatus;   
    	
        // get printer object
        PrinterInt printer = Compositor.getPrinter();
        
        // read command line args
        CommandLineArgs cmdLineArgs = new CommandLineArgs(args);   

        // Show version
        if (cmdLineArgs.hasOption(CommandLineArgs.CLI_OPTION_VERSION)) {
            printer.printf("%s v%s\n", PROG_NAME, PROG_VERSION);
        }
        // Show help
        if (cmdLineArgs.hasOption(CommandLineArgs.CLI_OPTION_HELP)) {            
            cmdLineArgs.printHelp(PROG_NAME);            
        }       
        // Check if the directory name is passed in args 
        if (!cmdLineArgs.hasOption(CommandLineArgs.CLI_OPTION_DIRECTORY)) {            
            cmdLineArgs.printHelp(PROG_NAME);
            return;
        } else {        
	        String dir = cmdLineArgs.getOptionValue(CommandLineArgs.CLI_OPTION_DIRECTORY); 
	        //printer.bold("\nFolder with XML files: ").println(dir);
            printer.printf("\n%s %s","Folder with XML files: ", dir);    
	        List<File> xmlFiles;
	        XmlServiceInt xmlService = Compositor.getXmlService();	       
	        try {
	        	// Validating
	            xmlFiles = Compositor.getFileReader().readFiles(dir);	            
	            printer.bold("\n\nStart validating XML files:\n");     
	            xmlService.validate(xmlFiles);
	            // Counting number of requested elements
	            if (cmdLineArgs.hasOption(CommandLineArgs.CLI_OPTION_ELEM_COUNT)) {
		        	String elementName = cmdLineArgs.getOptionValue(CommandLineArgs.CLI_OPTION_ELEM_COUNT);
		        	printer.bold("\nStart counting elements in XML file(s):");
		        	xmlService.countElements(xmlFiles, elementName);
	            }
	            exitStatus = EXIT_STATUS_OK;
	        } catch (Exception ex) {
	            printer.errorln("\n" + ex.getMessage());
	            exitStatus = EXIT_STATUS_NOT_OK;
	        }  
        }

        System.exit(exitStatus);
    } 

}