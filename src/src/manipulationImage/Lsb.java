package manipulationImage;

//import image.NotreRepresentationImage;

/**
 * @author Mathias Chevalier
 */
public class Lsb {

    //TODO stub
    public static byte[] putDataIn(byte[] toHide, byte[] wrapper)
    {
        byte[] res = new byte[wrapper.length];
        int j=0;
        //parcours du tableau d'octets à cacher (poids fort vers poids faible)
        for (byte tmp : toHide){
            for (int i=8; i>=1; i++){
                int value = getBit(i, tmp);
                res[j]=setBit(1,value,wrapper[j]);
                j++;
            }

        }
    return res;
    }
    //méthode pour récuperer des données codées sur chacun des bits de poids faible d'un tableau d'octets
    public static String getDataIn(byte[] bytes) {
        String toReturn = "";
        for (byte tmp : bytes){
            int value = getBit(1, tmp);
            toReturn += Integer.toString(value);
            }
        return toReturn;
}

    //méthode pour récupérer un bit à la position x dans un byte
    public static int getBit(int position, byte octet){
        return (octet >> (position-1)) & 1;
    }

    public static byte setBit(int position,int value, byte octet){
        octet |= value << position-1;
        return octet;
    }


}
