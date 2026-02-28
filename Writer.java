package com.converterei;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;



public class Writer {
    public void writting(ArrayList<String> cicles)
    {
        try{
            PDDocument PDF = new PDDocument();//possui os métodos para criar, salvar e fechar o arquivo PDF. Além de informações de título, autor e etc.
            PDPage Page = new PDPage(); //possui os padrões da página(folha A4...), como tamanho, margens, etc.
            PDF.addPage(Page);
            PDPageContentStream content = new PDPageContentStream(PDF, Page);
            PDType0Font fonteCustom = PDType0Font.load(PDF, new File("C:/Windows/Fonts/arial.ttf"));
            content.setFont(fonteCustom, 14);
            content.beginText();
            content.newLineAtOffset(40, 750); //beginText vem antes de newLine... pois é o padrão

            for(String line : cicles) //estrutura de loop for-each. Então para cada linha de cicle, eu adiciono na variavel line, e depois mostro o conteúdo dela no PDF
            {
                content.showText(line);
                content.newLineAtOffset(0, -20); //a cada linha nova, o texto desce 20 pontos
            }
            content.endText();
            content.close();
            PDF.save("mudarformato.pdf");
            PDF.close();

        }
        catch(IOException e){
            System.out.println("Erro ao criar o arquivo PDF");
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("problemas com o conteúdo do arquivo de texto, verifique se ele não está vazio ou se possui caracteres inválidos");
        }
    }
}
