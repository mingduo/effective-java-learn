package effectivejava;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Comparator;

/**
 * 
 * @description:
 * @since 2019/7/31
 * @author : weizc 
 */
public class CompareDemo {

    public static void main(String[] args) {
        Person person = new Person().setAge(12).setName("王嗯").setScore(96.1);

        Person person2 = new Person().setAge(12).setName("郎嗯").setScore(97.1);

        System.out.println("compareTo resullt : " + person.compareTo(person2) );
    }
}

@Accessors(chain = true)
@Data
class Person implements Comparable<Person>{
    String name;
    Integer age;
    Double score;

    static final Comparator<Person> PERSON_COMPARATOR=Comparator.comparingInt(Person::getAge)
            .thenComparing(Person::getName)
            .thenComparingDouble(Person::getScore);

    @Override
    public int compareTo(Person o) {
        return PERSON_COMPARATOR.compare(this,o);
    }
}
