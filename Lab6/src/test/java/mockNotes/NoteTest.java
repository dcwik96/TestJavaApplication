package mockNotes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoteTest {


    @Test
    void testCreate() {
        final Note note = Note.of("Mateusz Miotk", 4.5f);
        assertEquals("Mateusz Miotk", note.getName());
        assertEquals(4.5f, note.getNote(), 0.01f);
    }

}
