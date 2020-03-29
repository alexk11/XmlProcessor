package com.xmlprocessor.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.xmlprocessor.service.api.PrinterInt;
import com.xmlprocessor.service.api.XmlServiceInt;
import com.xmlprocessor.types.AddressType;
import com.xmlprocessor.types.ClientType;
import com.xmlprocessor.types.CombinedType;


public class XmlService implements XmlServiceInt {
	
	/** Logger config */
    //private static final Log LOG = LogFactory.getLog(XmlService.class);
	
	// /////////////////////////////////////////////////////////////////////////
    // Dependency injection (DI) methods
    //
    // /////////////////////////////////////////////////////////////////////////
		
    /** Printer implementation */
    private PrinterInt printer;
    
    /** Marshaller implementation */
    @SuppressWarnings("unused")
	private Marshaller marshaller;

    /** Unmarshaller implementation */
    private Unmarshaller unmarshaller;
    
    /**
     * Sets the printer.
     * 
     * @param printer
     *            The printer implementation.
     * @see #printer
     */
    public void setPrinter(PrinterInt printer) {
        this.printer = printer;
    } 
    
    /**
     * Sets the marshaller.
     * 
     * @param marshaller
     *            The marshaller implementation.
     * @see #marshaller
     */
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    } 

    /**
     * Sets the unmarshaller.
     * 
     * @param unmarshaller
     *            The unmarshaller implementation.
     * @see #unmarshaller
     */
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }  
    
    
    // /////////////////////////////////////////////////////////////////////////
    // Interface methods
    //
    // /////////////////////////////////////////////////////////////////////////
    
	/** {@inheritDoc} */    
    public void validate(List<File> xmlFiles) throws Exception {
       
    	int fileCount = xmlFiles.size();
        File currentFile;

        FileInputStream fileInputStream = null;
        Source xmlFileSource;
        
        CombinedType combinedType;        
        AddressType addressType;

        for (int currentFileCount = 0; currentFileCount < fileCount; currentFileCount++) {
        	currentFile = xmlFiles.get(currentFileCount);
        	printer.boldln("\nCurrent file: ").println(currentFile.getPath());
	        try {
	            fileInputStream = new FileInputStream(currentFile);
	            xmlFileSource = new StreamSource(fileInputStream);
	            combinedType = (CombinedType) unmarshaller.unmarshal(xmlFileSource);
	            printer.bold("\nXml file [" + currentFile.getName()  + "] validation success!\n");	            
	            printer.traceln("Version: ").println(combinedType.getVersion());	            
	            addressType = combinedType.getAddress();
	            if (addressType != null) {
	            	printer.warnln("Address: ").println(addressType.toString());
	            } else if (combinedType.getClients() != null) {
	            	int i=0;
	            	for (ClientType client : combinedType.getClients()) {
	            		printer.bold("\nClient").println("[" + ++i + "]" + client.toString());
	            	}
	            }
	        }
	        catch(Exception e) {
	        	printer.fatalln("\nXml file [" + currentFile.getName()  + "] validation error: \n" + e.getMessage());
	        } finally {
	            if (fileInputStream != null) {
	                fileInputStream.close();
	            } 
	        } 
        }      
        printer.trace("Validating completed.");
    }
    
    
    /** {@inheritDoc} */    
    public int countElements(List<File> xmlFiles, String elementName) throws Exception {
    	
    	printer.bold("\n\nIn countElements. Searching for element [" + elementName + "]");

        int fileCount = xmlFiles.size(), result = 0;
        File currentFile;
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	InputSource is = null;
    	Document doc = null;
    	NodeList nodeList = null;
        
        for (int currentFileCount = 0; currentFileCount < fileCount; currentFileCount++) {
        	currentFile = xmlFiles.get(currentFileCount);
        	printer.bold("\nCurrent file: ").println(currentFile.getPath());
	        try {
	        	String content = FileUtils.readFileToString(currentFile, Charset.forName("utf-8"));
	        	is = new InputSource(new StringReader(content));
	        	doc = dBuilder.parse(is);	
	            doc.getDocumentElement().normalize();
	            
	            nodeList = doc.getElementsByTagName(elementName);	            
	            if (nodeList != null && nodeList.getLength() > 0) {
	            	for (int i=0; i<nodeList.getLength(); i++) {
	            		printer.printf("\nValue of element %s [%d] is [%s]", elementName, i, nodeList.item(i).getTextContent());
	            	}
	            	printer.boldln("\n\nFound [" + nodeList.getLength() + "] elements in current file.");
	            	result += nodeList.getLength();
				}
	        } finally {
	        	// TODO: post processing
	        }        
        }        
        printer.boldln("\ncountElements completed. Found total [" + result + "] elements.");
        return result;
    }
    
}
