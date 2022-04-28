# Oblig 4

## Proggy Gonzales
Proggy Gonzales er et 2D-spill der objektet er å samle så mye som mulig penger på veien til butikken, og rekke stengetid.

### Team og Prosjekt
Gjennom prosjektet har vi evaluert om vi ønsket å beholde rollene vi tilegnet i starten. Disse rollene har fungert \
svært godt og vi har endret lite på de. Det var derimot vanskelig i starten å vite hvilke områder vi trengte at medlemmer \
skulle ha ansvar for. Vi fant ut tidlig at vi ønsket et estetisk fint produkt med tanke på grafikk og visualiseringer, og \
Chantal tok derfor ekstra ansvar for dette. Generelt for semesteret er at alle har hatt tunge kodeoppgaver, men at rollene \
har spesifisert et ekstra ansvar utover kodearbeidet. Vi har hatt en flat struktur i teamet der beslutninger tas med konsensus,\ 
og Hannah og Erik H sine roller som Teamlead og nestlead har i størst grad gått i å følge ekstra opp på krav til \
oppgaven og sørget for at disse ble gjennomført.

#### Team roller
##### Hannah Mørken
Rolle: Teamlead \
Hovedoppgave: Hannah skal sørge for at tidsfrister blir overholdt og inkludere alle når \
beslutninger skal tas. Hun skal sammen med Erik H ha et ekstra ansvar for å oppdatere Trello.


##### Erik Harto
Rolle: Team nestlead \
Hovedoppgave: Sammen med Hannah sørge for at progresjonen til prosjektet \ 
følger planen, og at prosjektet møter kravene oppgaven krever.


##### Erik Gunnaleite Ingebrigtsen  
Rolle: Teknisk ansvarlig \
Hovedoppgave: Erik I har et ekstra ansvar for å sørge for at koden alltid kan kjøres, samt være en \
støttespiller når andre lurer på noe knyttet til GIT eller andre programmer vi benytter.


##### Chantal H. Bakar
Rolle: Grafisk ansvarlig og Kundekontakt
Hovedoppgave: Chantal har et ekstra ansvar for å gjøre spillet så estetisk vakkert som mulig. Det innebærer å lage bakgrunner og menyer \
Hun skal og delegere arbeid knyttet til dette videre. Hun skal og ta i mot tilbakemeldinger fra kunden slik at vi kan bruke det til å \
forbedre produktet.


##### Alexander Klemeyer Smith
Rolle: Kommunikasjonsansvarlig \
Hovedoppgave: Alexander skal passe på at teamet ikke går i klassiske feller som å bli konforme. Han har et ekstra ansvar med å utfordre \
hvordan vi tenker og derfor sørge for at vi ikke er enige fordi vi ikke tør å si i mot gruppen. Han skal og sørge for at alle føler seg \
verdsatt i teamet og blir hørt på innspillene de kommer med.

#### Prosjektmetodikk
Vi har hatt lite endring på prosjektmetodikken vår gjennom semesteret, men vi har etter hver innlevering \
evaluert om det vi har brukt fram til da er riktig for oss. Oppsummert har vi ønsket den kontinuerlige \
progresjonen som Kanban tilbyr, men vi var og motivert for å ha et bedre produkt å vise til for hver innlevering \
og har dermed i tråd med Scrum kjørt kortere sprinter for å kunne levere mest mulig til kunden. 


Ting vi gjør som tyder på Scrum:
Jobber relativt i sprints med tanke på obliger
Bruker tid på å planlegge fram mot neste innlevering og se i retroperspektiv på hva som gikk galt. 
Releaser hver sprint

Ting vi gjør som tyder på Kanban
Er fleksible med tanke på arbeidsmengde fram mot hver innlevering. Dersom noe har stanget har vi brukt mye tid på det for å gjøre det ordentlig i stedet for å rushe. Har ikke hatt et fastsatt mål etter hver innlevering om hva vi skal ha klart til neste innlevering. 
Skal releaser mye oftere, vi pusher mye til master, men vi releaser ikke til en kunde.

Key points:
Ikke ha alt for mye oppgaver i prosess samtidig. Det gjør at man i større grad kan samarbeide om komplekse oppgaver. 
Prate om hvordan en sprint har gått og planlegg neste bedre.
- Vi tok ting litt på sparket, og dersom vi ikke fikk til noe var det ikke krise. Vi ble ikke stresset av at noen ting kunne ta mye tid 

Scrum:
- Releaser hver sprint
- Relativt lite på project boardet. Hver utvikler jobber som regel med veldig få oppgaver av gangen

