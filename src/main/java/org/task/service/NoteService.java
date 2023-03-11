package org.task.service;

import org.task.domain.Note;

import java.util.List;

/**
 * Интерфейс для реализаций сервисов по работе с заметками
 */
public interface NoteService {
    Note getNoteById(long id);

    List<Note> getAllNotes();

    Note createNote(String text);

    void deleteNote(long id);

    Note updateNote(long id, String text);
}
