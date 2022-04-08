# Deloppgave 1
### Møtereferater
Møtereferater siden siste innlevering:

**Tilleggsmøte 25. mars 12.15**
Til stede: Hannah, Erik I, Chantal, Alexander, Erik H

Chantal viste Game-Over skjerm. Reflekterte rundt hvordan vi ønsket å arbeide fram mot neste innlevering. Snakket litt om det vi hadde reflektert rundt til innlevering 2. Vi ble enige om å bruke Trello mer aktivt og mer parprogrammering.


**Gruppetime 29. mars 08.15**
Til stede: Hannah, Erik I, Chantal, Alexander

Kartlegger hva vi mangler av MVP-kravene, og hva vi vil implementere til neste innlevering. Vi fordeler oppgaver, og blir enige om å jobbe med disse individuelt fram til neste gruppetime. Chantal skal jobbe med en restart funksjon, Alexander og Erik I skal parprogramere for å prøve å få fiender i spillet og Hannah skal jobbe med en startskjerm. Erik H blir tildelt å begynne å se på implementasjon av power-ups.


**Gruppetime 5. april 08.15**
Til stede: Hannah, Erik I, Alexander, Chantal (discord), Erik H (discord)

Alexander viser fram arbeidet deres med fiender. Erik H viser power-ups. Hannah viser start-skerm. Det som er ferdig blir merget til master. Vi får en muntlig tilbakemelding fra gruppeleder på oblig 2, og fra det forbereder vi oss til neste innlevering. Hannah og Chantal planlegger parprogrammering senere på kvelden for å få start-skjerm og game-over skjerm til å fungere sammen. Vi planlegger et nytt møte 7. april.


**Tilleggsmøte 7. april 12.15** 
Til stede: Hannah, Erik I, Erik H, Chantal (discord)

Erik I presenterer noen tester han har jobbet med. Hannah og Chantal viser hva de har gjort under parprogrammering om hvordan start- og game-over skjerm er integrert sammen. Vi undersøker mulighet for at det blir game-over når Proggy faller utenfor skjermen. Vi fordeler oppgaver knyttet til innleveringen til dagen etter. Chantal hadde noen tanker rundt hvordan Game-over ved Proggy ute av banen som hun skal se på, samt mye grafisk som vi ønsker å få med til innleveringen. Erik I skal se mer på testene og lage klassediagram til koden. Hannah og Erik H skal arbeide med MD-filen. 


### Roller
Rollefordelingen ser slik ut:

**Hannah: Teamlead** - Har det overordnede ansvaret for framgang og koordinering av prosjekt

**Erik H: Nestlead** - Har og et ekstra ansvar for framgang og koordinering av prosjekt, samt sosialt.

**Erik I: IT-ansvarlig** - Har mest ansvar for det tekniske rundt prosjektet. Det dreier seg om det generelle tekniske rundt IDE-ene vi jobber i samt arbeidet i GIT.

**Chantal: Grafisk ansvarlig, Kundeansvarlig** - Har ansvar for det grafiske innenfor spillet når det kommer til bakgrunn og ulike spilleskjermer. Tar i mot beskjeder fra Vetle (Gruppeansvarlig)

**Alexander: Sosialt ansvarlig** - Sørger for at vi som gruppe er så sammensveiset som mulig. 

Generelt for alle er at vi alle bidrar mye i kodingen. Det grafiske arbeidet med Power-ups, fiender og Proggy jobber alle med underveis i Piskel. 

### Prosjektmetodikk og retroperspektiv
Ettersom det er kort tid siden forrige innlevering, vil tankene rundt prosjektmetodikken vår være veldig lik forrige innlevering. 
Prosjektmetodikken vi i utgangspunktet hadde valgt var Kanban, og vi mener dette fortsatt er riktig prosjektmetodikk. Forbedringspotensialene våre fra forrige innlevering gikk på at vi ville bruke Trello mer, og mer parprogrammering.

I denne perioden har vi til tross for kort tid hatt flere parprogrammeringsøkter, og i minste fall konsultert med hverandre når vi har arbeidet alene. Dette har gjort at vi har fått til ekstremt mye på kort tid. Vi har alle fått mye bedre oversikt over koden, som resulterer i at koden blir mer ryddig i videre arbeid også. Vi ønsket også å bruke Trello mer. Til tross for at vi har brukt det mer aktivt, tror vi at vi kan bli enda flinkere på dette området. Ettersom vi har et mye større grunnlag i koden vår nå, har vi muligheten til å jobbe med mange mindre prosjekter simultant. Vi innser derfor viktigheten av et oversiktlig dashboard så man har oversikt over hva andre jobber med, og om det kan skape konflikter ved merging til Git. Derfor er dette noe vi ønsker å fortsette å ta tak i. 

Vi synes at arbeidet med Scrum har vært veldig nyttig denne perioden. I denne perioden har vi hatt mange småprosjekter vi har ønsket å få merget så raskt som mulig. Her og kan vi nok bli enda flinkere til å få ting gjort og pushet det inn i GIT. Dette vil vi jobbe videre med fram mot neste innlevering. 

