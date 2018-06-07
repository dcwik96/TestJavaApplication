# Testowanie aplikacji JAVA 2017-2018
## Laboratorium 11 (Model PageObject i PageFactory w SeleniumWebDriver)

-------------------------------------------

Wszystkie zadania mają być zapisane w **tym samym** utworzonym projekcie MAVEN!!!

-------------------------------------------

**Zadanie 1** (0.25 pkt)

Zmodyfikować przykładowy projekt, pozbywając się linii **Thread.sleep(1000)** tak, aby testy zakończyły się powodzeniem.

-------------------------------------------

**Zadanie 2** (0.5 pkt) 

Przetestuj dowolną stronę, która zawiera panel logowania. Wykorzystaj model **PageObject**. 

--------------------------------------------

**Zadanie 3** (0.75 pkt)

Bardzo częstym polem występującym na stronach internetowych jest pole wyszukiwania tekstu (**search**). Znajdź co najmniej dwie strony, które będa zawierać te same nazwy (w sensie kodu źródłowego strony), pól wyszukiwania, a następnie wykorzystując model **PageObject** oraz **PageFactory** przetestuj te strony. Testy powinny korzystać z jednej wspólnej klasy (w której powinno znaleźć się odwołania do pola wyszukiwania tekstu). 

-------------------------------------------

**Zadanie 4** (0.5 pkt)

Oprócz metody **FindElement(By ...)** istnieje metoda **FindElements**, która zwraca listę typu WebElement. Przykład użycia tej funkcji wygląda następująco: 

```
@Test
public void testFindElements(){
    List<WebElement> listElements = driver.findElements(By.tagName(”a”));
    System.out.println(”Liczba linkow: ” + listElements.size());
    for(int i=0; i<listElements.size(); i++){
      System.out.println(listElements.get(i).getText());
      System.out.println();
    }
}
```

Wykorzystując metodę **FindElements** wykonaj następujące polecenia: 

- (0.25 pkt) Wchodząc na dowolny formularz wypisz ilość jego pól tekstowych, pól typu select lub checkbox (jeśli takie są).
- (0.15 pkt) Przechwyć wszystkie linki dowolnej strony oraz przejdź do każdego z nich.
- (0.1 pkt) Wchodząc na stronę google.pl przechwyć wszystkie linki, a następnie przejdź wyłącznie do tych, które zawierają słowo **google** (zawierają to słowo w adresie linku).

**Wskazówka:** Wykorzsytaj następujące metody: getAttribute(), getText(), contains(), get().

-------------------------------------------

**Zadanie DODATKOWE** (0.5 pkt)

Selenium WebDriver posiada w sobie funkcje **navigate().refresh()**, która odpowiedzialna jest za odświeżanie strony internetowej. Znajdź i podaj 5 innych metod w selenium, które mogą zrobić to samo. Zapisz je w pliku **Zad5.txt**.

