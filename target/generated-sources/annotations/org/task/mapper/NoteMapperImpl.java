package org.task.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.task.domain.Note;
import org.task.entity.NoteEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-11T10:10:29+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class NoteMapperImpl implements NoteMapper {

    @Override
    public Note fromEntity(NoteEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Note note = new Note();

        note.setId( entity.getId() );
        note.setText( entity.getText() );

        return note;
    }

    @Override
    public NoteEntity fromDomain(Note note) {
        if ( note == null ) {
            return null;
        }

        NoteEntity noteEntity = new NoteEntity();

        noteEntity.setId( note.getId() );
        noteEntity.setText( note.getText() );

        return noteEntity;
    }
}
