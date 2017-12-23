package de.mic.linuxcommand;

import org.unix4j.Unix4j;
import org.unix4j.unix.grep.GrepOption;
import org.unix4j.unix.grep.GrepOptions;

import de.mic.linuxlearner.service.LinuxCommandModel;

public class Grep extends LinuxCommandImpl implements LinuxCommand
{

    public Grep(LinuxCommandModel model)
    {
        super(model);
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
