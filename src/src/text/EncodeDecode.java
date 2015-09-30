package text;

/**
 * Created by Flavian Jacquot on 30/09/2015.
 */
public class EncodeDecode {
    public static String  byteIntoString(byte[] bytesToConv){
        String res="";
        for(byte b:bytesToConv)
        res+=(char) (b & 0xff);
        return res;
    }

    public String encode(String s, String format)
    {
        return "";
    }
    public String decode(String s, String format)
    {
        return "";
    }
}
