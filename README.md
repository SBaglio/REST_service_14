# Consegna Servizio REST del Progetto di Introduzione alla Programmazione per il Web

## REST-like service Programmi

Si implementi un servizio REST like **Programmi** che permetta la gestione dei programmi di allenamento.

---

## Endpoint

Il servizio ha tre endpoint che permettono di:

1. Ottenere la lista dei programmi di allenamento predefiniti. I nomi dei programmi predefiniti sono:
   - Full Body
   - Push/Pull/Legs
   - Cardio
   - Strength
2. Ottenere, dato come parametro il programma di allenamento (e.g. `Cardio`), la composizione del programma. Ogni programma è composto da: `nome_esercizio`, `numero_serie`, `numero_ripetizioni`, `kcal`.
3. Ottenere, data un nuovo programma di allenamento, il numero di kcal associate al programma

---

## Database

Il servizio ha associato un database **`programmiDB`** che contiene la lista dei programmi e le loro informazioni dettagliate.
