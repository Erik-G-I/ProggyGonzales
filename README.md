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
**Manuelle Tester**

Teste at spillet kan spilles, tid og penger vises når spillet er i gang:
1. Åpne prosjektet i foretrukket IDE
2. Naviger deg til src/main/java/core. Her ligger main-klassen vår.
3. Høyreklikk på klassen, og velg "run Main.main()", koden skal da begynne å kjøre og du vil få en språkmeny på skjermen din.
4. Velg et av språkene ved å trykke enter. Du vil da komme til spillets meny.
5. Velg "Start spillet"/"Play game" ved å trykke enter for å starte spillet. Du vil da få et valg mellom å spille med en eller to spillere.
6. Velg enten en eller to spiller, avhengig av hvor mange som skal spille, ved å trykke enter. Du vil da få et valg mellom tre nivåer å spille, lett, middels og vanskelig. 
7. Velg det nivået du vil spille ved å trykke enter. Du vil først se en animasjon av Proggy som går ut av realfagsbygget.
8. Trykk enter eller vent til animasjonen er over for å starte spillet. Spillet er da i gang, og du skal kunne se deg selv, en oversikt over penger samlet inn som viser 0, og en tid som teller ned fra 2:59. 

Teste at game-over-skjerm vises når tiden er ute
1. La tiden renne ut etter at spillet er i gang. Det vil da dukke opp en skjerm som viser "Game Over", og du vil få et valg mellom å prøve på nytt eller gå tilbake til menyen.

Teste at spillet startes på nytt når "yes"/"ja" er valgt på game-over-skjerm:
1. Velg "yes"/"ja" etter at du har tapt spillet og er på game-over-skjermen. Spillet skal da starte på nytt, og spiller skal vises på sin startposisjon igjen.

Teste at meny blir vist når "no"/"nei" er valgt på game-over-skjerm:
1. Velg "nei"/"no" etter at du har tapt spillet og er på game-over-skjermen. Menyen skal da dukke opp på skjermen.

Vi har manuelt testet at grafikken vises korrekt og at alle UI-elementene vises der de skal, vi har også prøvet oss frem til en hoppmetode som føles naturlig og god å spille med.

De automatiske testene dekker de aller mest elementære funksjonene.
Vi har selv testet hele spillet manuelt for bugs, og for funksjoner som ikke like lett kan testes automatisk.

**Automatiske tester**

For å teste at koden kjører som den skal må du gjøre følgende:

1. Åpne prosjektet i foretrukket IDE
2. Naviger deg til src/test. Her ligger alle testene fordelt i **_3_** directories og totalt **_8_** klasser

De automatiske testene dekker:
- Enemy kan:
	* falle
	* bevege seg
	* ikke gå gjennom tiles
- Player 1 og player 2 kan:
	* plukke opp powerups
	* plukke opp penger
	* miste penger
	* bevege seg
	* hoppe
- TileLoader kan:
	* laste inn et map
	* tile har kollisjon
- Score kan:
	* øke/minke	
- GameOver vises når spiller faller i vannet



