package de.mic.linuxcommand;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.mic.linuxlearner.service.LinuxCommandModel;

public class GrepTest
{
    private static String crlf = System.lineSeparator();
    private String shortText = "hier ist nur eine Zeile";
    private String longText = //
            "aaaaaaaaa" + crlf + //
                    "bbbbbbb" + crlf + //
                    "cccccccc" + crlf + //
                    "abcd" + crlf + //
                    "efge" + crlf + //
                    "hijk" + crlf + //
                    "lmn" + crlf + //
                    "abcabcabc" + crlf + //
                    "dies ist ein richtiger Text";

    @Test
    public void findNoLinewithOptions()
    {
        LinuxCommandModel model = getGrep(shortText, "", "xxx");
        Grep grep = new Grep(model);
        assertEquals("", grep.execute());
    }

    @Test
    public void findOneLineWithCount()
    {
        LinuxCommandModel model = getGrep(shortText, "count", "ist");
        Grep grep = new Grep(model);
        assertEquals("1", grep.execute());
    }

    @Test
    public void findOneLineWithFixedstrings()
    {
        LinuxCommandModel model = getGrep(shortText, "fixedstrings", "ist");
        Grep grep = new Grep(model);
        assertEquals(shortText, grep.execute());
    }

    @Test
    public void findOneLineWithIgnorecase()
    {
        LinuxCommandModel model = getGrep(shortText, "ignorecase", "ist");
        Grep grep = new Grep(model);
        assertEquals(shortText, grep.execute());
    }

    @Test
    public void findOneLinewithOptionsLinenumber()
    {
        LinuxCommandModel model = getGrep(shortText, "linenumber", "ist");
        Grep grep = new Grep(model);
        assertEquals(shortText, grep.execute());
    }

    @Test
    public void dontFindOneLineWithWholeline()
    {
        LinuxCommandModel model = getGrep(shortText, "wholeline", "ist");
        Grep grep = new Grep(model);
        assertEquals("", grep.execute());
    }

    @Test
    public void findOneLineWithWholeline()
    {
        LinuxCommandModel model = getGrep(shortText, "wholeline", "hier ist nur eine Zeile");
        Grep grep = new Grep(model);
        assertEquals(shortText, grep.execute());
    }

    @Test
    public void findOneLinewithOptions()
    {
        LinuxCommandModel model = getGrep(shortText, "", "ist");
        Grep grep = new Grep(model);
        assertEquals(shortText, grep.execute());
    }

    /**
     * <pre>
     * *********************************************************************
     * *********************************************************************
     * **************  Ab hier die mehrzeiligen Dsteien  *******************
     * *********************************************************************
     * *********************************************************************
     * </pre>
     */

    @Test
    public void findNoLinewithOptions1()
    {
        LinuxCommandModel model = getGrep(longText, "", "xxx");
        Grep grep = new Grep(model);
        assertEquals("", grep.execute());
    }

    @Test
    public void findOneLineWithCount1()
    {
        LinuxCommandModel model = getGrep(longText, "count", "ist");
        Grep grep = new Grep(model);
        assertEquals("1", grep.execute());
    }

    @Test
    public void findOneLineWithFixedstrings1()
    {
        LinuxCommandModel model = getGrep(longText, "fixedstrings", "ist");
        Grep grep = new Grep(model);
        assertEquals("dies ist ein richtiger Text", grep.execute());
    }

    @Test
    public void findOneLineWithIgnorecase1()
    {
        LinuxCommandModel model = getGrep(longText, "ignorecase", "ist");
        Grep grep = new Grep(model);
        assertEquals("dies ist ein richtiger Text", grep.execute());
    }

    @Test
    public void findOneLinewithOptionsLinenumber1()
    {
        LinuxCommandModel model = getGrep(longText, "linenumber", "ist");
        Grep grep = new Grep(model);
        assertEquals("dies ist ein richtiger Text", grep.execute());
    }

    @Test
    public void dontFindOneLineWithWholeline1()
    {
        LinuxCommandModel model = getGrep(longText, "wholeline", "ist");
        Grep grep = new Grep(model);
        assertEquals("", grep.execute());
    }

    @Test
    public void findOneLineWithWholeline1()
    {
        LinuxCommandModel model = getGrep(longText, "wholeline", "dies ist ein richtiger Text");
        Grep grep = new Grep(model);
        assertEquals("dies ist ein richtiger Text", grep.execute());
    }

    @Test
    public void findOneLinewithOptions1()
    {
        LinuxCommandModel model = getGrep(longText, "", "ist");
        Grep grep = new Grep(model);
        assertEquals("dies ist ein richtiger Text", grep.execute());
    }

    @Test
    public void findmoreLines()
    {
        LinuxCommandModel model = getGrep(longText, "", "abc");
        Grep grep = new Grep(model);
    }

    private LinuxCommandModel getGrep(String source, String schalter, String pattern)
    {
        LinuxCommandModel model = new LinuxCommandModel();
        model.setCommand("grep");
        model.setSchalter(schalter);
        model.setSource(source);
        model.setPattern(pattern);
        return model;
    }
}
