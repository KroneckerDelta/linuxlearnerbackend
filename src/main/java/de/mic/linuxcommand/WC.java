package de.mic.linuxcommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unix4j.Unix4j;
import org.unix4j.builder.Unix4jCommandBuilder;
import org.unix4j.unix.wc.WcOption;
import org.unix4j.unix.wc.WcOptions;

import de.mic.linuxlearner.service.LinuxCommandModel;

public class WC extends LinuxCommandImpl implements LinuxCommand
{

    private static final Logger log = LoggerFactory.getLogger(WC.class);

    public WC(LinuxCommandModel model)
    {
        super(model);
    }

    @Override
    public String execute()
    {
        Unix4jCommandBuilder wc = Unix4j.fromString(model.getSource());

        if (model.getSchalter() == null)
        {
            wc.wc();
        }
        else
        {
            wc.wc(extractSchalter(model.getSchalter()));
        }
        String stringResult = wc.toStringResult();
        log.info("Kontroll: " + model.getSource() + " -> " + stringResult + " (" + model.getSchalter() + ")");
        return stringResult;
    }

    private WcOptions extractSchalter(String schalter)
    {
        switch (schalter.toLowerCase())
        {
            case "chars":
                return WcOption.chars;
            case "lines":
                return WcOption.lines;
            case "words":
                return WcOption.words;
            default:
                return WcOption.chars;
        }
    }

}
