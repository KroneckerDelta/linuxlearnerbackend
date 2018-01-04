package de.mic.linuxlearner.service;

import org.springframework.stereotype.Service;

import de.mic.linuxcommand.Grep;
import de.mic.linuxcommand.LinuxCommand;
import de.mic.linuxcommand.Sed;
import de.mic.linuxcommand.Sort;
import de.mic.linuxcommand.WC;

@Service
public class LinuxCommandFinder
{

    public LinuxCommand getLinuxCommand(LinuxCommandModel linuxCommand)
    {
        String command = linuxCommand.getCommand().toLowerCase();
        switch (command)
        {
            case "grep":
                return new Grep(linuxCommand);
            case "wc":
                return new WC(linuxCommand);
            case "sed":
                return new Sed(linuxCommand);
            case "sort":
                return new Sort(linuxCommand);
            default:
                return new WC(linuxCommand);
        }
    }

}
