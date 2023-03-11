package org.task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.task.domain.Note;
import org.task.service.NoteService;

import java.util.List;

@RestController
@RequestMapping(value = "/notes-controller")
@RequiredArgsConstructor
public class NotesController {
    private final NoteService noteService;

    @GetMapping(value = "/note/{id}")
    public Note getNoteById(@PathVariable long id) {
        return noteService.getNoteById(id);
    }

    @GetMapping(value = "/notes")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping("/note")
    public Note createNote(String text) {
        return noteService.createNote(text);
    }

    @DeleteMapping("/note/{id}")
    public void deleteNote(@PathVariable long id) {
        noteService.deleteNote(id);
    }

    @PutMapping("/note/{id}")
    public Note updateNote(@PathVariable long id, String text) {
        return noteService.updateNote(id, text);
    }
}
