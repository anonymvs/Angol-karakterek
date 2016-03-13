Ide listázom a még megvizsgálandó játékelemeket, amiket át kell gondolni az új modell függvényében.

Creation:
 - Main létrejön létrehozza levelt.
 - Level meghívja bizonyos Floor objektumok függvényét ami létrehozza ONeill-t és a dobozokat. Floor ismeri őket csak szólni kell neki, hogy hozza őket létre. (jobb mintha Level ismerné még ONeillt és Box-it)
 - Level betölti a pályát. Létrehozza a kapcsolatokat az elemek között.
 - Innentől bemenetre várunk.

Movement: (ONeil, Missile mozgása)
-f = ONeil.floor.getNeighbour(dir)
--f.moveAction(this)
---Ha floor
----oneill = parameter
----zpm stuff
----parameter.setFloor(this)
----return true
---Ha wall return false
---Ha chasm return true
-Ha return==true, floor.setOneill(null)

Box situations: (Doboz felvétele, elengedése)
-f = ONeil.floor.getNeighbour(dir)
--f.boxAction(box)
---Ha box == null -> box felvétele
---Ha box != null -> box lerakása
---Box lerakása
----Ha chasm return true
----Ha wall return false
----Ha floor
-----Ha placed != null
------placed.boxAction(parameter)
-------Ha Box return false
-------Ha Door return false
-----placed = box

Missile: mozgás
-entity = tile.getNeighbour(dir)
-entity.missileAction(this)
--Ha floor vagy chasm
---missile = parameter
--Ha wall -> portál?
---Create Portal, set portal reference
----Set static bluePortal, yellowPortal, wall reference
----Set direction
----Megvizsgálja a régi ugyanolyan színű portált, arra close()
-----Visszaállítja a szomszédot
----Beállítja a floor szomszédját (saját magát) a társportál directionje alapján
-tile.setMissile(null)
-Ha missileAction(this) == true
-tile = entity
-Ha misisleAction(this) == false
-Megsemmisül a missile


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