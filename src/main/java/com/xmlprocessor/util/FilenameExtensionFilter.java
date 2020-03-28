package com.xmlprocessor.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

/**
 * An implementation of {@code FilenameFilter} that filters using a specified set of extensions. The extension for a
 * file is the portion of the file name after the last ".". Files whose name does not contain a "." have no file name
 * extension. File name extension comparisons are case insensitive.
 *  
 * @see java.io.FilenameFilter
 */
public final class FilenameExtensionFilter implements FilenameFilter {

    /** Known extensions. */
    private final List<String> extensions;

    /**
     * Creates a {@code FileNameExtensionFilter} with the specified description and file name extensions. The returned
     * {@code FileNameExtensionFilter} will accept all directories and any file with a file name extension contained in
     * {@code extensions}.
     * 
     * @param extensions
     *            the accepted file name extensions
     * @throws IllegalArgumentException
     *             if extensions is {@code null}, empty, contains {@code null}, or contains an empty string
     * @see #accept
     */
    public FilenameExtensionFilter(List<String> extensions) {
        if (extensions == null || extensions.isEmpty()) {
            throw new IllegalArgumentException("Extensions must be non-null and not empty");
        } 
        this.extensions = extensions;      
    } 
    

    /**
     * Tests the specified file, returning true if the file is accepted, false otherwise. True is returned if the
     * extension matches one of the file name extensions of this {@code FileFilter}.
     * 
     * @param dir
     *            the directory in which the file was found.
     * @param name
     *            the name of the file.
     * @return true if and only if the name should be included in the file list, false otherwise.
     */
    public boolean accept(File dir, String name) {
        boolean accept = false;

        if (name != null) {
            StringBuffer extensionBuffer;
            for (String currentExtension : extensions) {
                extensionBuffer = new StringBuffer(".").append(currentExtension);
                if (name.endsWith(extensionBuffer.toString())) {
                    accept = true;
                    break;
                } 
            } 
        } 
        return accept;
    } 

} 
