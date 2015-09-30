package image;

/**
 * Created by Flavian Jacquot on 30/09/2015.
 */
public class DetecteurDeType {
    public static boolean isJpeg(byte[] rawFile)
    {
        byte firstJpegByte=(byte)0xFF;
        byte secondJpegByte=(byte)0xD8;
        return (rawFile[0]==firstJpegByte&&rawFile[1]==secondJpegByte);
    }
    public static boolean isBitMap(byte[] rawFile)
    {
        byte firstByte=(byte)'B';
        byte secondByte=(byte)'M';
        return (rawFile[0]==firstByte&&rawFile[1]==secondByte);
    }
}
