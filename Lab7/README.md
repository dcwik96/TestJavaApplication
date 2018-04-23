# Testowanie aplikacji JAVA 2017-2018
## Laboratorium 7 (Wprowadzenie do atrap - Mockito i EasyMock)

-------------------------------------------

Wszystkie zadania mają być zapisane w utworzonym projekcie MAVEN!!!

-------------------------------------------

**Zadanie 1** (0.25 pkt)

Do podanego przykładu dopisz po kilka testów z użyciem **Mockito** oraz **EasyMock**. 

**Zadanie 2** (0.75 pkt) 

Wykorzystaj narzędzia **Mockito** oraz **EasyMock** do imitacji zachowań w **NotesService.java** (zadanie poprzednie z poprzedniego laboratorium).

**Wskazówka**: Ponieważ metody nie zwracają wartości **TRUE/FALSE**, a dokonują skutków ubocznych (np. na liście dodawanych ocen), to należy skorzystać tutaj z metody **doAnswer()**, której schemat wygląda następująco: 

```
doAnswer(new Answer<Void>() {
  public void answer(final InvocationOnMock invocation) throws Throwable {
    // Jakas treść
    return null;
  }
}).when(mock).funkcja(argument)

```

**Zadanie 3** (1 pkt)

Klasa **ReverseWords.java** oraz **ReversePhrase.java** reprezentują klasy, odpowiedzialne za odwracanie liter odpowiednio w słowie lub w zdaniu. Dopisz klasy **ReverseUppercase.java** (zamienia kolejność liter i zmienia tekst na wielkie litery) oraz **ReverseForceUpperCase.java** (zgłasza sytuację wyjątkową, jeżeli przekazany tekst zawiera małe litery), które również nie mają implementacji jak **ReversePhrase.java**. Przetestuj w tym wypadku klasę **ReverseWords** wykorzystując **Mockito** lub **EasyMock**.

**ZADANIE DODATKOWE**

**Zadanie 4** (1 pkt)

Uruchom dowolne testy wykonane w **Mockito** lub **EasyMock** w **JUnit5**. 
