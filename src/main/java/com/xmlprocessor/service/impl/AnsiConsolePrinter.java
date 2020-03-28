package com.xmlprocessor.service.impl;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.BLUE;
import static org.fusesource.jansi.Ansi.Color.CYAN;
import static org.fusesource.jansi.Ansi.Color.MAGENTA;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.Color.YELLOW;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.fusesource.jansi.Ansi.Color;

import com.xmlprocessor.service.api.PrinterInt;

import org.fusesource.jansi.AnsiConsole;

/**
 * Prints to Console. Uses <a href="http://jansi.fusesource.org/">Jansi</a> library to format console output.
 * 
 * <p>
 * Eclipse plugin - ANSI Escape in Console <br/>
 * To install the plugin in Eclipse select Help -> Install New Software... and click -Add...- to add the following URL:
 * <code>http://www.mihai-nita.net/eclipse</code>
 * </p>
 * 
 * <p>
 * Note for jansi If you use jansi, it might look like the plugin does not work. That is because jansi detects when the
 * standard output is redirected and does not output the escape sequences anymore. So try adding this to your code,
 * before using jansi: <code>System.setProperty("jansi.passthrough", "true")</code>
 * <p>
 *
 */
public class AnsiConsolePrinter implements PrinterInt {
  
    /** Character Encoding {@value} . */
    private static final String ENCODING_CP850 = "CP850";

    private static final String JANSI_PASSTHROUGH = "jansi.passthrough";

  
    public static void passthrough() {
        //LOG.debug(JANSI_PASSTHROUGH);
        System.setProperty(JANSI_PASSTHROUGH, Boolean.TRUE.toString());
    } 

    /** {@inheritDoc} */
    public PrinterInt print(final CharSequence seq) {
        this.ansiConsoleOut().print(seq);
        return this;
    } // print(CharSequence)

    /** {@inheritDoc} */
    public PrinterInt println(final CharSequence seq) {
        this.ansiConsoleOut().println(seq);
        return this;
    } // println(CharSequence)

    /** {@inheritDoc} */
    public PrinterInt printf(final CharSequence seq, final Object... args) {
        this.ansiConsoleOut().printf(seq.toString(), args);
        return this;
    } // printf(CharSequence,Object...)

    // *** bold *** //

    /** {@inheritDoc} */
    //@Override
    public PrinterInt bold(final CharSequence seq) {
        this.ansiConsoleOut().print(ansi().bold().a(seq).boldOff());
        return this;
    } // bold(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt boldln(final CharSequence seq) {
        this.ansiConsoleOut().println(ansi().bold().a(seq).boldOff());
        return this;
    } // boldln(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt boldf(final CharSequence seq, final Object... args) {
        this.ansiConsoleOut().printf(ansi().bold().a(seq).boldOff().toString(), args);
        return this;
    } // boldf(CharSequence,Object...)

    // *** trace *** //

    /** {@inheritDoc} */
    //@Override
    public PrinterInt trace(final CharSequence seq) {
        return print(seq, CYAN);
    } // trace(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt traceln(final CharSequence seq) {
        return println(seq, CYAN);
    } // traceln(CharSequence)

    /** {@inheritDoc} */
   // @Override
    public PrinterInt tracef(final CharSequence seq, final Object... args) {
        return printf(seq, CYAN, args);
    } // tracef(CharSequence,Object...)

    // *** debug *** //

    /** {@inheritDoc} */
    //@Override
    public PrinterInt debug(final CharSequence seq) {
        return print(seq, BLUE);
    } // debug(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt debugln(final CharSequence seq) {
        return println(seq, BLUE);
    } // debugln(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt debugf(final CharSequence seq, final Object... args) {
        return printf(seq, BLUE, args);
    } // debugf(CharSequence,Object...)

    // *** warn *** //

    /** {@inheritDoc} */
    //@Override
    public PrinterInt warn(final CharSequence seq) {
        return print(seq, YELLOW);
    } // warn(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt warnln(final CharSequence seq) {
        return println(seq, YELLOW);
    } // warnln(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt warnf(final CharSequence seq, final Object... args) {
        return printf(seq, YELLOW, args);
    } // warnf(CharSequence,Object...)

    // *** error *** //

    /** {@inheritDoc} */
    //@Override
    public PrinterInt error(final CharSequence seq) {
        return print(seq, RED);
    } // error(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt errorln(final CharSequence seq) {
        return println(seq, RED);
    } // errorln(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt errorf(final CharSequence seq, final Object... args) {
        return printf(seq, RED, args);
    } // errorf(CharSequence,Object...)

    // *** fatal *** //

    /** {@inheritDoc} */
    //@Override
    public PrinterInt fatal(final CharSequence seq) {
        return print(seq, MAGENTA);
    } // fatal(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt fatalln(final CharSequence seq) {
        return println(seq, MAGENTA);
    } // fatalln(CharSequence)

    /** {@inheritDoc} */
    //@Override
    public PrinterInt fatalf(final CharSequence seq, final Object... args) {
        return printf(seq, MAGENTA, args);
    } // fatalf(CharSequence,Object...)

   
    private PrintStream ansiConsoleOut() {
        PrintStream ansiConsoleOut = null;
        String property = System.getProperty(JANSI_PASSTHROUGH);

        if (property != null && property.equals(Boolean.TRUE.toString())) {
            ansiConsoleOut = AnsiConsole.out();
        } else {
            try {
                ansiConsoleOut = new PrintStream(AnsiConsole.out(), true, ENCODING_CP850);
            } catch (UnsupportedEncodingException ueEx) {
                //LOG.error(ueEx);
            } // try/catch
        } // if/else
        return ansiConsoleOut;
    } // ansiConsoleOut;

    /**
     * Prints a CharSequence. If the argument is null then the string "null" is printed.
     * 
     * @param sequence
     *            The CharSequence to be printed.
     * @param color
     *            A ANSI Color.
     * @return A reference to this.
     */
    private PrinterInt print(final CharSequence sequence, final Color color) {
        this.ansiConsoleOut().print(ansi().bold().fg(color).a(sequence).reset());
        return this;
    } // print(CharSequence,Color)

    /**
     * Prints an CharSequence and then terminate the line.
     * 
     * @param sequence
     *            The CharSequence to be printed.
     * @param color
     *            A ANSI Color.
     * @return A reference to this.
     */
    private PrinterInt println(final CharSequence sequence, final Color color) {
        this.ansiConsoleOut().println(ansi().bold().fg(color).a(sequence).reset());
        return this;
    } // println(CharSequence,Color)

    /**
     * A convenience method to write a formatted string to this output stream using the specified format string and
     * arguments.
     * 
     * @param sequence
     *            A format CharSequence.
     * @param color
     *            A ANSI Color.
     * @param args
     *            Arguments referenced by the format specifiers in the format string. If there are more arguments than
     *            format specifiers, the extra arguments are ignored. The number of arguments is variable and may be
     *            zero.
     * @return A reference to this.
     */
    public PrinterInt printf(final CharSequence sequence, final Color color, final Object... args) {
        this.ansiConsoleOut().printf(ansi().bold().fg(color).a(sequence).reset().toString(), args);
        return this;
    } // printf(CharSequence,Color,Object...)

} // AnsiConsolePrinter
