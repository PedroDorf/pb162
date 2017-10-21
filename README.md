## Třetí iterace

Cvičení zaměřené na statické metody, implementaci a použití rozhraní.

1.  Vytvořte třídu `SimpleMath` v balíku `cz.muni.fi.pb162.project.utils`.
    *   Třída bude implementovat pouze _statické_ metody.
    *   Statická metoda `Vertex2D minX(Vertex2D[] vertices)` vrátí vrchol s nejmenší X-ovou souřadnicí.
    *   Statická metoda `Vertex2D minY(Vertex2D[] vertices)` vrátí vrchol s nejmenší Y-ovou souřadnicí.
    *   Obdobně pro metody `maxX` a `maxY`.

    > Existují statické metody `Math.min` a `Math.max`.

2.  Upravte třídy `Triangle` a `Circle` tak, aby implementovaly i rozhraní `Measurable`.
    *   Výška/šířka trojúhelníku se vypočítá jako rozdíl maximální a minimální x-ové (u šířky) respektive y-ové (u výšky) souřadnice vrcholů:

        ![šířka objektů](images/03a.png)
    *   Využijte statické metody ze třídy `SimpleMath`.
    *   V metodě `isEquilateral` třídy `Triangle` používáme číslo `0.001` jako povolenou odchylku dvou reálných čísel
            (tzv. epsilon). Definujte tuto hodnotu jako **veřejnou konstantu**.

2.  V balíku `utils` vytvořte třídu `Gauger` ("měřidlo") se dvěma statickými přetíženými metodami `printMeasurement`:
    *   První metoda vezme libovolný měřitelný objekt (tj. libovolný objekt implementující rozhraní `Measurable`) a
        *   na standardní výstup vypíše _"Width: \<w\>"_, kde \<w\> je hodnota šířky,
        *   na další řádek vypíše _"Height: \<h\>"_, kde \<h\> je hodnota výšky.
    *   Druhá metoda vezme trojúhelník (objekt typu `Triangle`) a
        *   na standardní výstup vypíše informace o objektu, viz metoda `toString()`,
        *   na další řádek vypíše _"Width: \<w\>"_, kde \<w\> je opět hodnota šířky,
        *   na další řádek vypíše _"Height: \<h\>"_, kde \<h\> je opět hodnota výšky.
    *   Vyhněte se opakování kódu tím, že druhá varianta metody bude volat tu první. Pozor ale, ať nevolá sebe sama.
        Došlo by k zacyklení (`StackOverflowException`).

3.  V balíku `geometry` vytvořte třídu `Square`:
    *   První konstruktor bude obsahovat délku hrany a souřadnici levého dolního vrcholu.
    *   Druhý konstruktor bude obsahovat souřadnice středu a délku hrany.
    *   Aby šlo konstruktory ve třídě Square přetížit, musí mít druhý konstruktor parametry v opačném pořadí,
        tj. jako první je poloměr a jako druhý střed. Jinak by totiž byla signatura obou konstruktorů stejná.
    *   Třída bude implementovat rozhraní `Circumcircle` (opsaná kružnice):
    *   Poloměr opsané kružnice čtverce je
        ![poloměr kružnice](images/03b.png)
        kde `a` je délka hrany.
    *   Metoda `Vertex2D getVertex(int index)` vrátí vrchol na daném indexu v pořadí: 
        levý dolní, pravý dolní, pravý horní, levý horní.
        Souřadnice vrcholů čtverce vypočítáme posunutím (metoda `move`) již existujícího vrcholu.
    *   Přidejte taky getter `double getEdgeLength()`.
    *   Nezapomeňte na metodu `toString()`:

            "Square: vertices=[ax, ay] [bx, by] [cx, cy] [dx, dy]"

        přičemž zpráva obsahuje jen 3 mezery mezi vrcholy.

4.  Třída `Circle` bude taky implementovat rozhraní `Circumcircle`.
    Opsanou kružnicí je kružnice sama, proto netřeba implementovat žádné nové metody.
    Přidejte jenom anotaci `@Override`.

5.  V balíku `geometry` vytvořte třídu `Snowman`:
    *   Sněhulák se skládá ze čtyř opsaných kružnic.
    *   Konstruktor bude jako svůj první parametr brát parametr typu `Circumcircle` (spodní kružnice),
        a jako druhý parametr zmenšovací faktor (poloměru kružnice) pro kružnice nad ní (reálné číslo o rozsahu `(0..1>`).
        V případě, že vstupní parametr nebude z požadovaného rozsahu, použije se neveřejná pojmenovaná konstanta `0.8`.
    *   První kružnice je první argument konstruktoru, druhá bude položená na první s poloměrem zmenšeným o zmenšovací faktor,
        třetí kružnice bude vytvořena stejným způsobem.
    *   Celý sněhulák vznikne v konstruktoru, nebojte se ale kód rozdělit do menších privátních metod.
    *   Třídu implementujte tak, aby se dal počet koulí lehce měnit.
    *   Metoda `Circumcircle[] getBalls()` vrátí pole kružnic, od nejspodnější po nejvyšší (nejmenší).

6. Demo vytvoří čtverec se středem `[0, 0]`, délkou `100` a vypíše o něm informace na standardní výstup.

7. Draw vykreslí zelený čtverec a nad ním sněhuláka.
