package de.mic.linuxlearner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinuxCommandResolver
{

    private LinuxCommandFinder finder;

    @Autowired
    public LinuxCommandResolver(LinuxCommandFinder finder)
    {
        this.finder = finder;

    }

    /**
     * Resolve all pipes Commands
     * 
     * @param command
     * @return
     */
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
