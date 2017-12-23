package de.mic.linuxlearner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@EnableAutoConfiguration
public class LinuxLearnerApp
{

    private static final Logger log = LoggerFactory.getLogger(LinuxLearnerApp.class);

    public static void main(String args[])
    {
        log.info("Start Linuxlearner");
        SpringApplication.run(LinuxLearnerApp.class);
    }

}