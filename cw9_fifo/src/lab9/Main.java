package lab9;

import Fifo.*;

public class Main {

    public static void main(String[] args)
    {
    try
    {

        QFifo qfifo = new QFifo();
        qfifo.QFEnqueue(1);
        qfifo.QFEnqueue(2);
        qfifo.QFEnqueue(3);
        qfifo.QFEnqueue(4);
        qfifo.QFPrint();

        //qfifo.QFClear();
    }
    catch (QFifoException e)
    {
        e.showReason();
    }

    }
}
