package cw12;

public class Teacher extends Worker{


    Subject mSubject;
    boolean isTutor;
    String mTutorClass;

    public Teacher(String name, int age, int experience, double salary, employmentType eT, Subject subject, boolean isTutor, String tutorClass) {
        super(name, age, experience, salary, eT);
        setSubject(subject); setTutor(isTutor); setTutorClass(tutorClass);

    }

    public Subject getSubject() {
        return mSubject;
    }

    public void setSubject(Subject mSubject) {
        this.mSubject = mSubject;
    }

    public boolean isTutor() {
        return isTutor;
    }

    public void setTutor(boolean tutor) {
        isTutor = tutor;
    }

    public String getTutorClass() {
        return mTutorClass;
    }

    public void setTutorClass(String mTutorClass) {
        this.mTutorClass = mTutorClass;
    }

    private String tutorStatus() {
        if(isTutor())
            return "Yes" + " class: " + getTutorClass();
        else
            return "No";
    }


    public String toString() {
        return getName() + " age: " + Integer.toString(getAge()) + " exp: " + Integer.toString(getExperience()) + " gross salary: " + Double.toString(grossSalary()) + " employment type: " + getET() + " subject: " + getSubject() + " tutor: " + tutorStatus();
    }
}
