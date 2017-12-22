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

public class Grep extends LinuxCommandImpl implements LinuxCommand
{

    public Grep(LinuxCommandModel model)
    {
        super(model);
    }

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

    public String execute()
    {
        String schalter = model.getSchalter();
        String pattern = model.getPattern();
        String source = model.getSource();

        if (schalter == null)
        {
            return Unix4j.fromString(source).grep(pattern).toStringResult();
        }
        else
        {
            return Unix4j.fromString(source).grep(extractOption(schalter), pattern).toStringResult();
        }

    }

    private GrepOptions extractOption(String schalter)
    {
        switch (schalter.toLowerCase())
        {
            case "count":
                return GrepOption.count;
            case "fixedstrings":
                return GrepOption.fixedStrings;
            case "ignorecase":
                return GrepOption.ignoreCase;
            case "invertmatch":
                return GrepOption.invertMatch;
            case "linenumber":
                return GrepOption.lineNumber;
            case "matchingfiles":
                return GrepOption.matchingFiles;
            case "wholeline":
                return GrepOption.wholeLine;
            default:
                return GrepOption.ignoreCase;
        }
    }

}
