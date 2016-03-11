Ide listázom a még megvizsgálandó játékelemeket, amiket át kell gondolni az új modell függvényében.

Creation:
 - Main létrejön létrehozza levelt.
 - Level meghívja bizonyos Floor objektumok függvényét ami létrehozza ONeill-t és a dobozokat. Floor ismeri őket csak szólni kell neki, hogy hozza őket létre. (jobb mintha Level ismerné még ONeillt és Box-it)
 - Level betölti a pályát. Létrehozza a kapcsolatokat az elemek között.
 - Innentől bemenetre várunk.

Movement: (ONeil, Missile mozgása)
 - User input/Timer trigger
 - ONeil/Missile megkérdezi az alatta lévő Floor példányt, hogy ki a xy szomszéd.
 - A szomszédra ráhív egy moovable() függvényt és csekkolja odamehet e.
 - Ha igen akkor beállítja az aktuális Floor példányának az ONeill/Missile referenciáját Null-ra és utána átadja magát a következő Floor típúsú objektumnak akit már korábban lekérdezett.
 - Lépés megtörtént.
 - Ha moovalbe() false-al tér vissza nem történik semmit, ONeill/Missile marad ahol van.

Box situations: (Doboz felvétele, elengedése)

Missile: (Amikor a Missile falt ér)

Portal: (Portálon való áthaladás, portál check, wall check)
 - Áthaladás:
  + Amikor falat ér a Missile és tehető oda portál
  + PortalWall példány létrehozza az ő Portalját a Missile-tól kapott információk alapján.
  + Ha ezáltal 2 Portál van a Levelen(tudjuk a statikus változók miatt) létrejöhet a kapcsolat.
  + A Missile információk felhasználásával előkaparja az előtte lévő Floor példányt. (ismeri a környezetében lévő LevelEntityket)
  + Beállítja a Portal előtti Floor példány ő rá mutató referenciáját a másik Portál előtti Floor példányra.
  + Ha jön ONeil/Missile nem vesznek észre semmit. Annyit érzékelnek, hogy simán haladtak előre pedig a teleportálás megtörtént.

Chasm: (Bringing death to the weak ones)

Opener Door connection: (ajtó nyitás csukás)

ZPM count: (ZPM számolás)
 - Floor action() függvénye meghívódik amikor rálép ONeill.
 - Ha van a Floor példányon ZPM, akkor a ZPM-ét Null-ra állítja, és zpmcountert csökkenti. (még nem gondoltam át, csak kezdetlegesen beleraktam az osztálydiagramba)
