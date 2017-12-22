package de.mic.linuxcommand;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.mic.linuxlearner.service.LinuxCommandModel;

public class WCTest
{

    @Test
    public void findOneWord() throws Exception
    {
        LinuxCommandModel model = getWCModel("EinWort", "word");
        WC wc = new WC(model);
        assertEquals("1", wc.execute());
    }

    @Test
    public void findTwoWords() throws Exception
    {
        LinuxCommandModel model = getWCModel("Zwei Wörter", "word");
        WC wc = new WC(model);
        assertEquals("2", wc.execute());
    }

    @Test
    public void findMoreWords() throws Exception
    {
        LinuxCommandModel model = getWCModel("Viel Wörter die hier stehen", "word");
        WC wc = new WC(model);
        assertEquals("5", wc.execute());
    }

    @Test
    public void findOneChar() throws Exception
    {
        LinuxCommandModel model = getWCModel("e", "char");
        WC wc = new WC(model);
        assertEquals("1", wc.execute());
    }

    @Test
    public void findManyChars() throws Exception
    {
        LinuxCommandModel model = getWCModel("Abzekse", "char");
        WC wc = new WC(model);
        assertEquals("7", wc.execute());
    }

    @Test
    public void findManyIncludingBlankChars() throws Exception
    {
        LinuxCommandModel model = getWCModel("A B C", "char");
        WC wc = new WC(model);
        assertEquals("5", wc.execute());
    }

    private LinuxCommandModel getWCModel(String source, String schalter)
    {
        LinuxCommandModel model = new LinuxCommandModel();
        model.setCommand("wc");
        model.setSchalter(schalter);
        model.setSource(source);
        return model;
    }
}
