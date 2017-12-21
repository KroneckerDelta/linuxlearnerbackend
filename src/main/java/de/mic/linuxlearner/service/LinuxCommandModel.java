package de.mic.linuxlearner.service;

public class LinuxCommandModel
{

    private String command;
    private String source;
    private String pattern;
    private String schalter;
    private LinuxCommandModel pipe;

    public String getCommand()
    {
        return command;
    }

    public void setCommand(String command)
    {
        this.command = command;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public LinuxCommandModel getPipe()
    {
        return pipe;
    }

    public void setPipe(LinuxCommandModel pipe)
    {
        this.pipe = pipe;
    }

    public String getSchalter()
    {
        return schalter;
    }

    public void setSchalter(String schalter)
    {
        this.schalter = schalter;
    }

    public String getPattern()
    {
        return pattern;
    }

    public void setPattern(String pattern)
    {
        this.pattern = pattern;
    }

}
