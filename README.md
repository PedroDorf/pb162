## První iterace

Cvičení zaměřené na základní práci s atributy, metodami a na instanciaci tříd (bez vlastních konstruktorů).

1.  Upravte třídu `Vertex2D` následujícím způsobem:
    *   Přidejte do třídy tzv. "gettery" a "settery", konkrétně metody:
        *   `double getX()` a `double getY()` pro získání hodnot atributů,
        *   `void setX(double newX)` a `void setY(double newY)` pro nastavení hodnot atributů.
    *   Upravte viditelnost atributů, aby splňovaly podmínky zapouzdření.
    *   Metodu `printInfo()` přejmenujte na `toString()`.
2.  Vytvořte třídu `Triangle` v balíku `cz.muni.fi.pb162.project.geometry`.
    *   Trojúhelník se skládá ze tří vrcholů typu `Vertex2D` a bude mít jeden atribut typu **pole vrcholů**.
    *   Třída bude mít defaultní (implicitní) konstruktor.
    *   Metoda `Vertex2D getVertex(int index)` vrátí _index_-tý vrchol.
        Jestli je _index_ menší než 0 nebo větší než 2, vrátí metoda hodnotu `null`.
        Když je _index_ 0, vrátí první vrchol, jestli 1 tak druhý, jestli 2 pak třetí.
    *   Obdobně `void setVertex(int index, Vertex2D vertex)`.
    *   Metoda `String toString()` vrátí řetězec:

        ~~~~
        "Triangle: vertices=[ax, ay] [bx, by] [cx, cy]"
        ~~~~
        Využijte metodu `toString()` z třídy `Vertex2D`.
    * Trojúhelník budeme moci rozdělit na tři menší trojúhelníky:

        ![rozdělený trojúhelník](images/01b.png)
        *Původní trojúhelník (vlevo) a rozdělený na podtrojúhelníky (vpravo).*
    *   Implementujte proto tyto metody:
           *   Třída `Triangle` bude obsahovat atribut typu `Triangle[]`.
               V něm budou uloženy tři menší (na obrázku - černé) trojúhelníky. Na začátku je tento atribut nenainstanciovaný (nastavený na null),
               protože rozdělení zatím nebylo provedeno.
           *   Metoda `boolean isDivided()` zjistí, jestli již došlo k rozdělení trojúhelníka (menší trojúhelníky byly vytvořeny).
           *   Metoda `getSubTriangle(int index)` vrátí `index`-tý podtrojúhelník, kde `index` je číslo mezi 0 a 2.
               Pokud je `index` mimo tento rozsah, nebo pokud trojúhelník není dosud rozdělen, vrátí metoda `null`.
           *   Metoda `boolean divide()` rozdělí trojúhelník, tj. vytvoří tři menší trojúhelníky, uloží je do atributů a vrátí `true`.
               Pokud již trojúhelník byl rozdělen (`isDivided()` vrátí `true`), metoda neprovede nic a jen vrátí `false`.
               Vrcholy menších trojúhelníků jsou vždy v polovině délky stran původního trojúhelníka.
               Střed hrany (úsečky) má souřadnice _[(x<sub>1</sub>+x<sub>2</sub>)/2, (y<sub>1</sub>+y<sub>2</sub>)/2]_,
               kde _[x<sub>1</sub>, y<sub>1</sub>]_ a _[x<sub>2</sub>, y<sub>2</sub>]_ jsou vrcholy trojúhelníka.
           *   Je doporučeno si na souřadnice středu hrany mezi dvěma vrcholy vytvořit privátní metodu.


3.  Upravte třídu `Demo` následujícím způsobem:
    *   Třídu přesuňte do balíku `cz.muni.fi.pb162.project.demo`.
    *   Zrušte vytváření proměnných i výpis textu.
    *   Třída vytvoří trojúhelník se souřadnicemi _[-100, 0] [0, 100] [100, -100]_.
    *   Na std. výstup vypíše informace o trojúhelníku. Po spuštění by výstup měl vypadat takto:

        ~~~~
        Triangle: vertices=[-100.0, 0.0] [0.0, 100.0] [100.0, -100.0]
        ~~~~
5.  Správnost implementace si ověřte jednotkovými testy.
    Pak spustíte třídu `Draw` v balíčku `demo`, zobrazí se vám trojúhelník se třemi podtrojúhelníky.

6.  Zdokumentujte třídy pomocí [_JavaDoc_](https://en.wikipedia.org/wiki/Javadoc).
    Pak zkontrolujte, jestli vám přešel checkstyle zavoláním příkazu:

        mvn clean install -Dcheckstyle.fail=true
