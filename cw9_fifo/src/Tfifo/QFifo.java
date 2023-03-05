package Tfifo;

public class QFifo {

    private int[] fifo;
    private int mMaxSize; // zbędne bo później mozna uzywac fifo.length
    private int mHead; // index pierwszego elementu do pobrania
    private int mTail; // index pierwszego wolnego miejsca w kolejce
    private int mElemNum; // ilosc elementów w kolejce

    //###
    public QFifo(int fifoSize){
        mMaxSize = fifoSize;
        fifo = new int[fifoSize];
        mHead = 0;
        mTail = 0;
        mElemNum = 0;
    }
    public void QFEnqueue(int key) throws QFifoException {

        if(mElemNum == mMaxSize) {
            throw new QFifoException(ErrCode.FIFO_OVERFLOW_ERROR);
        }
        mElemNum++;
        fifo[mTail] = key;
        mTail = (mTail+1) % mMaxSize;
    }

    public int QFDequeue() throws QFifoException{

        if(QFisEmpty())
            throw new QFifoException(ErrCode.FIFO_IS_EMPTY);
        int key = fifo[mHead];
        del();
        return key;
    }
    public void QFClear()
    {
       while (!QFisEmpty()){
           del();
       }
    }

    private boolean QFisEmpty()
    {
        return mElemNum == 0;
        // czy jest pusta
    }
//usunie elementy z kolejki
    private void del(){

        if(!QFisEmpty()){
            if(mElemNum <= mMaxSize){
                fifo[mHead] = 0;
                mHead = (mHead+1) % mMaxSize;
                mElemNum--;
            }
            else throw new QFifoException(ErrCode.FIFO_OVERFLOW_ERROR);
        }
        else throw new QFifoException(ErrCode.FIFO_IS_EMPTY);
    }


   //tutaj
    }


