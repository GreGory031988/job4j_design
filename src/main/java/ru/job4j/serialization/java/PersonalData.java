package ru.job4j.serialization.java;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personalData")
public class PersonalData {
    @XmlAttribute
    private int age;
    @XmlAttribute
    private boolean masterOfSport;

    public PersonalData() { }

    public PersonalData(int age, boolean masterOfSport) {
        this.age = age;
        this.masterOfSport = masterOfSport;
    }

    @Override
    public String toString() {
        return "PersonalData{"
                + "age=" + age
                + ", masterOfSport=" + masterOfSport
                + '}';
    }
}
