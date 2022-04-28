<h1 align="center">
  <a href="https://git.app.uib.no/Erik.Ingebrigtsen/inf112.proggy-gonzales">
    Proggy Gonzales
  </a>
</h1>

<p align="center">
  <strong>Et 2D-spill utviklet av Hannah Mørken, Erik Ingebrigtsen, Alexander Smith, Chantal Bakar og Erik Harto</strong><br>
</p>

# Proggy Gonzales


Trello: https://trello.com/b/Ar2twdkF/inf112

## Innholdsfortegnelse
-   [Introduksjon](#introduksjon)
-   [Aspekter](#aspekter)
-   [Oppsett](#oppsett)
-   [Teste Program](#teste)


## Introduksjon
Proggy Gonzales er kjent som den beste programmeringsstudenten UiB har sett, og ryktene sier han programmerer raskere enn sin egen skygge. Han har lest hardt i hele år så eksamenen i dag gikk knirkefritt. På vei ut av realfagsbygget går det opp for han: Klokka er 19.57 og han har ikke kjøpt drikke enda?? Han innser og at han ikke har noen penger etter en veldedighetsauksjon tidligere i semesteret hvor han klarte å legge alle sparepengene sine på bordet for å sikre seg et dansekurs med Frank Løke. De månedlige avdrag til Unicef, Redd Barna og Leger uten Grenser hjelper heller ikke på kontobalansen. Proggy skjønner derfor at han må løpe Bergen rundt for å lete etter penger, og rekke en butikk før ølsalget stenger kl 20.00. Unicef-arbeidere prøver å stoppe han og gir seg ikke uansett hvor hardt han sier at han allerede er fadder. Samvittigheten hans tåler heller ikke å gå forbi en hjemløs uten å avse en slant. Hjelp Proggy fortjent feire et tungt semester!

### Aspekter
- Scrolles horisontalt 
- power-ups 
    * Gullsko gjør han raskere
    * VOI gjør han raskere men koster 5kr fastpris + 1kr per sekund
    * Munnbind gjør han usynlig fra fiender
- Fiender
    * Unicef-ververe tar konstant penger mens han er i nærheten av de
    * Hjemløse donerer han 15 kr til per hjemløs han møter på (Kun én gang per hjemløs)
- Hindere
    * Vann - Spiller taper dersom han faller i vannet
- Objektiv
    * Samle penger - 20kr eller 10kr per lapp
    * Være rask - maks 3 minutter. Scoren øker dersom man er raskere enn 3 minutter
    * Score = Antall coins + antall sekunder igjen på timer


## Oppsett
For å kjøre programmet må du gjøre følgende: 

1. Last ned en IDE (Integrated development environment)
    * Spillet kjøres via en IDE, og du må derfor laste ned en. Vi anbefaler Eclipse eller IntelliJ. 
2. Klon prosjektet 
    * Prosjektet clones fra dette git-repositoryet med en SSH- eller HTTPS-nøkkel, og importeres via maven inn i den valgte IDE-en. 
3. Kjør programmet i din IDE. 
    * For å starte spillet må man kjøre main.java, som ligger i src/main/java/core. For å kjøre main-klassen må man høyreklikke på filen og trykke på run.
Skulle det oppstå problemer kan det hjelpe å legge til resource mappen som en source folder, hvis den ikke allerede er gjenkjent som en source.

## Teste
For å teste at koden kjører som den skal må du gjøre følgende:


