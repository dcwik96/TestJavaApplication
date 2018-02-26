# Testowanie aplikacji JAVA 2017-2018
## Laboratorium 1 (Wstęp do testowania oraz JUnit-a)

[**Tutaj**](http://inf.ug.edu.pl/~mmiotk/Dydaktyka/2017-2018/TAJAVA2017-2018/junit.pdf) znajduje się ściąga z JUnit.

[**Tutaj**](http://inf.ug.edu.pl/~mmiotk/Dydaktyka/2017-2018/TAJAVA2017-2018/WprowadzenieJUnit.pdf) znajduje się prezentacja ze wstępu do testowania w JUnit.

[**Tutaj**](http://inf.ug.edu.pl/~mmiotk/Dydaktyka/2017-2018/TAJAVA2017-2018/introductionJUnit.zip) znajduje się projekt **introductionJUnit**.

**Zadanie 1** (0.5 pkt) 

Napisz klasę NWD oraz NWW, które będą zawierać odpowiednio metody: 

```
int nwd(int a, int b);
int nww(int a, int b);
```

Następnie napisz klasę NWDTest oraz NWWTest, która będzie klasą testującą powyższych klas. Zaplanuj i zaimplementuj odpowiednie przypadki testowe. Skorzystaj z różnych dostępnych asercji. Metoda nwd ma obliczać największy wspólny dzielnik, zaś nww najmniejszą wspólną wielokrotność. 

**Zadanie 2** (0.35 pkt)

Napisz klasę Calculator, która będzie dostarczała pięć publicznych następujących metod: 

```
int add(int a, int b);
int sub(int a, int b);
int multi(int a, int b);
int div(int a, int b);
boolean greater(int a, int b);
boolean less(int a, int b);
boolean equality(int a, int b);
```
Następnie napisz klasę CalculatorTest, która będzie klasą testującą dla klasy Calculator. Zaplanuj i zaimplementuj odpowiednie przypadki testowe. Skorzystaj z różnych asercji.

**Zadanie 3** (0.15 pkt)

Zmodyfikuj powyższą klasę dla typu double. Jak wówczas należy pisać przypadki testowe? Odpowiedź uzasadnij i pokaż przykład, że operacja może wykonać się z pewnym błędem.

**Zadanie 4** (0.25 pkt)

Wykorzystując wiedzę z zadania trzeciego, napisz klasę Circle, która będzie zawierała następujące metody: 

```
double circumfence(Circle c);
double poleCircle(Circle c);
```

Następnie napisz klasę CircleTest, która będzie klasą testującą dla klasy Circle. Zaplanuj i zaimplementuj odpowiednie przypadki testowe. Metody circumfence oraz poleCircle obliczają odpowiednio obwód i pole koła. 

**Zadanie 5** (0.25 pkt)

Napisz klasę Table, która będzie zawierała następujące metody: 

```
int largest(Table t);
int smallest(Table t);
boolean isSorted(Table t);
```

Następnie napisz klasę TableTest, która będzie klasą testującą dla klasy Table. Zaplanuj i zaimplementuj odpowiednie przypadki testowe. Metody largest i smallest odnajdują odpowiednio największy i najmniejszy element tablicy, natomiast isSorted sprawdza, czy tablica jest posortowana w porządku rosnącym. Pamiętaj o różnych przypadkach. Nie używaj gotowych funkcji max oraz min!

**Zadanie Dodatkowe**

**Zadanie 6** (1 pkt)

Zmodyfikuj klasę Table, tak aby mogła przyjąć dowolny typ porównywalny (np.:Double, Integer, Char, String). Następnie przetestuj tę klasę. 
Wskazówka: poszukaj w internecie hasła: generic methods in java.
