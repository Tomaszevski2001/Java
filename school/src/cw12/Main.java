package cw12;

// ################## System obsługi szkoły ##################


/*
    Dodać klasy do reprezentacji pracowników: Teacher, Admin(pracownik administracji na przykłąd sekretarka)

    Najpierw dodać klasę Worker - pochodną od klasy Person i na bazie Worker dodać tamte
        pensja, staż pracy, etat

    Teacher -  imie nazwisko wiek
        przedmiot, staż pracy, etat(tak jak w Admin), pensja, czy jest wychowawcą klasy a jak tak to której
    Admin - imie nazwisko wiek
        pensja, staż pracy, etat(czy cały czy pół etatu czy umowa zlecenie)

    Oczywiście toString, metoda podajaca pensje brutto

    5<= staż pracy <= 20 daje % dodatku do pensji brutto
    pobranie brutto, stażowego (wartość), wartość sumaryczna

 */

public class Main {

    public static void main(String[] args) {

        Teacher t1 = new Teacher("Anna Ptak", 40, 12, 5000, employmentType.HALF_TIME, Subject.POLSKI, true, "3B");
        Teacher t2 = new Teacher("Jakub Koc", 30, 4, 4000, employmentType.FULL_TIME, Subject.ANGIELSKI, false, null);
        Admin a1 = new Admin("Michał Anic", 55, 25, 18000, employmentType.FULL_TIME, "BOSS");
        Admin a2 = new Admin("Aleksander Piec", 33, 15, 6000, employmentType.CONTINGENT_WORKER, "EDUCATION CONSULTANT");

        Worker[] workers = {t1, t2, a1, a2};

        for(Worker w : workers){
            System.out.println(w.toString());
            System.out.println("Base salary is: " + w.getSalary() + " Bonus is: " + w.getBonus() + " Full salary is: " + w.grossSalary());
            System.out.println();
        }

        SchoolBoy b1 = new SchoolBoy("Jan Kowalski", 17, "3A");
        b1.setmNote(Subject.MATEMATYKA, 4.0);
        b1.setmNote(Subject.FIZYKA, 4.5);
        b1.setmNote(Subject.POLSKI, 3.0);

        SchoolGirl g1 = new SchoolGirl("Alicja Król", 17, "3B");
        g1.setmNote(Subject.POLSKI, 4.5);
        g1.setmNote(Subject.CHEMIA, 4.0);

        SchoolGirl g2 = new SchoolGirl("Beata Sobota", 18, "4B");
        g2.setmNote(Subject.POLSKI, 4.0);
        g2.setmNote(Subject.MATEMATYKA, 3.0);
        g2.setmNote(Subject.FIZYKA, 3.5);
        g2.setmNote(Subject.CHEMIA, 4.0);
        g2.setmNote(Subject.ANGIELSKI, 4.0);

        SchoolGirl g3 = new SchoolGirl("Katarzyna Nowak", 18, "4B");
        g3.setmNote(Subject.ANGIELSKI, 4.5);
        g3.setmNote(Subject.POLSKI, 4.0);
        g3.setmNote(Subject.FIZYKA, 3.5);
        g3.setmNote(Subject.CHEMIA, 4.0);

        Pupil[] p = {b1, g1, g2, g3};

        calcAve(p);
        printPupil(p);
    }

    private static void calcAve(Pupil[] p ) {
        for(int i=0; i<p.length; i++) {
            p[i].calcAve();
        }
    }

    private static void printPupil(Pupil[] p ) {
        for(Pupil pupil: p) {
            System.out.print(pupil.toString() + " ---- ");
            pupil.printOutfit();
            System.out.println();

        }
    }
}
