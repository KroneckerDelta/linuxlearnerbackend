package de.mic.linuxcommand;

import de.mic.linuxlearner.service.LinuxCommandModel;

public abstract class LinuxCommandImpl
{

    LinuxCommandModel model;

    public LinuxCommandImpl(LinuxCommandModel model)
    {
        this.model = model;

    }
}
