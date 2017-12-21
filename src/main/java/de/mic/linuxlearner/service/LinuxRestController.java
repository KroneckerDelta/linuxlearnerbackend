package de.mic.linuxlearner.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class LinuxRestController
{

    private LinuxCommandDispatcher dispatcher;

    @Autowired
    public LinuxRestController(LinuxCommandDispatcher dispatcher)
    {
        this.dispatcher = dispatcher;
    }

    @PostMapping("/command")
    @Timed(millis = 1000)
    public String createFahrer(@RequestBody LinuxCommand command) throws URISyntaxException
    {

        // do some stuff
        return dispatcher.resolve(command);
    }

    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public LinuxCommand example()
    {
        LinuxCommand linuxCommand = new LinuxCommand();
        linuxCommand.setCommand("grep");
        linuxCommand.setSource("Dieser Text wird gegrept");
        linuxCommand.setSchalter("inverse");

        LinuxCommand wc = new LinuxCommand();
        wc.setCommand("wc");

        linuxCommand.setPipe(wc);

        return linuxCommand;
    }

}
