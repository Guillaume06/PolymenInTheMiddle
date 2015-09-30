package image;

import java.io.File;

/**
 * Created by Flavian Jacquot on 30/09/2015.
 */
public class LecteurEcrivainImage {
    //TODO stub
    public NotreRepresentationImage lire(String path)
    {
        return new NotreRepresentationImage();
    }

    public String read(String path)
    {

        File file = new File(path);

        file.get
        int lenght=0;
        String message="";
        Boolean verifready = null;
        do
        {
            char[] buffer= new char[100];
            try {
                lenght=this.m_entree.read(buffer);
                verifready = this.m_entree.ready();
                //double vérif
                if(!verifready)
                {
                    Thread.sleep(100);
                    verifready = this.m_entree.ready();
                }

                message+=new String(buffer);;
            }
            catch (Exception ex) {
                System.out.println("Erreur lors de la récéption");
                ex.printStackTrace();
                break;
            }
        }while(verifready);
        return message;
    }
}
