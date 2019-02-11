package com.stackroute.configuration;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:application.properties")
public class CommandLineRunnerConfig implements org.springframework.boot.CommandLineRunner {
    private TrackRepository trackRepository;
    @Autowired
    Environment environment;

    @Autowired
    public CommandLineRunnerConfig(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String args[]) throws Exception {
        Track track = new Track(Integer.parseInt(environment.getProperty("id")),environment.getProperty("name"),environment.getProperty("comments"));
        trackRepository.save(track);
    }
}