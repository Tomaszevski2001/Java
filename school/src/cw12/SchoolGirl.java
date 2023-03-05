package cw12;

public class SchoolGirl extends Pupil{
    public SchoolGirl(String name, int age, String className) {
        super(name, age, className);
        super.mID = "F_" + super.getID();
    }

    public String printOutfit(){
        return "Biała bluzka, krawat, czarna spódnica";
    }
}
