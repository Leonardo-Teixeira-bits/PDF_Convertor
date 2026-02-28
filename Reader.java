package com.converterei;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Reader {
    ArrayList<String> cicles = new ArrayList<>();
    String auxiliar;
    public void readding()
    {
        try{            
            File archive = new File("mudarformato.txt");
            FileReader fileread = new FileReader(archive);
            BufferedReader readbuffer = new BufferedReader(fileread);
        
            while((auxiliar = readbuffer.readLine()) != null)
            {
                cicles.add(auxiliar);
            }
            readbuffer.close();
        }
        catch(IOException e){
            System.out.println("Erro ao ler o arquivo");
        }
    }
}
