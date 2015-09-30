package text;
import java.io.*;

/**
 * Created by Guillaume on 23/09/2015.
 */
public class Proto {
    private static String s="Lorsque dans le cours des événements humains, il devient nécessaire pour un peuple de dissoudre les liens politiques qui l'ont attaché à un autre";
    public static void fileIntoByte(String fileName){
        String s="";
        try{
            InputStream ips=new FileInputStream(new File(fileName));
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            while ((ligne=br.readLine())!=null){
                //System.out.println(ligne);
                s+=ligne+" ";
            }
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        byte[] bytes = s.getBytes(); //Transforme le string en un tableau d'octets
        StringBuilder binary = new StringBuilder();
        for(byte b:bytes){ //Boucle sur ces octets
            int val = b;
            for (int i = 0; i < 8; i++) { //Boucle sur les 8 bits de l'octet
                binary.append((val & 128) == 0 ? 0 : 1); //"&" bit à bit entre l'octet octet et 128 (10000000)
                val <<= 1; //Décale tous les bits d'un cran vers la gauche
            }
            System.out.print(binary + " ");
            binary=new StringBuilder();
        }
        System.out.println();
    }
    public static void byteIntoString(byte b){
        System.out.print((char) (b & 0xff));
    }
    public static void stringIntoByte(String s){
        byte[] tmp=s.getBytes();
        int val=0;
        for (byte b : tmp){
            val=b;
            for (int i=0; i<8;i++){
                System.out.print((val & 128) == 0 ? 0 : 1);
                val <<=1;
            }
            System.out.print(" ");
        }
        System.out.println();
    }
    public static String hideMsg(String data, String toHide){
        byte[] dataByte=data.getBytes();
        byte[] toHideByte=toHide.getBytes();
        int cpt=0;
        int cpt2=0;
        int val2=toHideByte[0];
        String ret="";
        StringBuilder binary = new StringBuilder();
        for(byte b:dataByte) { //Boucle sur ces octets
            if (cpt==8 && cpt2<toHideByte.length-1) {cpt=0;cpt2++;val2 = toHideByte[cpt2];}
            int val = b;
            for (int i = 0; i < 8; i++) { //Boucle sur les 8 bits de l'octet
                if (i != 7) {
                    binary.append((val & 128) == 0 ? 0 : 1); //"&" bit à bit entre l'octet octet et 128
                }else{
                    binary.append((val2 & 128) == 0 ? 0 : 1); //"&" bit à bit entre l'octet octet et 128
                    val2<<=1;
                    cpt++;
                }
                val <<= 1; //Décale tous les bits d'un cran vers la gauche
            }
            ret+=(char) (Byte.parseByte(binary.toString(),2) & 0xff);
            binary = new StringBuilder();
        }
        return ret;
    }
    public static String getMsg(String data){
        byte[] dataByte=data.getBytes();
        StringBuilder binary=new StringBuilder();
        String ret="";
        int cpt=0;
        for(byte b:dataByte) { //Boucle sur ces octets
            int val = b;
            for (int i = 0; i < 8; i++) { //Boucle sur les 8 bits de l'octet
                if (i == 7) {
                    binary.append((val & 128) == 0 ? 0 : 1); //"&" bit à bit entre l'octet octet et 128
                }
                val <<= 1; //Décale tous les bits d'un cran vers la gauche
            }
            cpt++;
            if (cpt==8){
                cpt=0;
                ret+=(char) (Byte.parseByte(binary.toString(),2) & 0xff);
                binary = new StringBuilder();
            }

        }
        return ret;
    }
    public static void main(String[] args) {
        stringIntoByte(s);
        System.out.println(hideMsg(s, "j'aime les poney"));
        stringIntoByte(hideMsg(s, "j'aime les poney"));
        stringIntoByte("j'aime les poney");
        System.out.println(getMsg(hideMsg(s, "j'aime les poney")));
    }

}

