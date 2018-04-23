package MockExamples.MockExamples;

import java.util.Collection;

public class NotesServiceImpl implements NotesService {

	private final NotesStorage storageService;
	
	private NotesServiceImpl(final NotesStorage storageService) {
		this.storageService = storageService;
	}
	
	public static NotesServiceImpl createWith(final NotesStorage storageService) {
		return new NotesServiceImpl(storageService);
	}
	
	@Override
	public void add(Note note) {
		storageService.add(note);
	}

	@Override
	public float averageOf(String name) {
		float sum = 0.0f;
		final Collection<Note> notes = storageService.getAllNotesOf(name);
		if(notes.isEmpty())
			return 0f;
		for (final Note note: notes) {
			sum += note.getNote();
		}
		return sum / notes.size();
	}

	@Override
	public void clear() {
		storageService.clear();
	}
	
	
}
