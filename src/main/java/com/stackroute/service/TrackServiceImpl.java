package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {

        Track savedTrack = trackRepository.save(track);
        return savedTrack;

    }

    @Override
    public List<Track> getAllTracks() {
        List<Track> allTracks = trackRepository.findAll();
        return allTracks;
    }

    @Override
    public Track updateTrackComments(Track track) {
        Track updatedTrack = trackRepository.save(track);
        return updatedTrack;
    }

    @Override
    public void deleteTrack(int id) {
        trackRepository.deleteById(new Integer(id));
    }
//
//    @Override
//    public Track getTrackById(int id) {
//        return null;
//    }
}
