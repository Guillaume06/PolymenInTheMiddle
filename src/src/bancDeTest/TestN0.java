package bancDeTest;

import image.LecteurEcrivainImage;
import image.NotreRepresentationImage;
import manipulationImage.Lsb;
import text.EncodeDecode;

import java.util.Arrays;

/**
 * Created by Flavian Jacquot on 30/09/2015.
 */
public class TestN0 {
    public static void main(String[] args)
    {
        String file = "C://try2.jpg";
        String file2 = "C://saved.jpg";
        try {
            NotreRepresentationImage nri = new NotreRepresentationImage(file);
            System.out.println("Image :"+nri.toString());

            //System.out.println("Pixels:"+Arrays.toString(nri.pixels));
            //System.out.println("ALL:" + Arrays.toString(nri.all));
            int[] rgb = nri.getRGBAt(0);
            System.out.println("R: "+rgb[0]+"\tG: "+rgb[1]+"\tB: "+rgb[2]);
            //System.out.println("Pixel 4 : R"+res[0]+" G"+res[1]+" B"+res[2]);

            //transform
            byte[] transformedPixels;
            String hello = "Ouiiiiiiiiii!!!";
            byte[] toHide = hello.getBytes();
            byte[] hidden=Lsb.putDataIn2(toHide, nri.getPixels());
            nri.setPixels(hidden);
            //

            nri.write(file2);

            NotreRepresentationImage nri2 = new NotreRepresentationImage(file2);
            byte[] hiddedBytesToReveal = Lsb.getDataIn2(nri2.getPixels());
            String hiddedText = EncodeDecode.byteIntoString(hiddedBytesToReveal);

            System.out.println("GG ?"+hiddedText+":");


            byte[] diffBetween=LecteurEcrivainImage.differenceBetween(file, file2);
            for (int i = 0; i < diffBetween.length; i++) {
                if(diffBetween[i]!=0)
                {
                    System.out.println("Diff at :" +i +" : "+diffBetween[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
