import java.util.Random;

enum ErrCode{ ERROR_OUT_OF_RANGE(1), IOERROR(2), OTHER(0);
    private int mErrCode;
    ErrCode( int err )
    {
        mErrCode = err;
    }
}

class MyException extends Exception
{
    private ErrCode mCode;
    public MyException( ErrCode err )
    {
        mCode = err;
    }
    public String getReason()
    {
        switch(mCode)
        {
            case ERROR_OUT_OF_RANGE: return "Index out of range";
            case IOERROR: return "input/Output error";
            default: return "other error";
        }
    }
}

public class Main
{
    private final static int PARAMS_NO = 1;
    public static void main(String[] args)
    {
        if ( args.length != PARAMS_NO)
        {
            System.out.println("Usage: Main <tab_size>");
        }
        /*
        ErrCode err = ErrCode.IOERROR;
        System.out.println("order = " + err.ordinal() );
         */

        int[] tab = new int[Integer.valueOf(args[0]).intValue()];
        initTab( tab );
        printTab( tab );
        long start = System.currentTimeMillis();
        //simpleSelectionSort( tab );
        simpleInsertionSort( tab );
        long stop = System.currentTimeMillis();
        System.out.println("Sort time: " + (stop - start));
        System.out.println("");
        //printTab( tab );
    }

    private static void initTab( int[] tab )
    {
        Random rand = new Random();
        for( int i = 0; i < tab.length; i++ )
        {
            tab[i] = rand.nextInt( tab.length );
        }
    }

    private final static int MAXNUMINLINE =10;
    private static void printTab( int[] tab )
    {
        for( int i = 0; i < tab.length; i++ )
        {
            System.out.print( tab[i] + " " );
            if( ( i + 1 ) % MAXNUMINLINE == 0 )
            {
                System.out.println();
            }
        }
    }

    private static void simpleSelectionSort( int[] tab )
    {
       /*for( int i = 1; i < tab.length; i++ )
        {
            for( int j = i-1; j >= 0; j--) {
                if (tab[j+1] < tab[j]) {
                    int temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = temp;
                }
                else
                {
                    break;
                }
            }
        }

        */

        for( int i=0; i < tab.length-1; i++ )
        {
            int min = tab[i];
            int ix = i;
            for( int j=i+1; j<tab.length; j++ )
            {
              if(tab[j] < min )
              {
                  min = tab[j];
                  ix = j;
              }
            }
            tab[ix] = tab[i];
            tab[i] = min;
        }
    }

    private static void simpleInsertionSort( int[] tab )
    {
        for( int i=1; i < tab.length; i++ )
        {
            int x = tab[i];
            int j = i-1;
            while( j >= 0 && tab[j] > x )
            {
                tab[j+1] = tab[j--];
            }
            tab[j+1] = x;
        }


    }

}