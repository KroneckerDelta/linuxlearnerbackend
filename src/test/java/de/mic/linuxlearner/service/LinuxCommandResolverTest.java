package de.mic.linuxlearner.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes =
{ LinuxCommandResolver.class, LinuxCommandFinder.class })
public class LinuxCommandResolverTest
{

    private static final Logger log = LoggerFactory.getLogger(LinuxCommandResolverTest.class);

    @Autowired
    private LinuxCommandResolver linuxCommandDispatcher;

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
        log.info("REsolve: " + resolve);
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
        log.info("REsolve: " + resolve);
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
        pipe.setSchalter("char");

        model.setPipe(pipe);

        String resolve = linuxCommandDispatcher.resolve(model);
        log.info("REsolve: " + resolve);
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
        model.setSchalter("words");

        String resolve = linuxCommandDispatcher.resolve(model);

        assertEquals(resolve, "1");
    }

    @Test
    public void doWord2Count() throws Exception
    {
        LinuxCommandModel model = new LinuxCommandModel();
        model.setCommand("wc");
        model.setSource("dies ist ein Satz");
        model.setSchalter("words");

        String resolve = linuxCommandDispatcher.resolve(model);

        assertEquals(resolve, "4");
    }
}
