import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])

            );
        }
        long stream = persons.stream()
                .filter(x -> x.getAge() > 18)
                .count();

        List<String> stream1 = persons.stream()
                .filter(x -> x.getAge() > 18 & x.getAge() < 27)
                .filter(sex -> sex.getSex().equals(Sex.MAN))
                .map(Person::getFamily)
                .collect(toList());

        List<Person> finalList = persons.stream()
                .filter(ed -> ed.getEducation().equals(Education.HIGHER) && ed.getAge() > 18).toList();
        for (Person person : finalList) {
            if (person.getSex().equals(Sex.MAN) && person.getAge() < 65) {
                Comparator.comparing(Person::getFamily);
                toList();
            } else if (person.getSex().equals(Sex.WOMAN) && person.getAge() < 60) {
                Comparator.comparing(Person::getFamily);
                toList();
            }
        }
        ;
    }
}