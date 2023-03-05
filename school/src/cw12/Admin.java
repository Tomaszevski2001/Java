package cw12;

public class Admin extends Worker{
    String mPosition;

    public Admin(String name, int age, int experience, double salary, employmentType eT, String position) {
        super(name, age, experience, salary, eT);
        setPosition(position);

    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        this.mPosition = position;
    }

    public String toString() {
        return getName() + " age: " + Integer.toString(getAge()) + " exp: " + Integer.toString(getExperience()) + " gross salary: " + Double.toString(grossSalary()) + " employment type: " + getET() + " position: " + getPosition();
    }
}

