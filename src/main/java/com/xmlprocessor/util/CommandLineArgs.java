package com.xmlprocessor.util;

import org.apache.commons.cli.AlreadySelectedException;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;

/**
 * Parsing cmd args
 */
public class CommandLineArgs {
 
    /** Options */
    private Options options;

    /** List of cmd args */
    private CommandLine cmdLine;
    /**  */
    private boolean missingOption;
    /**  */
    private boolean missingArgument;
    /**  */
    private boolean unrecognizedOption;    
    
    // Constants    
    
    /** Option <code>Folder</code>. */
    public static final String CLI_OPTION_DIRECTORY = "d";    

    /** Option <code>Help</code>. */
    public static final String CLI_OPTION_HELP = "h";
    
    /** Option <code>Version</code>. */
    public static final String CLI_OPTION_VERSION = "v";
    
    /** Option <code>Entry count</code>. */
    public static final String CLI_OPTION_ELEM_COUNT = "elementCount";
    
    /**Number of chars per line */
    private static final int CHARS_PER_LINE = 90;

    /**
     * Constructor.
     * 
     * @param args
     *            Command line args.
     * @see #options
     */
    public CommandLineArgs(String[] args) {
        super();
        options = buildOptions();     
        try {
            CommandLineParser cmdLineParser = new DefaultParser();
            cmdLine = cmdLineParser.parse(options, args);
        } catch (MissingOptionException moEx) {
            missingOption = true;
        } catch (MissingArgumentException maEx) {
            missingArgument = true;
        } catch (UnrecognizedOptionException uoEx) {
            unrecognizedOption = true;
        } catch (AlreadySelectedException asEx) {
        	
        } catch (ParseException pEx) {
        	
        } 
    } 
        
    public boolean isMissingOption() {
        return missingOption;
    } 
    
    public boolean isMissingArgument() {
        return missingArgument;
    } 

    public boolean isUnrecognizedOption() {
        return unrecognizedOption;
    } 

    public boolean hasOption(String opt) {
        boolean hasOption;
        if (cmdLine == null) {
            hasOption = false;
        } else {
            hasOption = cmdLine.hasOption(opt);
        }
        return hasOption;
    } 

    /**
     * Gets the value of the option.
     * 
     * @param opt
     *            Name of the option.
     * @return Value of the option.
     */
    public String getOptionValue(String opt) {
        String optionValue = null;
        if (cmdLine != null) {
            optionValue = cmdLine.getOptionValue(opt);            
        } 
        return optionValue;
    } 

    /**
     * Displays help.
     * 
     * @param cmdLineSyntax
     *            The Syntax for the program.
     * @see #options
     */
    public void printHelp(String cmdLineSyntax) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(CHARS_PER_LINE, cmdLineSyntax, null, options, null, true);
    } 

    /**
     * Available command line options.
     * 
     * @return Options.
     * @see #options
     */
    private static Options buildOptions() {
        Options options = new Options();
    
        Option cliOptionDir = new Option(CLI_OPTION_DIRECTORY, true, "Folder with XML files");
        cliOptionDir.setArgName("Dir");
        options.addOption(cliOptionDir);

        Option cliOptionVersion = new Option(CLI_OPTION_VERSION, "Version of the program");
        options.addOption(cliOptionVersion);

        Option cliOptionHelp = new Option(CLI_OPTION_HELP, "help", false, "Display help");
        options.addOption(cliOptionHelp);
        
        Option cliOptionEntryCount = new Option(CLI_OPTION_ELEM_COUNT, true, "Counts the number of elements in XML by node name");
        options.addOption(cliOptionEntryCount);      

        return options;
    } 

} // CommandLineArgs
