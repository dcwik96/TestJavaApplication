# Testowanie aplikacji JAVA 2017-2018
## Laboratorium 5 (Wprowadzenie do narzędzia MAVEN)

----------------------

Wszsytkie zadania mają być zapisane w jednym projekcie MAVEN lub w plikach tekstowych o podanej nazwie!!!
Repozytorium powinno zawierać folder **src** oraz plik **pom.xml**. Nie tworzymy żadnych podfolderów!!!

---------------------

**Zadanie 1** (0.25 pkt)

Utwórz z konsoli projekt przy użyciu narzędzia MAVEN, który będzie zawierał dowolną metodę **main**. Następnie spakuj aplikację i uruchom metodę **main**. Podaj dokładną składnie polecenia (z terminala) do utworzenia projektu w MAVEN oraz uruchomienia metody main w projekcie. Zapisz tę polecenia w pliku **zad1.txt**.

--------------------------

**Zadanie 2** (0.25 pkt)

W projekcie z zadania pierwszego uruchom testy przy użyciu narzędzia **JUnit5**. Wyszukaj informacje w sieci lub skorzystaj z [tutaj](https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-running-unit-tests-with-maven/) lub [tutaj](https://github.com/junit-team/junit5-samples/blob/master/junit5-maven-consumer/pom.xml).

-------------------

**Zadanie 3** (1 pkt*)

W pliku **BinSearch.java** znajduje się implementacja przeszukiwania binarnego. Przetestuj tę metodę w projekcie MAVEN z zadania pierwszego przy użyciu narzędzia **JUnit5**. 

\* 1 pkt - za zamianę metody na typ generyczny i przetestowanie metody.

\* 0.5 pkt za przetestowanie podstawowego typu.

--------------------

**Zadanie 4** (1 pkt*)

Rozważmy, że piszemy dowolną grę, w której plansza jest reprezentowana przez tablicę dwuwymiarową dowolnego typu. W projekcie z zadania pierwszego, napisz testy, a następnie implementację tej planszy, tak aby była prowadzona na niej symulacja dowolnej gry logicznej (np. ustawianie pionków, symulacja gracza itp.) **Nie trzeba pisać całej gry!!!**. Skupiamy się wyłącznie na implementacji planszy. Uruchom narzędzie do **code coverage** w projekcie MAVEN!

\* ilość punktów zależy od ilości funkcjonalności na planszy  
