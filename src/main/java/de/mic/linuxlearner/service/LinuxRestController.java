package de.mic.linuxlearner.service;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletResponse;

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

    private LinuxCommandResolver dispatcher;

    @Autowired
    public LinuxRestController(LinuxCommandResolver dispatcher)
    {
        this.dispatcher = dispatcher;
    }

    @PostMapping("/command")
    @Timed(millis = 1000)
    public String createFahrer(HttpServletResponse response, @RequestBody LinuxCommandModel command) throws URISyntaxException
    {
        // response.setHeader("Access-Control-Allow-Origin", "*");
        // response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        // response.setHeader("Access-Control-Max-Age", "3600");
        // response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        // do some stuff
        String result = dispatcher.resolve(command);
        return result;
    }

    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public LinuxCommandModel example()
    {
        LinuxCommandModel linuxCommand = new LinuxCommandModel();
        linuxCommand.setCommand("grep");
        linuxCommand.setSource("Dieser Text wird gegrept");
        linuxCommand.setSchalter("inverse");
        linuxCommand.setPattern("abc");

        LinuxCommandModel wc = new LinuxCommandModel();
        wc.setCommand("wc");

        linuxCommand.setPipe(wc);

        return linuxCommand;
    }

}