Kanban:
- Skal release mye oftere, vi pusher mye til master, men vi releaser ikke til en kunde.
- Har mye på project boardet. Hver utvikler jobber med mye av gangen. Her er det ofte mange blokkerte kort (ting som må vente på at andre oppgaver skal bli ferdige først.)

Our project methodology has been the same throughout the project, with little changes.\
We feel that we chose correct early on and did quick revisions of our methodology when needed.\
To summarize how our methodology have evolved; Firstly we started out with Scrum and XP,\
doing 1 week sprint intervals of what we had on our project board. From that we noticed a\
need of a quick revision cycle, such that we could easily identify new needs the customer had, or problems.\
Secondly we made the sprints into 3/4 days cycles. Such that we had a much more even feedback loop.\
This corresponded well with the meetings we set up, and we personally feel that we got a good development structure.

#### Retrospection
Vi har vært flinke til å se bakover på en sprint og reflektere rundt hva vi kunne gjort bedre, men vi kunne vært mye \
flinkere til å sette klare mål for hva vi ønsker å få til før neste sprint. 





#### Grafikk



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
Som spiller ønsker jeg å ha hjelpemidler/power-ups i spillet slik at de kan hjelpe meg å nå mål på tross av fiender og tid. | Gitt at spiller ikke allerede bruker en power up, så skal spiller kunne plukke opp en power-up og bruke den i 10 sekunder. Gitt at spiller bruker munnbind, så skal han ikke miste penger når han møter på en fiende. Gitt at spiller bruker voi eller gullsko, så skal han gå i en raskere hastighet. | Lage metoder for å plukke opp og hva som skal skje når power-ups blir plukket opp i collisionCheck. Spiller skal ha ulike tilstander som sier noe om hvilken power-up som er i bruk. | 5, 6
Som spiller ønsker jeg et spillbrett som tydelig viser meg som spiller, samt hvor jeg kan og ikke kan gå slik at jeg lett kan forstå spillet. | Gitt at spiller prøver å bevege seg mot en vegg/plattform, så skal avataren kollidere med veggen og dermed blir stående.  Spiller skal ikke kunne gå, falle eller hoppe gjennom plattformer og vegger. Vedkommende skal også kunne hoppe, gitt at hen står på bakken. | Lage en tile-klasse for hver tile, og en tileLoader-klasse. TileLoader skal hente ut bildene for de ulike tilsene og tegne de på brettet. I tillegg bør vi ha en klasse for kollisjon mellom actors og tiles. | 2, 4
Som spiller har jeg behov for en oversikt over hvor mye penger jeg har samlet inn slik at jeg vet jeg har råd til øl når jeg kommer til butikken. | Gitt at spiller går på en pengegjenstand, så skal den fjernes fra spillbrettet og poengscoren økes. Poengoversikten skal vises tydelig på skjermen. | Kollisjon mellom spiller og penger skal implementeres i collisionCheck, og det skal lages en klasse som holder styr på poengscoren til spiller. | 5
Som spiller trenger jeg at det er tydelig hva som er mål, slik at jeg kan klare å finne fram raskest mulig. | Gitt at spiller har nådd slutten av spillbrettet der butikken befinner seg, så skal butikken/målet vises tydelig og ha et dominerende utseende med god grafikk. | Tegne butikken slik at det står i stil med resten spillet, men samtidig har et dominerende utseende. Gi spiller informasjon om hva som er mål på startsiden. | 8, 10
Som spiller ønsker jeg et spill som er gøy og engasjerende slik at jeg blir motivert til å spille. | Gitt at spillet er velfungerende, så skal det være et mål og en god score-funksjon slik at det er motiverende og gøy å spille. | Lage god grafikk og spennende elementer i spillet, men samtidig ikke for avansert slik at spillet er lett å sette seg inn i. | 8, 5
Som spiller trenger jeg å vite når spillet har startet og når målet er oppnådd / spillet er over slik at jeg videre kan bestemme om jeg vil prøve på nytt eller avslutte spillet. | Gitt at koden kompilerer og kjører, så skal startsiden vises med de ulike valgene, og forsvinne når “Play Game” er valgt. Gitt at spillet har tapt eller vunnet, så skal det vises en skjerm som informerer spiller om resultatene på spillrunden. | Lage en klasse til Game-over og en til start-skjerm. Evt. lage en superklasse disse kan implementere eller utvide. | 10
Som spiller trenger jeg å se meg selv på skjermen hele tiden for å holde oversikt over hvor jeg er i spillverdenen, og vite hvor jeg skal gå videre for å unngå at jeg går feil og taper spillet. | Gitt at spiller beveger seg, så skal skjermen skrolle med spiller slik at spilleren alltid er i sentrum. | Lage variabler for spillerens plassering og for bakgrunnens plassering. Siden spilleren alltid skal vises på midten av skjermen, skal koordinatene til bakgrunnen endres med piltastene og ikke spillerens. | 4, 1
Som spiller vil jeg ha muligheten til å spille mot og med andre slik at det også kan være en sosial aktivitet når man spiller spillet. | Gitt at spillere har valgt å spille som multiplayer på startskjermen, så skal spilleskjermen bli delt i to slik at spillerne kan konkurrere mot hverandre, med hver sin del av skjermen. | Main-metoden må endres slik at den kan tegne to skjermer ved siden av hverandre om multiplayer er valgt. Legge til muligheten til å kjøre to spill samtidig, og lage metoder som bestemmer hvem som er vinner/taper. | 11 

