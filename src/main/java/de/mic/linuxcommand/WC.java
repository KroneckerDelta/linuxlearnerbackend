package de.mic.linuxcommand;

import org.unix4j.Unix4j;
import org.unix4j.builder.Unix4jCommandBuilder;
import org.unix4j.unix.wc.WcOption;
import org.unix4j.unix.wc.WcOptions;

import de.mic.linuxlearner.service.LinuxCommandModel;

public class WC extends LinuxCommandImpl implements LinuxCommand
{

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
        System.out.println("Kontroll: " + model.getSource() + " -> " + stringResult + " (" + model.getSchalter() + ")");
        return stringResult;
    }

    private WcOptions extractSchalter(String schalter)
    {
        return WcOption.chars;
    }

}