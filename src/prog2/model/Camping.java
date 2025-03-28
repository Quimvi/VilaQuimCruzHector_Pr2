package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.*;

public class Camping implements InCamping{
    private String nomCamping;
    private final LlistaAllotjaments llistaAllotjaments = new LlistaAllotjaments();
    private final LlistaAccessos llistaAccessos = new LlistaAccessos();
    private final LlistaIncidencies llistaIncidencies = new LlistaIncidencies();

    public Camping(String nomCamping){
        setNomCamping(nomCamping);

    }

    public LlistaAccessos getLlistaAccessos() {
        return llistaAccessos;
    }

    public LlistaIncidencies getLlistaIncidencies() {
        return llistaIncidencies;
    }

    public LlistaAllotjaments getLlistaAllotjaments() {
        return llistaAllotjaments;
    }

    public void setNomCamping (String nomCamping){
        this.nomCamping = nomCamping;
    }

    public String getNomCamping(){
        return this.nomCamping;
    }

    public String llistarAllotjaments(String estat) throws ExcepcioCamping{
        return this.llistaAllotjaments.llistarAllotjaments(estat);

    }

    public String llistarAccessos(String infoEstat) throws ExcepcioCamping{
        boolean estat;
        if (infoEstat.equals("Obert")){
            estat = true;
        }else if (infoEstat.equals("Tancat")){
            estat = false;
        }else{
            throw new ExcepcioCamping("Infoestat inexistent");
        }
        return this.llistaAccessos.llistarAccessos(estat);
    }


    public String llistarIncidencies() throws ExcepcioCamping{
        return llistaIncidencies.llistarIncidencies();
    }

    public void afegirIncidencia(int num, String tipus, String idAllotjament, String data) throws ExcepcioCamping{
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);
        llistaIncidencies.afegirIncidencia(num,tipus,allotjament,data);
        llistaAccessos.actualitzaEstatAccessos();
        //fer la comprovacio del numero d'In
    }

    public void eliminarIncidencia(int num) throws ExcepcioCamping{
        Incidencia in = llistaIncidencies.getIncidencia(num);
        llistaIncidencies.eliminarIncidencia(in);
    }

    public int calculaAccessosAccessibles(){
        return llistaAccessos.calculaAccessosAccessibles();
    }

    public float calculaMetresQuadratsAsfalt(){
        return llistaAccessos.calculaMetresQuadratsAsfalt();
    }

    public void save(String camiDesti) throws ExcepcioCamping {
        File fitxer = new File(camiDesti);
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            // Gestión de excepciones
        } catch (Exception e) {
            System.out.println(e.getMessage());


        } finally {

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Camping load(String camiOrigen) throws ExcepcioCamping {
            try {
                FileInputStream fin = new FileInputStream(camiOrigen);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Camping campingCarregat = (Camping) ois.readObject();
                ois.close();
                fin.close();
                return campingCarregat;

            }
            catch (FileNotFoundException e) {
                throw new ExcepcioCamping("No s'ha trobat l'arxiu: "+e.getMessage());
            }
            catch (IOException e) {
                throw new ExcepcioCamping("Error al cargar l'arxiu: "+e.getMessage());
            }
            catch (ClassNotFoundException e){
                throw new ExcepcioCamping("No s'ha pogut fer càsting de les dades camping: "+e.getMessage());
            }
    }

    public void inicialitzaDadesCamping() {
        llistaAccessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        llistaAccessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        llistaAccessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        llistaAccessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        llistaAccessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        llistaAccessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        llistaAccessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc12);


        /* Pistes */

        llistaAllotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);
    }
}