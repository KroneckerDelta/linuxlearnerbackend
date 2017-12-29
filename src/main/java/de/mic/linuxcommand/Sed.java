package de.mic.linuxcommand;

import org.unix4j.Unix4j;
import org.unix4j.unix.sed.SedOption;
import org.unix4j.unix.sed.SedOptions;

import de.mic.linuxlearner.service.LinuxCommandModel;

public class Sed extends LinuxCommandImpl implements LinuxCommand
{

    public Sed(LinuxCommandModel model)
    {
        super(model);
    }

    @Override
    public String execute()
    {
        String schalter = model.getSchalter();
        String pattern = model.getPattern();
        String source = model.getSource();

        return Unix4j.fromString(source).sed(extractOption(schalter), pattern).toStringResult();
    }

    private SedOptions extractOption(String schalter)
    {
        if (schalter == null)
        {
            return SedOption.EMPTY;
        }
        switch (schalter.toLowerCase())
        {

            case "append":
                return SedOption.append;
            case "change":
                return SedOption.change;
            case "ignorecase":
                return SedOption.ignoreCase;
            case "delete":
                return SedOption.delete;
            case "linenumber":
                return SedOption.lineNumber;
            case "global":
                return SedOption.global;
            case "insert":
                return SedOption.insert;
            case "print":
                return SedOption.print;
            case "quit":
                return SedOption.quiet;
            case "substitute":
                return SedOption.substitute;
            case "translate":
                return SedOption.translate;

            default:
                return SedOption.ignoreCase;
        }
    }

}
