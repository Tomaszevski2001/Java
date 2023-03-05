package cw12;

enum employmentType {HALF_TIME, FULL_TIME, CONTINGENT_WORKER};

public abstract class Worker extends Person{

    int mExperience;
    double mSalary;
    employmentType eT;

    public Worker(String name, int age, int experience, double salary, employmentType eT) {
        super(name, age);
        setExperience(experience); setSalary(salary); setET(eT);
    }

    public int getExperience() {
        return mExperience;
    }

    public void setExperience(int mExperience) {
        this.mExperience = mExperience;
    }

    public double getSalary() {
        return mSalary;
    }

    public void setSalary(double mSalary) {
        this.mSalary = mSalary;
    }

    public employmentType getET() {
        return eT;
    }

    public void setET(employmentType eT) {
        this.eT = eT;
    }

    private double calculateBonus() {
        // jeśli staż większy lub równy 5 lat i mniejszy lub równy 20 -> dodaj do pensji mExperience procent jej wartości
        if (mExperience >= 5) {
            // jeśli jest >= 20 to mnożnkiem zawsze jest 20
            if (mExperience >= 20)
                return (mSalary * 20 * 0.01);

            // jeśli z przedziału 5 - 20 to mnożnikiem jest mExperience
            return (mSalary * mExperience * 0.01);
        }
        else
            // jeśli mniejszy od 5 - bez stażowego
            return 0;
    }

    public double getBonus() {
        return calculateBonus();
    }
    // pełna pensja = podstawa plus dodatek
    public double grossSalary() {
        return getSalary() + calculateBonus();
    }


    // zaimplementować metodę abstrakcyjną
    // w main ma być tablica worker która ma używać jakiejś metody abstrakcyjnej

    public abstract String toString();


}
