package ru.job4j.serialization.java;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "athlete")
@XmlAccessorType(XmlAccessType.FIELD)
public class Athlete {
    @XmlAttribute
    private boolean access;
    @XmlAttribute
    private int number;
    @XmlAttribute
    private String name;
    private PersonalData sportsman;
    @XmlElementWrapper(name = "results")
    @XmlElement(name = "result")
    private Double[] result;

    public Athlete() { }

    public Athlete(boolean access, int number, String name, PersonalData sportsman, Double... result) {
        this.access = access;
        this.number = number;
        this.name = name;
        this.sportsman = sportsman;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Athlete{"
                + "access=" + access
                + ", number=" + number
                + ", name='" + name + '\''
                + ", sportsman=" + sportsman
                + ", result=" + Arrays.toString(result)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        final Athlete athleteXML = new Athlete(true, 456, "Ivanov",
                new PersonalData(24, false),
                3.56, 4.15, 4.03);
        JAXBContext context = JAXBContext.newInstance(Athlete.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(athleteXML, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Athlete result = (Athlete) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
