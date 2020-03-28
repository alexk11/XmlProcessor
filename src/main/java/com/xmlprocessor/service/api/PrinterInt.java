package com.xmlprocessor.service.api;

/**
 * Class that implements the interface PrinterInt generates char sequences with respect to the severity. 
 */
public interface PrinterInt {

    // *** normal *** //

    /**      
     * Returns the CharSequence
     * 
     * @param seq
     *            The CharSequence to be printed out
     * @return A reference to the Printer.
     */
    PrinterInt print(final CharSequence seq);

    /**      
     * Returns the CharSequence with the line break. 
     * 
     * @param seq
     *           The CharSequence 
     * @return A reference to the Printer
     */
    PrinterInt println(final CharSequence seq);

    /**     
     * Returns the formatted CharSequence.
     * 
     * @param seq
     *            The CharSequence.
     * @param args            
     *            The arguments referenced for the formatting
     * @return A reference to the Printer.
     */
    PrinterInt printf(final CharSequence seq, final Object... args);

    // *** bold *** //

    /**     
     * Returns the char sequence in bold
     * 
     * @param seq
     *            The CharSequence.
     * @return A reference to the Printer.
     */
    PrinterInt bold(final CharSequence seq);

    /**      
     * Returns the char sequence in bold with the line break
     * 
     * @param seq
     *            The CharSequence.
     * @return A reference to the Printer.
     */
    PrinterInt boldln(final CharSequence seq);

    /**
     * Returns the formatted char sequence in bold.
     * 
     * @param seq
     *            The char sequence.
     * @param args
     *            The arguments referenced for the formatting
     * @return A reference to the Printer.
     */
    PrinterInt boldf(final CharSequence seq, final Object... args);

    // *** trace *** //

    /**
     * Returns the char sequence as trace.
     * 
     * @param seq
     *            The char sequence.
     * @return A reference to the Printer.
     */
    PrinterInt trace(final CharSequence seq);

    /**
     * Returns the CharSequence as trace with the line break.
     * 
     * @param seq
     *           The CharSequence.
     * @return A reference to the Printer.
     */
    PrinterInt traceln(final CharSequence seq);

    /**      
     * Returns the formatted char sequence as trace. 
     * 
     * @param seq
     *            The char sequence
     * @param args
     *            The arguments referenced for the formatting
     * @return A reference to the Printer.
     */
    PrinterInt tracef(final CharSequence seq, final Object... args);

    // *** debug *** //

    /**
     * Returns the char sequence as debug.
     * 
     * @param seq
     *            The char sequence
     * @return A reference to the Printer.
     */
    PrinterInt debug(final CharSequence seq);

    /**
     * Returns the CharSequence as debug with the line break.
     * 
     * @param seq
     *            The char sequence
     * @return A reference to the Printer.
     */
    PrinterInt debugln(final CharSequence seq);

    /**
     * Returns the formatted CharSequence as debug.
     * 
     * @param seq
     *            The char sequence
     * @param args
     *            The arguments referenced for the formatting
     * @return A reference to the Printer.
     */
    PrinterInt debugf(final CharSequence seq, final Object... args);

    // *** warn *** //

    /**
     * Returns the CharSequence as warn.
     * 
     * @param seq
     *            The char sequence
     * @return A reference to the Printer.
     */
    PrinterInt warn(final CharSequence seq);

    /**
     * Returns the CharSequence as warn with the line break.
     * 
     * @param seq
     *            The char sequence
     * @return A reference to the Printer.
     */
    PrinterInt warnln(final CharSequence seq);

    /**
     * Returns the formatted CharSequence as warn.
     * 
     * @param seq
     *            The char sequence
     * @param args
     *            The arguments referenced for the formatting
     * @return A reference to the Printer.
     */
    PrinterInt warnf(final CharSequence seq, final Object... args);

    // *** error *** //

    /**
     * Returns the CharSequence as error.
     * 
     * @param seq
     *            The char sequence
     * @return A reference to the Printer.
     */
    PrinterInt error(final CharSequence seq);

    /**
     * Returns the CharSequence as error with the line break.
     * 
     * @param seq
     *            The char sequence
     * @return A reference to the Printer.
     */
    PrinterInt errorln(final CharSequence seq);

    /**
     * Returns the formatted CharSequence as error.
     * 
     * @param seq
     *            The char sequence
     * @param args
     *            The arguments referenced for the formatting
     * @return A reference to the Printer.
     */
    PrinterInt errorf(final CharSequence seq, final Object... args);

    // *** fatal *** //

    /**
     * Returns the CharSequence as fatal.
     * 
     * @param seq
     *            The char sequence
     * @return A reference to the Printer.
     */
    PrinterInt fatal(final CharSequence seq);

    /**
     * Returns the CharSequence as fatal with the line break.
     * 
     * @param seq
     *            The char sequence
     * @return A reference to the Printer.
     */
    PrinterInt fatalln(final CharSequence seq);

    /**
     * Returns the CharSequence as fatal.
     * 
     * @param seq
     *            The char sequence
     * @param args
     *            The arguments referenced for the formatting
     * @return A reference to the Printer.
     */
    PrinterInt fatalf(final CharSequence seq, final Object... args);

} // PrinterInt
