package cw8;

public class Stack<T>
{
    //------------------------
    private class StackItem
    {
        private T mKey; //informacja na stosie
        private StackItem mNext; //referencja do nastepnego
        StackItem(T key, StackItem next)
        {
            mKey = key;
            mNext = next;
        }
        public T getKey()
        {
            return mKey;
        }
        public StackItem getNext()
        {
            return mNext;
        }

    }
    //------------------------
    private StackItem mHead; //stack Head

    public Stack()
    {
        mHead  = null;
    }

    public void push(T key)
    {
        try {
            mHead = new StackItem(key, mHead);
        }
        catch (OutOfMemoryError e)
        {
            throw new StackException(ErrCode.STACK_OVERFLOW_ERROR);
        }

    }

    public T pop()
    {
        if( !isEmpty())
        {
            T key = top();
            del();
            return key;
        }
        else
            throw new StackException(ErrCode.STACK_IS_EMPTY);
    }

    public T top()
    {
        if(!isEmpty())
            return (T)mHead.getKey();

            throw new StackException(ErrCode.STACK_IS_EMPTY);
    }

    public void  del()
    {
        if(!isEmpty()) //przewiazac mHead na getNext()
            mHead = mHead.getNext();
        else
            throw new StackException(ErrCode.STACK_IS_EMPTY);
    }

    public boolean isEmpty()
    {
        return mHead == null;
    }





}

