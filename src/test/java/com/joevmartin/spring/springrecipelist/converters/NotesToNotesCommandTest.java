package com.joevmartin.spring.springrecipelist.converters;

import com.joevmartin.spring.springrecipelist.commands.NoteCommand;
import com.joevmartin.spring.springrecipelist.domain.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by jt on 6/21/17.
 */
public class NotesToNotesCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";
    NotesToNotesCommand converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void convert() throws Exception {
        //given
        Note notes = new Note();
        notes.setId(ID_VALUE);
        notes.setRecipeNote(RECIPE_NOTES);

        //when
        NoteCommand notesCommand = converter.convert(notes);

        //then
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNote());
    }

    @Test
    public void testNull() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Note()));
    }
}