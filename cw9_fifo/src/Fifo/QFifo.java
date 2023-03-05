package Fifo;

// HEAD I TAIL HEAD USTAWIONY NA PIERWSZY A TAIL NA OSTATNI
public class QFifo {
    
    private class QFifoItem{
        private int mKey;
        private QFifoItem mNext;
        public QFifoItem(int key){
            setKey(key);
            setNext(null);
        }
        public void setNext(QFifoItem next){
            mNext = next;
        }
        public void setKey(int key){
            mKey = key;
        }
        public QFifoItem getNext(){
            return mNext;
        }
        public int getKey(){
            return mKey;
        }

        // klucz typu int  mKey
        // ref do ostatniego obiektu
        // konstr z parametrem
        // setter i gettery setNext, getNext(), setKey(), getKey(),
    }
    //######################3333
    public QFifo(){
        mHead = mTail = null;
    }
    
    public void QFEnqueue(int key){
        // static do kolojeki, uwga na kolejkę pustą
        QFifoItem a = new QFifoItem(key);
        if(QFisEmpty()){
            mHead = a;
        }else {
            mTail.setNext(a);
        }
        mTail = a;
    }

    public int QFDequeue() throws QFifoException{
        // po usunieciu sprawdzi czy pusta i ewentualnie ustawi nTail na null\
            if (!QFisEmpty()){
                int key = mHead.getKey();
                del();

                return key;
            }
            throw new QFifoException(ErrCode.FIFO_IS_EMPTY);
    }
    public void QFClear(){
        mHead = mTail = null;
        // czyści kolejkę (ma być jak po kreowaniu)
    }
    private boolean QFisEmpty(){ // sprawdzanie czy jest pusta

        return mHead == null;
    }
    private void del() throws QFifoException{
        if (!QFisEmpty()){
            mHead = mHead.getNext();
        }else {
            throw new QFifoException(ErrCode.FIFO_IS_EMPTY);
        }
        if (QFisEmpty())
        {
            mTail = null;
        }
        //usuwanie pierwszego elementu z kolejki
    }

    public void QFPrint(){
        try {
            if (QFisEmpty()){
                throw new QFifoException(ErrCode.FIFO_IS_EMPTY);
            }
            QFifoItem a = mHead;
            while (a.getNext() != null){
                System.out.println(a.mKey);
                a = a.getNext();
            }
            System.out.println(a.mKey); // drukowanie elementów kolejnki

        }catch (QFifoException e){
            e.showReason();
        }
    }

    QFifoItem mHead; // stad pobieramy z kolejki (refer do pierwszego elem, Fifo)
    QFifoItem mTail; // za tym elementem stawiamy na koniec kolejki (refer do ostatniego elem, Fifo)
}
