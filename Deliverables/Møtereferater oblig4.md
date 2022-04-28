## Fredag 15. April 11.30
#### Til stede: Alle
Agenda: 
- Reflektere rundt hva som gikk bra sist og hva som kan forbedres med tanke på prosjektmetodikk
- Presentere endringer vi har gjort i koden siden siste møte før forrige innlevering.
- Summere opp hvilke krav vi har fullført og hva vi ønsker å få til inn mot siste innlevering
- Fordele arbeid fram mot neste møte

Refleksjon:
Vi har et ønske om å bruke Trello mer aktivt i denne perioden. Grunnlaget vårt fram mot neste release er at de fleste store arbeidsoppgavene er unnagjort, og fram mot neste innlevering er det mange mindre forbedringer vi ønsker å få gjennomført. På de store oppgavene som Power-ups, Fiender og Multiplayer regner vi med at vi må ha rene parprogrammeringsøkter. Vi har derimot veldig mange små forbedringer vi ønsker å gjøre, og ser ikke på det som tidsbesparende å gjøre mye individuelt på de mindre oppgavene.

Siden sist har Erik I har lagt til lydeffekter som kan brukes senere.
Til neste gang skal Erik H skal fikse grafikk rundt power up og skal parprogrammere med Chantal for å fikse at power up varer i 10 sekunder ettersom Chantal har best kunnskap rundt timer. Chantal skal fikse game over dersom proggy faller utenfor map. Alexander jobber med å få fiender til å bevege på seg. Hannah skal starte å se på multiplayer. 
Vi blir enige om at alle skal lage et forslag til en liten del av mappet.

Arbeidsoppgavene fram mot neste innlevering ble lagt inn i Trello, og det skal oppdateres fortløpende gjennom perioden. Stretch goal er å implementere multiplayer.

------

## Tirsdag 19. April 08.15
#### Til stede: Alle
Agenda: 
- Gå gjennom det som er gjort siden sist
- Fordele arbeidsoppgaver videre
- Undersøke hvordan interaktive fiender skal implementers
- Liten refleksjon om digitale møter

Chantal og Erik H viste at Power up blir deaktivert etter 10 sekunder. Hannah har laget en abstrakt klasse for GameState. Alle viste sitt forslag til map. Til neste gang skal Chantal jobbe mer med grafikk og med meny. Vi har gitt litt tilbakemeldinger til mappene som alle skal fikse på til neste gang. Alexander skal begynne å se på muligheten til å få fiender til å bevege seg. Vi idémyldret og mente det beste vil være å lage en ny klasse som ligner på Player.

Vi har nå hatt flere møter der alle har vært på forskjellige steder og tenker at det har fungert til en viss grad. En ulempe vi har lagt spesielt merke til er at for noen oppgaver kan det være nyttig at beskjeder kommer hurtig. Dette kan skape forvirring og større grad av avbrytelser dersom flere prater samtidig på discord, og man ikke kan se kroppspråket til hverandre like godt. Vi velger derfor å vente med å sette sammen mappet til vi kan møtes fysisk igjen da vi anser dette som en oppgave der mange har innvendinger.

-----

## Torsdag 21. April 14.30 Fysisk
#### Til stede: Alle
Agenda: 
- Vise fram ting siden sist
- Sette sammen map
- Fordele videre arbeidsoppgaver

Chantal viste at hun har fikset så vi kan velge mellom flere maps i spillet der vi kan legge easy, medium og hard. Hun har og fikset forskjellig språk til spillet, lagt til grafikk og laget WIN-SCREEN som aktiveres ved å gå over en pils på slutten av mappet med mer enn 100 coins. Hannah har laget infoskjerm. Erik I viser lydeffekter til alt mulig i spillet. I dette møtet setter vi sammen to maps til medium og to til hard, samt lager et nytt map til easy. Vi diskuterte om vi skulle ha vann/lava/åpent hull på stedene Proggy må hoppe. Vi endte opp med vann. Erik H har laget ny tile for det, og Chantal skal til neste gang implementere at det gjør at Proggy dør og må starte på nytt. Hannah skal begynne å se på muligheten for Multiplayer. Erik I skal prøve å få til Highscore. Alexander har fått fiender til å bevege seg, og skal jobbe med å få de til å oppleve tyngdekraft.

----

## Søndag 24. April 14.00 - 18.00
#### Til stede: Alle
Agenda:	
- Diskutere hva vi ønsker å prioritere til den siste uken
- Jobbe med multiplayer
- Jobbe med fiender som beveger seg
- Jobbe med Highscore
- Starte på innleveringen
- Integrere kode vi har jobbet med på egenhånd.

I denne arbeidssesjonen har vi oppdatert Trello for å sette prioriteringene for siste uken med arbeid. Det har vært en mulighet for alle som jobber med individuelle arbeidsoppgaver til å lufte diverse problemer og få innspill fra hele resten av gruppen. 

Erik I har fått highscore til å fungere på mac, men ikke windows. Fiendeklassen begynner å komme seg, men det er problemer knyttet til kollisjon mellom Proggy og fiende, og hvordan det oppdaterer scoren. Vi diskuterte ulike grunner til hvorfor problemene oppstår, og Alexander finner ut at det er knyttet til plasseringen inn i tilen fiendene står på og størrelsen eller størrelsen deres som gjør det. Han skal jobbe videre med dette. Vi diskuterte og hvordan løse multiplayer på best mulig måte, og fant ut at vi velger å ikke splitte skjermen på midten. Siste uken tenker vi å kjøre en sprint mellom hvert møte der vi fordeler en oppnåelig oppgave til hver og forventer at den skal være klar til neste møte. Erik H skal begynne på innleveringsteksten. Erik I skal fortsette å jobbe med Highscore database. Chantal skal lage grafikken som trengs til bakgrunn av map. Hannah skal fortsette videre på arbeidet med multiplayer med mål om at det skal være mulig med to personer på et lag.

-----

## Tirsdag 26. April 08.15-10.00
#### Til stede: Alle
- Oppdatere hverandre på hvordan vi ligger an med arveidsoppgavene
- Vise det vi har gjort siden sist
- Liste opp gjenværende oppgaver i Trello og fordele de

Alexander har fått til interraktive fiender (UNICEF-ververe). Hannah er nesten i mål med multiplayer. Chantal har fikset små bugs knyttet til timer og pauseskjerm. Til neste gang skal Erik H gjøre det mulig å hente inn navn til spiller, og skal sammen med Erik I sørge for at Highscore blir oppdatert med riktig navn og score. Chantal skal ferdigstille bakgrunn. Hannah skal ferdigstille multiplayer. Alexander skal skrive tester tilknyttet fiender.


-----

## Torsdag 28. April 12.30-15.00
#### Til stede: Alle
Agenda:	
- Vise ting siden sist
- Få oversikt over hva vi mangler
- Finne ut hvilke bugs vi har og fokusere på det

Chantal viser bakgrunnen til mapsene. Hannah er snart klar til å merge multiplayer. Highscore databasen har noen bugs som må fikses. Alexander har laget et par tester til fiender. Vi ser på Trello at alle arbeidsoppgavene er fordelt. Vi sitter noen timer og jobber sammen for å kunne søke hjelp av hverandre. 

--- 




