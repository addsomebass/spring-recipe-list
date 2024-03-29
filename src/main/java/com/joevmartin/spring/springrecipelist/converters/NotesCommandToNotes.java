package com.joevmartin.spring.springrecipelist.converters;


import com.joevmartin.spring.springrecipelist.commands.NoteCommand;
import com.joevmartin.spring.springrecipelist.domain.Note;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class NotesCommandToNotes implements Converter<NoteCommand, Note> {

    @Synchronized
    @Nullable
    @Override
    public Note convert(NoteCommand source) {
        if(source == null) {
            return null;
        }

        final Note notes = new Note();
        notes.setId(source.getId());
        notes.setRecipeNote(source.getRecipeNote());
        return notes;
    }
}
