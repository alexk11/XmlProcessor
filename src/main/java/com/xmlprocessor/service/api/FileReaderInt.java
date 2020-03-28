package com.xmlprocessor.service.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Class that implements the interface FileReaderInt reads files from the provided folder
 */
public interface FileReaderInt {

    /**
     * Reads files from the directory.
     * 
     * @param directory
     *            The folder with files            
     * @return List of files from the folder
     * @throws FileNotFoundException
     *             If the folder does not exist or does not contain any valid files             
     */
    List<File> readFiles(String directory) throws FileNotFoundException;

} // FileReaderInt
