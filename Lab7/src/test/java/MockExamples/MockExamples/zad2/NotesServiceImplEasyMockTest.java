package MockExamples.MockExamples.zad2;

import MockExamples.MockExamples.Note;
import MockExamples.MockExamples.NotesServiceImpl;
import MockExamples.MockExamples.NotesStorage;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class NotesServiceImplEasyMockTest {

    @Mock(type = MockType.NICE)
    NotesStorage storage;

    @Test
    public void checkIfCreateWithInstantiatesWorks(){
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        assertThat(ns).isNotNull();
    }

    @Test
    public void checkIfAddNewNoteStorageWorksProperly(){
        Note note = Note.of("Ktos", 3.0f);
        List<Note> list = Arrays.asList(note);
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        expect(storage.getAllNotesOf("Ktos")).andReturn(list);
        replay(storage);

        ns.add(note);

        assertThat(3.0f).isEqualTo(ns.averageOf("Ktos"));
    }

    @Test
    public void checkIfClearStorageWorks() {
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        expect(storage.getAllNotesOf("Ktos")).andReturn(Arrays.asList(new Note[]{}));
        replay(storage);

        ns.clear();

        assertThat(0f).isEqualTo(ns.averageOf("Ktos"));
    }

    @Test
    public void checkIfAverageOfStorageWithMultiptleNotesReturnAvgProperly(){
        Note note2 = Note.of("Ktos", 2.0f);
        Note note3 = Note.of("Ktos", 3.0f);
        NotesServiceImpl ns = NotesServiceImpl.createWith(storage);
        expect(storage.getAllNotesOf("Ktos")).andReturn(Arrays.asList(note2, note3));
        replay(storage);

        ns.add(note2);
        ns.add(note3);

        float expected = (2.0f + 3.0f) / 2;
        assertThat(expected).isEqualTo(ns.averageOf("Ktos"));
    }
}
