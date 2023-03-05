package Fifo;

enum ErrCode{FIFO_ALLOC_ERROR, FIFO_IS_EMPTY, OTHER_ERROR }

public class QFifoException extends RuntimeException {

    final private ErrCode mErrCode;
    public QFifoException(ErrCode errCode){
        mErrCode = errCode;
    }
    public void showReason(){
        switch (mErrCode){
            case FIFO_ALLOC_ERROR: System.err.println("\nERROR: Stack overflow");break;
            case FIFO_IS_EMPTY: System.err.println("\nERROR: Stack is empty");break;
            default:
                System.out.println("Other error!!\n");break;
        }
    }

}
