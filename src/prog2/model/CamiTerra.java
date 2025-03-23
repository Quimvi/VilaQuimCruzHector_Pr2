package prog2.model;

public class CamiTerra extends AccesTerra{

        public CamiTerra(String nom, boolean estat, float longitud){
            super(nom, false,estat, longitud);
        }

        // s'ha de fer
        public boolean isAccessibilitat(){
            return false;
        }

        @Override
        public String toString() {
            return super.toString() + "Camí Terra ";
        }
    }

