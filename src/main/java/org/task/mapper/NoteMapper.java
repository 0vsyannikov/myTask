package org.task.mapper;

import org.mapstruct.Mapper;
import org.task.domain.Note;
import org.task.entity.NoteEntity;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    Note fromEntity(NoteEntity entity);

    NoteEntity fromDomain(Note note);
}
