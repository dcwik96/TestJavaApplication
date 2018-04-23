# Testowanie aplikacji JAVA 2017-2018
## Laboratorium 6 (Wprowadzenie do atrap)

-------------------------------------------

Wszystkie zadania mają być zapisane w utworzonym projekcie MAVEN!!!

-------------------------------------------

**Zadanie 1** (0.5 pkt)

W projekcie **mocks** znajduje się implementacja dziennika ocen uczniów. Przetestuj klasę **Note**. Pamiętaj o różnych przypadkach!!!

--------------------------

**Zadanie 2** (1 pkt)

W projekcie **mocks** znajdują się następujące interfejsy: 

```
// Interfejs odpowiedzialny za obsługę serwisu programu
public interface NotesService {
	void add(Note note);
	float averageOf(String name);
	void clear();
}

// Interfejs obsługujący przechowywanie danych
public interface NotesStorage {
  void add(Note note);
  List<Note> getAllNotesOf(String name);
  void clear();
}
```
W pliku **NotesServiceImpl** znajduje się implementacja method z interfejsu **NotesService**. 

**Wzorując się na pokazanym przykładzie** przetestuj klasę **NotesServiceImpl**. Klasa ta jest zależna od zmiennej **storageService**, która jest odpowiedzialna za przechowywanie danych. Rozpatrz różne przypadki !!!

**Wskazówki:**

- Należy utworzyć ręcznie atrapę korzstającą z interfejsu **NotesStorage**. 
- Można skorzystać z **MultiMap** z pakietu **Google Guava**.

-------------------

