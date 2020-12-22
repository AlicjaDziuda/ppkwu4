# Mobilny vCard PŁ
Usługa generuje stronę html działającą na zasadzie wyszukiwarki [Panoramy firm](https://panoramafirm.pl/szukaj).

## Poprawny sposób użycia został przedstawiony w kilku krokach:
### Zapytanie numer 1 (wyszukiwarka):


```
http://localhost:8080
```

### Odpowiedź:

##### Strona z wyszukiwarką, do której należy wpisać frazę i kliknąć przycisk szukaj, aby znaleźć odpowiadające pozycje. 

## 
### Zapytanie numer 2 (strona z wyszukanymi wynikami):

```
http://localhost:8080/cards?phrase=hydraulik
```

### Odpowiedź:

##### Strona, która wyświetla wszystkie pozycje pasujące do frazy podanej we wcześniej wymienionym endpoincie oraz powiązane z nimi dane. 
##### Przykładowo dla frazy hydraulik wyświetlone zostaną : 
* ###### nazwa firmy
* ###### adres
* ###### telefon 
* ###### email
* ###### adres WWW strony internetowej
* ###### link do mapy google z lokalizacją
* ###### przycisk do generowanie wizytówki vCard
##### dla każdej wyszukanej pozycji zgodnej z wcześniej podaną frazą.
#### Dodatkowo na dole każdej strony widnieje przycisk "Dalej", który pozwala na przeglądanie dalszych wyników. Jest to pewnego rodzaju paginator.

### Uwaga:
#### Wszystkie wyszukane wyniki zostają zapisane do Listy. W momencie zapisywania danego wyniku do Listy, zostaje wygenerowane unikalne id, przechowywane jako String, które posłuży w dalszych etapach do identyfikowania danego wpisu. 

##

### Zapytanie numer 3 (paginator):

```
http://localhost:8080/search/next
```
### Odpowiedź:

##### Strona, która realizuje analogiczne zadania jak poprzednie zapytanie, tylko dla kolejnych podstron, dzięki czemu zostaje odwzorowana paginacja z rodzimego portalu Panorama Firm.

##

### Zapytanie numer 4 (generowanie plików vCard):

```
http://localhost:8080/vcard/{result}
```
#### np.:

```
http://localhost:8080/vcard/1
```
##### gdzie 1 zapisane w postaci Stringa oznacza unikalne id po którym zostaje zindetyfikowany wynik, dla którego ma powstać vCard. 
### Odpowiedź:

##### Plik w formacie vCard, dla określonego za pomocą id wyniku wyszukanego w poprzednich zapytaniach.
