package image;

import sun.misc.IOUtils;

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

    public static void write(String filePath,byte[] toWrite)
    {
        try {
                FileOutputStream out = new FileOutputStream(filePath);
        out.write(toWrite);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static byte[] differenceBetween(String file1, String file2)
    {
        byte[] file1Bytes = read(file1);
        byte[] file2Bytes = read(file2);
        int length = Math.min(file1Bytes.length, file1Bytes.length);
        byte[] res = new byte[length];
        for (int i = 0; i <length ; i++) {
            res[i]=0;
        }
        for (int i = 0; i < length; i++) {
            if(file1Bytes[i]!=file2Bytes[i])
            {
                res[i]=(byte)(file1Bytes[i]-file2Bytes[i]);
            }
        }
        return res;
    }
}
