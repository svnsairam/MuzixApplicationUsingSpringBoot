package com.stackroute.configuration;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
class ApplicationListenerConfig implements org.springframework.context.ApplicationListener<ContextRefreshedEvent> {
    private TrackRepository trackRepository;
    @Value("0")
    private int id;
    @Value("default name")
    private String name;
    @Value("default comments")
    private String comments;

    @Autowired
    public ApplicationListenerConfig(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Track track = new Track(id, name, comments);
        trackRepository.save(track);
    }
}