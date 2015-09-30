package image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

/**
 * Created by Flavian Jacquot on 30/09/2015.
 */
public class NotreRepresentationImage {
    private int width;
    private int height;
    private byte[] pixels;

    @Override
    public String toString() {
        return "OurAbstractImage [width=" + width + ", height=" + height + ", #ofPix=" + pixelsRGB.length
                + ", path=" + path + "]";
    }

    public void printPixelMatrix() {
        // TODO Auto-generated method stub
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(pixelsRGB[i*width+j]+" ");
            }
            System.out.println("|");
        }
    }

    private int[] pixelsRGB;
    private String path;

    public NotreRepresentationImage(String path) {
        super();
        BufferedImage img = null;
        File f=null;
        try {
            f = new File(path);

            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Path:" + f.getAbsolutePath());

        }
        pixelsRGB=img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
        this.width = img.getWidth();
        this.height = img.getHeight();

        this.path = path;
    }

    public void write()
    {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = (WritableRaster) image.getData();
        raster.setPixels(0,0,width,height,this.pixelsRGB);
        File outputfile = new File(this.path);
        try {
            ImageIO.write(image, "jpg", outputfile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public byte[] intToBytes(Integer i)
    {
        //byte[] tab = new byte[];

        return null;

    }
    //convert to int then to string then to byte ....
    public void printPixelMatrixBytes() {
        // TODO Auto-generated method stub
        byte b = (byte) pixelsRGB[0];
        System.out.println("Int Value: "+pixelsRGB[0]+"\t byte:"+b);
		/*for (int i = 0; i < pixelsRGB.length; i++) {
				String s = Integer.toUnsignedString(pixelsRGB[i],2)+" ";
				String a = s.substring(0, 7);

				Byte aB = Byte.valueOf(a,2);
				String r = s.substring(8, 16);
				String g = s.substring(16, 24);
				String b = s.substring(24);
				System.out.println("P:"+i+"\tA"+aB+" R"+r+" G"+g+" B"+b);

		}*/
    }

}
