package de.javaccok;

public class Person {

    private final String name;
    private boolean isMarried;

    public Person(String name, boolean isMarried) {
        this.name = name;
        this.isMarried = isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public String getName() {
        return name;
    }

    public boolean isMarried() {
        return isMarried;
    }
}
