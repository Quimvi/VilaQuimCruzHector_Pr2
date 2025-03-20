package prog2.model;

public class CamiTerra extends AccesTerra{

        public CamiTerra(String nom, boolean acces, boolean accessibilitat, int metresQuadrats, int longitud){
            super(nom, acces,accessibilitat,metresQuadrats, longitud);
        }

        // s'ha de fer
        public boolean isAccessibilitat(){

        }

        @Override
        public String toString() {
            return super.toString() + "Camí Terra ";
        }
    }

