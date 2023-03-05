package Tfifo;
enum ErrCode{FIFO_OVERFLOW_ERROR, FIFO_IS_EMPTY, } // to samo co zastosowane w stosie

public class QFifoException extends RuntimeException
{
    final private ErrCode mErrCode;
    public QFifoException(ErrCode errCode){
        mErrCode = errCode;
    }
    public void showReason()
    {
        switch (mErrCode){
            case FIFO_OVERFLOW_ERROR: System.err.println("\n ERROR: Stack overflow");break;
            case FIFO_IS_EMPTY: System.out.println("\n ERROR: Stack is empty");break;
            default:
                System.out.println("Other error!!\n");break;
        }
    }
}
