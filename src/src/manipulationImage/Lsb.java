package manipulationImage;

import image.NotreRepresentationImage;

/**
 * Created by Flavian Jacquot on 30/09/2015.
 */
public class Lsb {
    //TODO stub
    public String putTextIn(String text, byte[] bytes)
    {
        for (int i=7; i<text.size(); i=+8){
            bytes[i]=0;//premier bit du string etc etc
        }
    return text;
    }
    public String getTextIn(byte[] bytes)
    {
        return "";
    }
}
