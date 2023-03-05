package lab8;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

        System.out.println("Podaj liczbę całkowitą");
        System.out.println(Reader.readInt());
        System.out.println("Podaj liczbę zmiennoprzecinkową");
        System.out.println(Reader.readDouble());
        System.out.println("Podaj liczbę hexadecymalną");
        int hex = Reader.readHex();
        System.out.printf( "0x%x - %d", hex,hex );

    }
}
