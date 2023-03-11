package org.task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * БД заметки
 */
@Entity
@Table(name = "T_NOTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteEntity {
    /**
     * Id заметки
     */
    @Id
    @Column(name = "C_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTE_SEQ")
    @SequenceGenerator(name = "NOTE_SEQ", sequenceName = "SEQUANCE_NOTES", allocationSize = 1)
    private long id;

    /**
     * Текст заметки
     */
    @Column(name = "C_TEXT")
    private String text;
}
