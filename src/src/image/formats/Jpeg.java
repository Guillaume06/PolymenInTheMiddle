package image.formats;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Flavian Jacquot on 30/09/2015.
 */
public class Jpeg {
    public static void write(String path, BufferedImage toWrite)
    {
        ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
        ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
        jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpgWriteParam.setCompressionQuality(1f);
        try {
        ImageOutputStream outputStream = createOutputStream(path); // For example implementations see below
        jpgWriter.setOutput(outputStream);
        IIOImage outputImage = new IIOImage(toWrite, null, null);

            jpgWriter.write(null, outputImage, jpgWriteParam);
        } catch (IOException e) {
            e.printStackTrace();
        }
        jpgWriter.dispose();

    }

    private static ImageOutputStream createOutputStream(String path) throws IOException {
        FileImageOutputStream fios = new FileImageOutputStream(new File(path));

        return fios;
    }
}
