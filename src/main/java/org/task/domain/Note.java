package org.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Заметка
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    /**
     * Id заметки
     */
    private long id;

    /**
     * Текст заметки
     */
    private String text;
}
