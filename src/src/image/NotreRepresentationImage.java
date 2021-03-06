package image;

import image.formats.Jpeg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Flavian Jacquot on 30/09/2015.
 */
public class NotreRepresentationImage {
    BufferedImage img;
    private int nbComposantes=3;//bitmap
    public byte[] pixels;

    private byte[] header;

    public byte[] getFooter() {
        return footer;
    }

    private byte[] footer;
    public byte[] all;
    private String path;


    public void write(String path)
    {
        if(DetecteurDeType.isBitMap(this.all))
        {
            byte[] temp = this.concatBytesArrays(this.getHeader(), this.pixels);
            byte[] newImageFile =  this.concatBytesArrays(temp, this.getFooter());
            LecteurEcrivainImage.write(path,newImageFile);
        }
        else
        {
            //create image
            if(img!=null)
            {

                    //System.out.println(Arrays.toString(this.pixels));
                img.getRaster().setDataElements(0,0,this.pixels);
                 Jpeg.write(path,this.img);


            }
        }
    }
    public void setPixels(byte[] toHide)
    {
        this.pixels=toHide;
    }
    public static byte[] concatBytesArrays(byte[] first,byte[] second)
    {
        byte[] concat = new byte[first.length+second.length];
        int i=0;
        for(i=0;i<first.length;i++)
        {
            concat[i]=first[i];
        }
        int offset=i;
        for(i=0;i<second.length;i++)
        {
            concat[offset+i]=second[i];
        }
        return concat;
    }

    public NotreRepresentationImage(String path) throws Exception {
        this.path=path;
        this.all = LecteurEcrivainImage.read(path);
        if(DetecteurDeType.isBitMap(all))
        {
            int offsetContent = (int)all [0x000A];
            System.out.println("offset"+offsetContent);
            //int size = toInt(all,0x0002)-offsetContent;
            int size = all.length-offsetContent;

            this.header = new byte[offsetContent];

            for (int i = 0; i < offsetContent; i++) {
                header[i]=all[i];
            }
            this.pixels = new byte[all.length-offsetContent-2];

            for (int i = 0; i < pixels.length; i++) {
                pixels[i]=all[i+offsetContent];
            }
            footer=new byte[2];
            footer[0]=all[all.length-2];
            footer[1]=all[all.length-1];
            //System.out.println("first pixel: R"+pixels[0]+" G"+pixels[1]+" B"+pixels[2]);
        }
        else
        {

            img = null;
            try {
                img = ImageIO.read(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
        }
    }

    public int[] getRGBAt(int offset) {
        int[] res = new int[3];
        res[0]=((int) this.pixels[offset]) & 0xff;
        res[1]=((int) this.pixels[offset+1]) & 0xff;
        res[2]=((int) this.pixels[offset+2]) & 0xff;

        return res;
    }

    @Override
    public String toString() {
        return "";
       /* return "NotreRepresentationImage{" +
                "pixels=" + pixels.length +
                ", header=" + header.length +
                ", all=" + all.length +
                ", path='" + path + '\'' +
                '}';*/
    }
    public byte[] getHeader() {
        return header;
    }

    public byte[] getPixels() {

        return pixels;
    }
}

