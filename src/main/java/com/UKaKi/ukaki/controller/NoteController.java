package com.UKaKi.ukaki.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UKaKi.ukaki.data.NoteRepository;
import com.UKaKi.ukaki.entity.Note;

@RequestMapping(path="/notes", produces="application/json")
@RestController
public class NoteController {
    
    private final NoteRepository noteRepo;

    public NoteController(NoteRepository noteRepo){
        this.noteRepo=noteRepo;
    }

    @GetMapping(params="recent")
    public Iterable<Note> recentNotes(){
        PageRequest page= PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return noteRepo.findAll(page).getContent();
    }

}
