package de.mic.linuxlearner.service;

import org.springframework.stereotype.Controller;

@Controller
public class LinuxCommandDispatcher
{

    public String resolve(LinuxCommand command)
    {
        return "über Linux Commader";
    }

}
