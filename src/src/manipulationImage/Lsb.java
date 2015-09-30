package manipulationImage;

//import image.NotreRepresentationImage;

/**
 * @author Mathias Chevalier
 */
public class Lsb {

    //TODO stub
    public static byte[] putDataIn(byte[] toHide, byte[] wrapper)
    {
        byte[] res = wrapper.clone();
        int j=0;
        //parcours du tableau d'octets à cacher (poids fort vers poids faible)
        for (byte tmp : toHide){
            for (int i=8; i>=1; i--){
                int value = getBit(i, tmp);
                res[j]=setBit(1,value,wrapper[j]);
                j++;
            }

        }

    return res;
    }
    //méthode pour récuperer des données codées sur chacun des bits de poids faible d'un tableau d'octets
    public static byte[] getDataIn(byte[] bytes) {
        byte[] toReturn = new byte[bytes.length];
        int j=0;
        int[] value = new int[8];
        for (int k=0;k<bytes.length;k++){
            value[k%8] = getBit(1, bytes[k]);
            if(k%8==0)
            {
                int oiez=0;
                for(int i=8;i>=1;i--)
                {
                    setBit(i,value[oiez],toReturn[j]);
                    oiez++;
                }
            }

            j++;
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
