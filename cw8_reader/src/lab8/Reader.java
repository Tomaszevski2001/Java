package lab8;

import java.io.IOException;

public class Reader
{
    private static boolean ungetted = false;
    private static char getOneChar = '0';

    public static char getChar()
    {
//        obsługa wyjątkow - czyta jeden znak z Klawiatury
        try {
            if(!ungetted){
                return (char) System.in.read();
            }
        ungetted = false;
        return  getOneChar;

        }
        catch (IOException e){
            return '\0';
        }
    }

    public static void ungetChar(char c)
    {
//        zawsze jeden znak (tylko jeden) do ponownego czytania
            getOneChar = c;
            ungetted = true;
    }

    public static double readDouble()
    {
//        wczytać znak
//        readnum
//        sprawdzić czy jest kropka w unget char
//        mnożymy za każdym razem przez 0.1
        boolean sign = getSign();
        double number = readNum();
        char c;
        if ((c=getChar()) == '.')
        {
            double multiplier = 0.1;
            while(isDecDigit(c=getChar())){
                number += charDecDigit2Int(c) * multiplier;
                multiplier *= 0.1;
            }
        }
        ungetChar(c);
        return  sign ? -number : number;
    }

    public static int readInt()
    {
//         czytanie i użycie znaku,  read num, przeczytać liczbe bez znaku w zależności od znaku zwrócić
//         czyta znak liczba cała ze znakiem
        boolean sign = getSign();
        int number = readNum();
        return  (sign) ? -number : number;

    }


    public static int readHex() throws IOException
    {
//         czytanie liczby hexadecymalnych 0x1F
//         throws new IOException ("Wrong hexadecimal profix! Should be 0x  or 0X);
//         sprawdzam znak czy == 0 jesli nie to rzucam wyjątek
//         sprawdzam czy jest x X
//         schemat hornera dla liczb szestkowych
//         printf 0x%x - do wydrukowania liczby hexadecymalnej
        char c;
        int res = 0;
        SkipSpace();

        try {
            if (!((getChar()) == '0'))
                throw new IOException("Wrong hexadecimal prefix! Should be 0x or 0X");
            if (!(((c = getChar()) == 'x') || (c == 'X')))
                throw new IOException("Wrong hexadecimal prefix! Should be 0x or 0X");
            while (isHexDigit(c=getChar()))
            {
                res = res *16 + charHexDigit2Int(c);
            }
            ungetChar(c);
            return res;
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    
//    funkcje prywatne


    private static int readNum(){
        char c;
        int res = 0;
        SkipSpace(); // pominięcie spacji
        while (isDecDigit(c=getChar())) // pętla  while sprawdzenie czy wczytany znak jest cyfrą dziesiętną
        {
            res = res *10 + charDecDigit2Int(c); // algorytm hornera 5 * 10^0 + 0*10^1
        }
            ungetChar(c);
            return res;
    }


    private static boolean getSign()
    {
       SkipSpace();// pominięcie spacji
       char c = getChar(); // wczytanie znaku
       if( c == '-') return true; //  jeśli jest minusem to wartośc true, jeśli nie jest plusem to zwrócić do czytania
       if(c != '+') ungetChar(c);
       return false;
    }


    private static void SkipSpace()
    {
        char c;
        while( (c=getChar()) == ' ' || c == '\t' || c=='\n' || c=='\r');
        ungetChar(c);
    }


    private static boolean isDecDigit(char c)
    {
        return c>= '0' && c<= '9'; // >=48 <=57, sprawdzenie czy c jest znakiem cyfry dziesietnej
    }


    private static boolean isHexDigit (char c)
    {
        return isDecDigit(c) || isHexLetter(c); // sprawdzenie czy c jest znakiem szesnastkowym
    }


    private static char UpperCase(char c)
    {
        return (c >= 'a' && c <= 'f') ?  (char)(c - 32) : c; // wraca zamienioną na duża litere hexa
    }


    private static boolean isHexLetter(char c)
    {
        return (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'); // zwraca czy c jest cyfrą szesnastkową (litera)
    }


    private static int charDecDigit2Int(char c)
    {
        return c - '0'; //'0' = 48 = 0x30   c = '1' == 49   /// '0' = 48 //zwraca wartość cyfry (zależne od znaku)
    }


    private static int charHexDigit2Int(char c)
    {
        return isDecDigit(c=UpperCase(c)) ? charDecDigit2Int(c) : c - 'A' + 10; // zwraca wartosc cyfry hexadecymalnej (zależne od znaku)
    }
}
