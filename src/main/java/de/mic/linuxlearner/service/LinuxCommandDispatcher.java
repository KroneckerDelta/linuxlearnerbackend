package de.mic.linuxlearner.service;

import org.springframework.stereotype.Controller;

import de.mic.linuxcommand.LinuxCommandFinder;

@Controller
public class LinuxCommandDispatcher
{

    private String source;

    private LinuxCommandFinder finder;

    public String resolve(LinuxCommandModel command)
    {
        source = command.getSource();

        return resolveImpl(command);
    }

    public String resolveImpl(LinuxCommandModel command)
    {

        if (command.getPipe() == null)
        {
            String linuxCommand = command.getCommand();
            String schalter = command.getSchalter();
            String pattern = command.getPattern();
            command.setSource(source);
            return finder.getLinuxCommand(linuxCommand).execute(command);
        }
        else
        {
            return resolveImpl(command.getPipe());
        }

    }

}
