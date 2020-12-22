# Mobilny vCard PŁ
Usługa generuje stronę html działającą na zasadzie wyszukiwarki [Panoramy firm](https://panoramafirm.pl/szukaj).

## Poprawny sposób użycia
### Zapytanie:


```
http://localhost:8080
```

### Odpowiedź:

##### Strona z wyszukiwarką, do której należy wpisać frazę i kliknąć przycisk szukaj, aby znaleźć odpowiadające pozycje. 

### Zapytanie:

```
http://localhost:8080/cards?phrase=hydraulik
```

### Odpowiedź:

##### Strona, która wyświetla wszystkie pozycje pasujące do frazy podanej we wcześniej wymienionym endpoincie. 
##### Dla frazy hydraulik wyświetlone zostaną : nazwa firmy, adres, telefon, email, link do mapy google z lokalizacją oraz adres strony www dla wszystkich pozycji, które zostały wyszukane.