**Prioritert liste over brukerhistorier til siste iterasjon**
- Som spiller vil jeg ha muligheten til å spille mot og med andre slik at det også kan være en sosial aktivitet når man spiller spillet.
- Som spiller ønsker jeg å ha hjelpemidler/power-ups i spillet slik at de kan hjelpe meg å nå mål på tross av fiender og tid.
- Som spiller trenger jeg å vite/forstå hvordan fiender ser ut slik at jeg kan lettere unngå dem.
- Som spiller trenger jeg å vite når spillet har startet og når målet er oppnådd / spillet er over slik at jeg videre kan bestemme om jeg vil prøve på nytt eller avslutte spillet.
- Som ny og uerfaren spiller ønsker jeg et spill som er enkelt å forstå
- Som spiller ønsker jeg et spill som er gøy og engasjerende slik at jeg blir motivert til å spille.

**MVP-krav oppfylt** 

Det vi har fokusert mest på siden forrige innleveringen er å gjøre det mulig å spille med to spillere, få fiendene til å bevege seg og interagere med terrenget, å få power-ups til å fungere som de skal og å lage en highscore-side som oppdateres hver gang man fullfører et level. Vi var litt usikre på hvordan vi ville at spillet skulle fungere med to spillere. Vi ble fort enige om at det skulle støtte to spillere på samme maskin. Det var to ideer vi sto mellom: 

- Når multiplayer blir valgt vil skjermen bli delt i to, og man spiller på hver sin del. Det vil da være en konkuranse mellom de to spillerene, og den som fullfører først, vinner.
- Når multiplayer blir valgt vil det bli opprettet en til spiller i samme spillverden. Disse to spillerne skal da samarbeide om å klare levelet.

Begge ideene hadde utfordringer og problemstillinger som måtte løses. Det var vanskelig å få skjermen til å deles i to, og få to spill til å bli opprettet siden alt fra start til slutt (språk-meny til highscore-side) skjer i samme klasse. Med to spillere i samme verden ble spørmålet om hvilken spiller skjermen skal følge en vanskeilg problemstilling. Etter litt fram og tilbake endte vi med å ha to spillere i samme verden der skjermen følger spiller 1. 

Å få fiendene til å bevege seg og interagere med terrenget var også en utfordring. For å få skjermen til å følge spilleren har vi gjort det slik at spilleren alltid blir tegnet på samme koordinater, og at bakgrunnen beveger seg basert på tast-inputet fra brukeren. Dette gjorde det å få fiendene til å bevege seg fritt, uavhengig av spiller og med bakgrunnen, litt utfordrene. Power-upsene var noe enklere å implementere da de ble lagt til som tiles. Vi brukte collisionCheck til å holde styr på om spiller kolliderte med gjenstandene, og fra det hvilken tilstand spiller skulle være i. Å ha en highscore-side var en av våre stretch-goals, så vi er veldig fornøyd med at vi fikk til dette. Vi valgte å lage tre databaser som holder på highsocrene fra hver av nivåene. Databasene er txt-filer som blir skrevet om hver gang noen fullfører et level, om man får en poengscore som er blant topp fem. 

Det var også flere mindre detaljer som måtte forbedres i spillet, før vi var klare til å si oss ferdige. Vi la blant annet til mye grafikk og flere valgt på menyen for å gjøre spillet enda mer intuitivt og estetisk. Vi lagde også tre spillbrett i tre ulike vanskelighetsgrader. 


