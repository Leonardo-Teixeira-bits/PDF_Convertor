package com.converterei;

public class Main 
{
    public static void main( String[] args )
    {
        Reader reader = new Reader();
        reader.readding();
        Writer writer = new Writer();
        writer.writting(reader.cicles);
        System.out.println("Arquivo PDF criado com sucesso!");
    }
}
