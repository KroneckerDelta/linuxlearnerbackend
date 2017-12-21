package de.mic.linuxcommand;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.unix4j.Unix4j;
import org.unix4j.builder.Unix4jCommandBuilder;
import org.unix4j.unix.grep.GrepFactory;
import org.unix4j.unix.grep.GrepOption;
import org.unix4j.unix.grep.GrepOptionSets;
import org.unix4j.unix.grep.GrepOptions;

import de.mic.linuxlearner.service.LinuxCommandModel;

public class Grep implements LinuxCommand
{

    public void testSomething()
    {
        GrepOptions options = null;
        GrepOptionSets go = new GrepOptionSets();
        GrepOption wholeline = GrepOption.wholeLine;
        options.asSet();
        String regexp = "";
        File files = new File("");
        Unix4j.grep(options, regexp, files);
        java.lang.String pattern = "";
        ByteArrayOutputStream f = new ByteArrayOutputStream();

        org.unix4j.unix.Grep.Factory.grep(options, pattern);
        Unix4jCommandBuilder sort = Unix4j.cat(files).grep("ab").sort();
        GrepFactory instance = GrepFactory.INSTANCE;
        instance.grep(GrepOption.wholeLine, "as");

    }

    public String execute(LinuxCommandModel command)
    {
        String schalter = command.getSchalter();
        String pattern = command.getPattern();
        String source = command.getSource();

        if (schalter == null)
        {

            return Unix4j.fromString(source).grep(pattern).toStringResult();
        }
        else
        {

            // Schalter noch auswerten
            return Unix4j.fromString(source).grep(pattern).toStringResult();
        }

    }

}
