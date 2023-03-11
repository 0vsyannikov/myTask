package org.task.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.task.domain.Note;
import org.task.entity.NoteEntity;
import org.task.mapper.NoteMapper;
import org.task.repository.NoteRepository;
import org.task.service.NoteService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    @Override
    public Note getNoteById(long id) {
        return noteRepository.findById(id).map(noteMapper::fromEntity).orElseThrow(() -> {
            throw new IllegalArgumentException("Не найдено заметки по id: " + id);
        });
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll().stream().map(noteMapper::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Note createNote(String text) {
        Note note = initNote(text);

        NoteEntity noteEntity = noteMapper.fromDomain(note);

        NoteEntity saved = noteRepository.save(noteEntity);

        return noteMapper.fromEntity(saved);
    }

    private Note initNote(String text) {
        Note note = new Note();
        note.setText(text);
        return note;
    }

    @Override
    public void deleteNote(long id) {
        noteRepository.findById(id).ifPresent(noteRepository::delete);
    }

    @Override
    public Note updateNote(long id, String text) {
        Note foundNote = getNoteById(id);

        foundNote.setText(text);

        NoteEntity noteEntity = noteMapper.fromDomain(foundNote);

        NoteEntity saved = noteRepository.save(noteEntity);

        return noteMapper.fromEntity(saved);
    }
}
