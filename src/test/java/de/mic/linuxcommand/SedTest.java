package de.mic.linuxcommand;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.mic.linuxlearner.service.LinuxCommandModel;

public class SedTest
{

    @Test
    public void testingSed() throws Exception
    {
        LinuxCommandModel model = new LinuxCommandModel();
        model.setCommand("sed");
        model.setSource("abcdefg");
        model.setPattern("a");
        model.setSchalter("append");
        Sed sed = new Sed(model);
        assertEquals("abcdefga", sed.execute());
    }
}
