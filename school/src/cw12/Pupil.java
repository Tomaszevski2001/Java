package cw12;

enum Subject {POLSKI, ANGIELSKI, MATEMATYKA, FIZYKA, CHEMIA};

abstract public class Pupil extends Person {

    private final static int SUBJECT_NO = 5;
    private String mClass = "";
    private double mAve = 0;
    private double[] mNotes = new double[SUBJECT_NO];
    protected String mID; // w klasie pochodnej użyjemy dlatego protected
    private static int ID = 1000; // static bo wspólna dla wszytskich obiektów


    public Pupil(String name, int age, String sClass) {
        super(name, age); mID = Integer.toString(ID++);
    }

    public void clearNotes() {
        for (int i = 0; i<SUBJECT_NO; i++) {
            mNotes[i] = 0;
        }
    }

    public void calcAve() {
        int no = 0;
        double Ave = 0;

        for (int i = 0; i<SUBJECT_NO; i++) {
            if(mNotes[i] >= 1) {
                mAve =+ mNotes[i];
                no++;
            }
        }
        mAve = (no != 0 ) ? Ave/no : 0;
    }

    public void setmNote( Subject sub, double note ) {
        switch (sub) {
            case POLSKI     : mNotes[0] = note;
            case ANGIELSKI  : mNotes[1] = note;
            case MATEMATYKA : mNotes[2] = note;
            case FIZYKA     : mNotes[3] = note;
            case CHEMIA     : mNotes[4] = note;
        }

    }

    public String getID() {
        return mID;
    }

    public double getAve() {
        return mAve;
    }

    public String getClassName() {
        return mClass;
    }

    public  String toString() {
        return getID() +  " " + getClassName() + " " + super.getName() +
                "(" + Integer.toString(getAge()) + ") ave = " +
                Double.toString(getAve()) + "\n" + printOutfit();
    }

    abstract  public String printOutfit();


}
