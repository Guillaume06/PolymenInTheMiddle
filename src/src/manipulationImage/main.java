package manipulationImage;

/**
 * @author Mathias Chevalier
 * @school Polytech' Nice
 * Classe de test évidemment
 */
public class main {

    public static void main(String[] args) {
        byte toPrint;
        byte temp = new Byte("13");
        for (int i = 1; i <= 8; i++) {
            System.out.println(getBit(i, temp));
        }
        for (int i = 1; i <= 8; i++) {
            toPrint=setBit(i, 1, temp);
            System.out.println(getBit(i, toPrint));
        }

    }

    public static int getBit(int position, byte octet) {
        return (octet >> (position - 1)) & 1;
    }

    public static byte setBit(int position, int value, byte octet) {
        octet |= value << position - 1;
        return octet;
    }
}
