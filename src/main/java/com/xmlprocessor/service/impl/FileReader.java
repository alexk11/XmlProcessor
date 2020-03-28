package com.xmlprocessor.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

import com.xmlprocessor.service.api.FileReaderInt;

/**
 * Reads xml files from the folder and applies the <code>FilenameFilter</code> on them.
 * 
 * @see java.io.FilenameFilter
 */
public class FileReader implements FileReaderInt {	
    
    private FilenameFilter filenameFilter;

    public void setFilenameFilter(FilenameFilter filenameFilter) {
        this.filenameFilter = filenameFilter;
    } 
    
    /** {@inheritDoc} */  
    public List<File> readFiles(String directory) throws FileNotFoundException {
        File dir = new File(directory);
    
        if (!dir.exists()) {
            throw new FileNotFoundException("Folder [" + dir.getAbsolutePath() + "] not found!");
        } 

        File[] files = dir.listFiles(filenameFilter);
        if (files.length == 0) {
            throw new FileNotFoundException("Folder [" + dir.getAbsolutePath()
                    + "] does NOT contains valid files");
        } 
        return Arrays.asList(files);
    } 

} // FileReader

