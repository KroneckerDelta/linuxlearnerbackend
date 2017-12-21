package de.mic.linuxcommand;

import de.mic.linuxlearner.service.LinuxCommandModel;

public interface LinuxCommand
{
    String execute(LinuxCommandModel command);
}
