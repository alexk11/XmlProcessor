package com.xmlprocessor.service.api;

import java.io.File;
import java.util.List;

/**
 * The interface XmlServiceInt
 */
public interface XmlServiceInt {

    /**
     * Validates the XML files against provided XSD
     */
    void validate(List<File> xmlFiles) throws Exception;
    
    /**
     * Counts number of entries of requested element in incoming XML 
     */
    int countElements(List<File> xmlFiles, String elementName) throws Exception;

} // XmlServiceInt