Vi har derfor to arbeidsområder vi ønsker å arbeide enda mer med fram mot siste innlevering:
- Enda flinkere til å bruke Trello. Ikke bare oppdatere hvilke arbeidsoppgaver som skal gjøres, men og hvem som skal gjøre de. Link til trello [her](https://trello.com/b/Ar2twdkF/inf112)
- Få unnagjort prosjekter enda kjappere så teammedlemmer har enda bedre utgangspunkt å ta tak i. 


### Kommunikasjon og samarbeid
Det er en konsensus blant gruppemedlemmene at vi jobber godt sammen og jevnt. Vi mener alle bidrar bra til teamet på forskjellige måter. Vi har styrker på forskjellige fagområder der noen gruppemedlemmer er svært god på den tekniske kodebiten, mens andre er gode på visuelt grafisk arbeid eller overordnet prosjektgjennomføring og akrivearbeid. Vi prøver likevel å inkludere alle i de ulike oppgavene for å få best mulig utbytte. Gjennom parprogrammering har kodesterke medlemmer viktigheten av flere perspektiver vist seg nyttig til å løse større problemer. Vi slet bl.a mye med en jump-funksjon som vi etterhvert fikk fikset. Gjennom parprogrammering har det ført til forskjeller i antall commits, og den generelle commit-policien blant gruppemedlemmene har vært forskjellig. Mens noen committer større endringer, har andre mange små. Vi har konkludert med at arbeidsmengden på hvert gruppemedlem har vært relativ jevn. 


# Deloppgave 2
### Stretch-goal
Vi har et mål om å kunne spille Proggy Gonzales med to spillere på samme maskin. Når det spilles som multiplayer vil det da være en konkurranse mellom spillerne, der den som kommer fram til mål med nok penger først vinner spillet. Vi ser for oss å dele skjermen vertikalt, og at spillerne spiller på hver sin del av skjermen.

### MVP-krav

1. Vise et spillebrett
2. Vise spiller på spillebrett
3. Flytte spiller (vha taster e.l.)
4. Spiller interagerer med terreng
5. Spiller har poeng og interagerer med poenggjenstander
6. Vise fiender/monstre; de skal interagere med terreng og spiller
7. Spiller kan tape (når tiden går ut)
8. Mål for spillbrett (butikken når spiller har nok penger)
9. Nytt spillbrett når forrige er ferdig
10. Start-skjerm ved oppstart / game over
11. Støtte flere spillere (enten på samme maskin eller over nettverk)

| Brukerhistorier | Akseptansekriterier | Arbeidsoppgaver | MVP-krav |
| --------------- | ------------------- | --------------- | -------- |
| Som spiller er det viktig å ha god oversikt over hvordan man ligger an med tiden slik at man lettere kan nå butikken i tide. | Gitt at spiller har valgt "Play Game" og spillet er startet, så skal tid vises øverst på skjermen i form av nedtelling. | Time-klasse som implementerer actionListener, og en TimerDisplay som viser tiden på skjermen i bestemt skrifttype og skriftstørrelse. | 7
Som spiller trenger jeg å vite/forstå hvordan fiender ser ut slik at jeg kan lettere unngå dem. | Gitt at spiller har valgt "About" på startmenyen, så skal spillregler og historie vises med oversikt over fiender og farer. | Lage en enemy-klasse som ligner litt på player-klassen, og muligens lage et interface de begge kan implementere. Lage en display-klasse for start- og sluttside. | 10, 6
Som spiller ønsker jeg et spillbrett som tydelig viser meg som spiller, samt hvor jeg kan og ikke kan gå slik at jeg lett kan forstå spillet. | Gitt at spiller prøver å bevege seg mot en vegg/plattform, så skal avataren kollidere med veggen og dermed blir stående.  Spiller skal ikke kunne gå, falle eller hoppe gjennom plattformer og vegger. Vedkommende skal også kunne hoppe, gitt at hen står på bakken. | Lage en tile-klasse for hver tile, og en tileLoader-klasse. TileLoader skal hente ut bildene for de ulike tilsene og tegne de på brettet. I tillegg bør vi ha en klasse for kollisjon mellom actors og tiles. | 2, 4
Som spiller har jeg behov for en oversikt over hvor mye penger jeg har samlet inn slik at jeg vet jeg har råd til øl når jeg kommer til butikken. | Gitt at spiller går på en pengegjenstand, så skal den fjernes fra spillbrettet og poengscoren økes. Poengoversikten skal vises tydelig på skjermen. | Kollisjon mellom spiller og penger skal implementeres i collisionCheck, og det skal lages en klasse som holder styr på poengscoren til spiller. | 5
Som spiller trenger jeg at det er tydelig hva som er mål, slik at jeg kan klare å finne fram raskest mulig. | Gitt at spiller har nådd slutten av spillbrettet der butikken befinner seg, så skal butikken/målet vises tydelig og ha et dominerende utseende med god grafikk. | Tegne butikken slik at det står i stil med resten spillet, men samtidig har et dominerende utseende. Gi spiller informasjon om hva som er mål på startsiden. | 8, 10
Som spiller ønsker jeg et spill som er gøy og engasjerende slik at jeg blir motivert til å spille. | Gitt at spillet er velfungerende, så skal det være et mål og en god score-funksjon slik at det er motiverende og gøy å spille. | Lage god grafikk og spennende elementer i spillet, men samtidig ikke for avansert slik at spillet er lett å sette seg inn i. | 8, 5
Som spiller trenger jeg å vite når spillet har startet og når målet er oppnådd / spillet er over slik at jeg videre kan bestemme om jeg vil prøve på nytt eller avslutte spillet. | Gitt at koden kompilerer og kjører, så skal startsiden vises med de ulike valgene, og forsvinne når “Play Game” er valgt. Gitt at spillet har tapt eller vunnet, så skal det vises en skjerm som informerer spiller om resultatene på spillrunden. | Lage en klasse til Game-over og en til start-skjerm. Evt. lage en superklasse disse kan implementere eller utvide. | 10
Som spiller trenger jeg å se meg selv på skjermen hele tiden for å holde oversikt over hvor jeg er i spillverdenen, og vite hvor jeg skal gå videre for å unngå at jeg går feil og taper spillet. | Gitt at spiller beveger seg, så skal skjermen skrolle med spiller slik at spilleren alltid er i sentrum. | Lage variabler for spillerens plassering og for bakgrunnens plassering. Siden spilleren alltid skal vises på midten av skjermen, skal koordinatene til bakgrunnen endres med piltastene og ikke spillerens. | 4, 1
Som spiller vil jeg ha muligheten til å spille mot og med andre slik at det også kan være en sosial aktivitet når man spiller spillet. | Gitt at spillere har valgt å spille som multiplayer på startskjermen, så skal spilleskjermen bli delt i to slik at spillerne kan konkurrere mot hverandre, med hver sin del av skjermen. | Main-metoden må endres slik at den kan tegne to skjermer ved siden av hverandre om multiplayer er valgt. Legge til muligheten til å kjøre to spill samtidig, og lage metoder som bestemmer hvem som er vinner/taper. | 11 

**Prioritert liste over brukerhistorier til andre iterasjon**
- Som spiller trenger jeg å vite/forstå hvordan fiender ser ut slik at jeg kan lettere unngå dem.
- Som spiller trenger jeg å vite når spillet har startet og når målet er oppnådd / spillet er over slik at jeg videre kan bestemme om jeg vil prøve på nytt eller avslutte spillet.
- Som ny og uerfaren spiller ønsker jeg et spill som er enkelt å forstå
- Som spiller ønsker jeg et spill som er gøy og engasjerende slik at jeg blir motivert til å spille.

**Liste over brukerhistorier prioritert videre**
- Som spiller trenger jeg å vite/forstå hvordan fiender ser ut slik at jeg kan lettere unngå dem.
- Som spiller trenger jeg at det er tydelig hva som er mål, slik at jeg kan klare å finne fram raskest mulig.
- Som spiller ønsker jeg et spill som er gøy og engasjerende slik at jeg blir motivert til å spille.
- Som spiller vil jeg ha muligheten til å spille mot og med andre slik at det også kan være en sosial aktivitet når man spiller spillet.



**MVP-krav oppfylt** 

MVP-kravene vi har fokusert på siden forrige innlevering er krav 6, 7, 9 og 10. Siden forrige innlevering har vi sett at det bare har blitt lettere å legge til funksjoner i spillet, da vi har klart å lage en god grunnmur for nye implementeringer. Vi har klart å legge til fiender i spillet, og at poengscoren minker når spiller går på dem. Vi jobber nå med å få fiendene til å kunne bevege seg på spillbrettet. Siden sist har vi også laget en startskjerm som er det første man blir møtt med når man kjører spillet. Foreløpig har vi valgene “Play Game” som starter spillet, “About” som gir en oversikt over spilleregler og mål, “Controlls” som viser hvordan man skal spille, og “Quit” som avslutter spillet. Vi har også forbedret vår gameover-skjerm slik at man får valget mellom å prøve på nytt eller gå tilbake til startmenyen.  



**MVP-krav prioritert videre**

Videre vil vi jobbe mot å oppfylle krav 6 ved å få fiendene til å interagere mer med terrenget og kunne gå rundt på brettet. Vi planlegger også å lage det endelige spillbrettet med fjell i bakgrunn og butikken som mål så fort som mulig. Det som gjenstår etter det er å implementere power-ups slik at de fungerer som de skal. Etter vi har fått til dette har vi et MVP-spill, noe vi er veldig fornøyd med. Det som da er igjen blir å rydde opp i koden vår slik at den blir enklere å forstå, og å jobbe mot å nå våre stretch-goals.

# Deloppgave 3

**Klassediagram er lagt til i mappen Bilder under Deliverables**
