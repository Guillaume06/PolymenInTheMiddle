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

    private byte[] pixels;
    private byte[] header;
    private String path;

    public NotreRepresentationImage(String path) {
        byte[] all = LecteurEcrivainImage.read(path);

    }
}
