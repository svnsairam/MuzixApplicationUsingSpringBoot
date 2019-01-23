package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        Track savedTrack = trackRepository.save(track);
        if (savedTrack == null) {
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        List<Track> allTracks = trackRepository.findAll();
        return allTracks;
    }

    @Override
    public Track updateTrackComments(Track track) throws TrackNotFoundException {
        if (!trackRepository.existsById(track.getId())) {
            throw new TrackNotFoundException("Track Not Found");
        }
        Track updatedTrack = trackRepository.save(track);
        return updatedTrack;
    }

    @Override
    public void deleteTrack(int id) throws TrackNotFoundException {
        if (!trackRepository.existsById(id)) {
            throw new TrackNotFoundException("Track Not Found");
        }
        trackRepository.deleteById(new Integer(id));
    }

    @Override
    public List<Track> getByName(String name) {
       return trackRepository.findByName(name);
    }
}
