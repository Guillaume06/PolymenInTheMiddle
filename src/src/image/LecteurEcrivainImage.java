package image;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Flavian Jacquot on 30/09/2015.
 */
public class LecteurEcrivainImage {
    //TODO stub

    public static byte[] read(String filePath)
    {
        Path path = Paths.get(filePath);
        try {
            byte[] data = Files.readAllBytes(path);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
