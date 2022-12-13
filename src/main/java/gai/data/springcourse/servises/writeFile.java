package gai.data.springcourse.servises;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeFile {
    private static void writeUsingBufferedWriter(String data, int noOfLines) {

        File file = new File("/migration/kompan/kompanKarta.txt");

        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine = data + System.getProperty("line.separator");
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);


            for(int i = noOfLines; i>0; i--){
                br.write(dataWithNewLine);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
