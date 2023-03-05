package cw12;

public class Person {
    private String mName; // first and second name
    private int mAge;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge = mAge;
    }
}
