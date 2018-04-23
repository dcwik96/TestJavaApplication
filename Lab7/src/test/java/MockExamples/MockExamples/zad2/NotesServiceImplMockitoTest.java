package MockExamples.MockExamples.zad2;

import MockExamples.MockExamples.Note;
import MockExamples.MockExamples.NotesServiceImpl;
import MockExamples.MockExamples.NotesStorage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class NotesServiceImplMockitoTest {

    @Mock
    NotesStorage notesStorage;

    @Test
    public void checkIfCreateWithInstantiatesWorks() {
        NotesServiceImpl ns = NotesServiceImpl.createWith(notesStorage);
        assertThat(ns).isNotNull();
    }

    @Test
    public void checkIfAddNewNoteStorageWorksProperly() {
        Note note = Note.of("Asdf", 2.0f);
        List<Note> list = Arrays.asList(note);
        NotesServiceImpl ns = NotesServiceImpl.createWith(notesStorage);
        doReturn(list).when(notesStorage).getAllNotesOf("Asdf");

        ns.add(note);

        assertThat(2.0f).isEqualTo(ns.averageOf("Asdf"));
    }

    @Test
    public void checkIfClearStorageWorks() {
        NotesServiceImpl ns = NotesServiceImpl.createWith(notesStorage);
        doNothing().when(notesStorage).clear();
        doReturn(Arrays.asList()).when(notesStorage).getAllNotesOf("Ktos");

        ns.clear();

        assertThat(ns.averageOf("Ktos")).isEqualTo(0f);
    }

    @Test
    public void checkIfClearStorageWithMultiplieNotes() {
        Note note2 = Note.of("Ktos", 2.0f);
        Note note3 = Note.of("Ktos", 3.0f);
        NotesServiceImpl ns = NotesServiceImpl.createWith(notesStorage);
        doNothing().when(notesStorage).clear();
        doReturn(Arrays.asList()).when(notesStorage).getAllNotesOf("Ktos");

        ns.clear();

        assertThat(0f).isEqualTo(ns.averageOf("Ktos"));
    }

    @Test
    public void checkIfAverageOfStorageWithMultiptleNotesReturnAvgProperly() {
        Note note2 = Note.of("Ktos", 2.0f);
        Note note3 = Note.of("Ktos", 3.0f);
        NotesServiceImpl ns = NotesServiceImpl.createWith(notesStorage);
        doReturn(Arrays.asList(note2, note3)).when(notesStorage).getAllNotesOf("Ktos");
        doNothing().when(notesStorage).add(note2);
        doNothing().when(notesStorage).add(note3);

        ns.add(note2);
        ns.add(note3);

        float expected = (2.0f + 3.0f) / 2;
        assertThat(expected).isEqualTo(ns.averageOf("Ktos"));
    }

    @Test
    public void checkIfAvgOfNotExistingUserIsZero() {
        NotesServiceImpl ns = NotesServiceImpl.createWith(notesStorage);
        assertThat(0f).isEqualTo(ns.averageOf("Brak"));
    }

}
