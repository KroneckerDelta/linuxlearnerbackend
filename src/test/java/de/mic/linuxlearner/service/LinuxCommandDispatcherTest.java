package de.mic.linuxlearner.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes =
{ LinuxCommandDispatcher.class, LinuxCommandFinder.class })
public class LinuxCommandDispatcherTest

{
    @Autowired
    private LinuxCommandDispatcher linuxCommandDispatcher;

    @Test
    public void dispatcherIsNotNull() throws Exception
    {
        assertNotNull(linuxCommandDispatcher);
    }

    @Test
    public void some() throws Exception
    {
        LinuxCommandModel model = new LinuxCommandModel();
        model.setCommand("grep");
        model.setPattern("ab");
        model.setSource("abcdejdjkwikwndjlfsdfhk" + "dsdsds" + "dsdsds" + "dsdsds" + "\\naaaaaaaaaaaaaa");
        String resolve = linuxCommandDispatcher.resolve(model);
        System.out.println("REsolve: " + resolve);
    }

    @Test
    public void pipeSome() throws Exception
    {
        LinuxCommandModel model = new LinuxCommandModel();
        model.setCommand("grep");
        model.setPattern("ab");
        model.setSource("abcdejdjkwikwndjlfsdfhk" + "dsdsds" + "dsdsds" + "dsdsds" + "\\naaaaaaaaaaaaaa");

        LinuxCommandModel pipe = new LinuxCommandModel();
        pipe.setCommand("grep");
        pipe.setSchalter("i");
        pipe.setPattern("a");
        model.setPipe(pipe);

        String resolve = linuxCommandDispatcher.resolve(model);
        System.out.println("REsolve: " + resolve);
    }

    @Test
    public void doCharCountTwice() throws Exception
    {
        LinuxCommandModel model = new LinuxCommandModel();
        model.setCommand("wc");
        model.setSource("kwndjlfs");
        model.setSchalter("char");
        LinuxCommandModel pipe = new LinuxCommandModel();
        pipe.setCommand("wc");
        model.setPipe(pipe);

        String resolve = linuxCommandDispatcher.resolve(model);
        System.out.println("REsolve: " + resolve);
        assertEquals(resolve, "1");
    }

    @Test
    public void doCharCount() throws Exception
    {
        LinuxCommandModel model = new LinuxCommandModel();
        model.setCommand("wc");
        model.setSource("kwndjlfs");
        model.setSchalter("char");

        String resolve = linuxCommandDispatcher.resolve(model);

        assertEquals(resolve, "8");
    }

    @Test
    public void doWordCount() throws Exception
    {
        LinuxCommandModel model = new LinuxCommandModel();
        model.setCommand("wc");
        model.setSource("kwndjlfs");
        model.setSchalter("char");

        String resolve = linuxCommandDispatcher.resolve(model);

        assertEquals(resolve, "1");
    }

    @Test
    public void doWord2Count() throws Exception
    {
        LinuxCommandModel model = new LinuxCommandModel();
        model.setCommand("wc");
        model.setSource("dies ist ein Satz");
        model.setSchalter("char");

        String resolve = linuxCommandDispatcher.resolve(model);

        assertEquals(resolve, "4");
    }
}
