package prog2.vista;

import prog2.model.Acces;
import prog2.model.CamiAsfaltat;
import prog2.model.Camping;
import prog2.model.LlistaAccessos;

public class Prova {
    public static void main(String[] args) {

        LlistaAccessos prova = new LlistaAccessos();
        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        prova.afegirAcces(Acc1);
        prova.buidar();

        System.out.println(prova.llistarAccessos(true));
    }
}
