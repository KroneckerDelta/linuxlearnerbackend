package de.mic.linuxlearner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinuxCommandDispatcher
{

    private String source;

    private LinuxCommandFinder finder;

    @Autowired
    public LinuxCommandDispatcher(LinuxCommandFinder finder)
    {
        this.finder = finder;

    }

    public String resolve(LinuxCommandModel command)
    {
        String ergebnis = finder.getLinuxCommand(command).execute();
        if (command.getPipe() == null)
        {
            return ergebnis;
        }
        else
        {
            command.getPipe().setSource(ergebnis);
            return resolve(command.getPipe());
        }
    }
}
