package cw12;

public class SchoolBoy extends Pupil {

    public SchoolBoy(String name, int age, String className) {
        super(name, age, className);
        mID = "M_" + getID();
    }

    public String printOutfit() {
        return "Biała koszula, krawat, marynarka, granatowe/czarne spodnie";
    }
}
