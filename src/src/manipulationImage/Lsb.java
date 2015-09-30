package manipulationImage;

//import image.NotreRepresentationImage;

import text.EncodeDecode;

import java.util.BitSet;

/**
 * @author Mathias Chevalier
 */
public class Lsb {

    /**@author flavian*/
    public static byte[] putDataIn2(byte[] toHide, byte[] wrapper)
    {
        //vérifier que ça rentre
        byte[] res = wrapper.clone();
        BitSet buff=BitSet.valueOf(toHide);
        BitSet wrapperSet = BitSet.valueOf(toHide);
        for (int i = 0; i <buff.length(); i++) {
            wrapperSet.set(i * 8, buff.get(i));
        }
        byte[] tempByte=wrapperSet.toByteArray();
        for (int i = 0; i <tempByte.length ; i++) {
            res[i]=tempByte[i];
        }
        return res;
    }
    public static byte[] getDataIn2(byte[] wrapper)
    {
        byte[] res = new byte[100];

        BitSet buff=new BitSet(wrapper.length);
        System.out.println("buff.length() = " + buff.length());
        BitSet wrapperSet = BitSet.valueOf(wrapper);

        for (int i = 0; i <wrapper.length; i++) {
            buff.set(i,wrapperSet.get(i * 8));
        }
        return buff.toByteArray();
    }
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

    public static void main(String[] args) {
        byte[] wrapper = new byte[100];
        for (int i = 0; i < wrapper.length; i++) {
            wrapper[i]=0;
        }
        String toHide = "hello world";
        byte[] hide = toHide.getBytes();
        System.out.println("NB BITS TO HIDE"+hide.length*8);
        System.out.println("NB BITS TO HIDE"+wrapper.length*8);

        byte[] uuu=Lsb.putDataIn2(hide, wrapper);
        System.out.println(" + :" + uuu.length);

        byte[] UUUU=Lsb.getDataIn2(uuu);
        String s = new String(UUUU);
        System.out.println("s +s.length() " + s );

    }
}
