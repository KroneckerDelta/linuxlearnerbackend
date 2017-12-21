package de.mic.linuxcommand;

public class LinuxCommandFinder
{

    public LinuxCommand getLinuxCommand(String linuxCommand)
    {
        // noch ist einfach, weil nur grep :-)
        return new Grep();
    }

}
