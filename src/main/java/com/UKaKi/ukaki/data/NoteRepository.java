package com.UKaKi.ukaki.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UKaKi.ukaki.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
    
}
