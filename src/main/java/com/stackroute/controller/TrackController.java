package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TrackController {
    private TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
        trackService.saveTrack(track);
        responseEntity = new ResponseEntity<String>("Track is successfully saved", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> updateTrackComments(@PathVariable int id, @RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        trackService.updateTrackComments(track);
        responseEntity = new ResponseEntity<String>("Comment is successfully updated", HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrack(@RequestParam int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        trackService.deleteTrack(id);
        responseEntity = new ResponseEntity<String>("Track is deleted successfully.", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("tracks/{id}")
    public ResponseEntity<?> getTracksByName(@PathVariable String id) {
        return new ResponseEntity<List<Track>>(trackService.getByName(id), HttpStatus.OK);
    }
}
