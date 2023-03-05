package cw8;

enum ErrCode{ STACK_OVERFLOW_ERROR(2), STACK_IS_EMPTY(1), OTHER_ERROR(0) ;
    private int mCode;
    ErrCode(int code) {mCode = code; }
}

public class StackException extends RuntimeException
{
    private ErrCode mErrCode;
    public StackException(ErrCode errCode)
    {
        mErrCode = errCode;
    }

    public String getReason()
    {
        switch (mErrCode)
        {
            case STACK_OVERFLOW_ERROR: return"Stack is overflow!\n";
            case STACK_IS_EMPTY: return "Stack is empty!\n";
            default: return "Other error!\n";
        }
    }
}
