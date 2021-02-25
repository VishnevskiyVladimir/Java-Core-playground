package fuctional.stream_api.processing_class_user;



import fuctional.stream_api.processing_class_user.util.CollectionTransformation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    static Employee p1 = new ItSpecialist(22,"Anna", "Kiseleva",new Address("Moscow","Gagarina",100,35),new BigDecimal("60000.0"));
    static Employee p2 = new ItSpecialist(10,"Anna", "Li",new Address("Moscow","Gagarina",25,36),new BigDecimal("120000.0"));
    static Employee p3 = new ItSpecialist(88,"Olga", "Kiseleva",new Address("Moscow","Lenina",13,23),new BigDecimal("70000.0"));
    static Employee p4 = new ItSpecialist(25,"Oleg", "Li",new Address("Kazan","Lenina",14,35),new BigDecimal("90000.0"));
    static Employee p5 = new ItSpecialist(59,"Ivan", "Yuldibayev",new Address("Kazan","Koneva",23,44),new BigDecimal("130000.0"));
    static Employee p6 = new ItSpecialist(44,"Igor", "Konev",new Address("SPb","Koneva",135,1),new BigDecimal("180000.0"));
    static Employee p7 = new ItSpecialist(35,"Anton", "Jang",new Address("SPb","Slavi",110,35),new BigDecimal("230000.0"));
    static Employee p8 = new Manager(29,"Boris", "Kvon",new Address("Kazan","Pobedi",123,4),new BigDecimal("13000.0"));
    static Employee p9 = new Manager(76,"Dmitriy", "Borisov",new Address("SPb","Pobedi",5,11),new BigDecimal("380000.0"));
    static Employee p10 = new Manager(55,"Vlad", "Ivanov",new Address("Moscow","Pobedi",11,325),new BigDecimal("50000.0"));
    static Employee[] array = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};
    static List<Employee> list = new ArrayList<>();

    static {

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);
    }

    public static void main(String[] args) {

        //list.stream()                     //creation stream out of Collection
        //Arrays.stream(array)              //creation stream out of Array
        Stream.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10)     //creation stream out of objects


                                    //FILTERING    .filter()
//                .filter(itSpecialist -> itSpecialist.getAge() > 30) //filtering by int field
                //.filter(person -> person.getAddress().getCity().equals("Moscow")) //filtering by String field
                //.filter(person -> person.getAddress().getCity().matches("Mo.*")) //filtering by String field using regex

                                    //SORTING       .sorted()

                //.sorted()// if class implements Comparable (Person doesn't)
                //.sorted((s1,s2) -> s1.getName().compareTo(s2.getName()))//by string field ASC order
                //.sorted((s1,s2) -> s2.getName().compareTo(s1.getName()))//by string field DESC order
                //.sorted((s1,s2) -> s1.getAge().compareTo(s2.getAge()))//by Integer field ASC order
                //.sorted((s1,s2) -> s2.getAge().compareTo(s1.getAge()))//by Integer field DESC order
                //.sorted(Comparator.comparingInt(Person::getAge))//by primitive type/wrapper  field ASC order
                //.sorted(Comparator.comparingInt(Person::getAge).reversed())//by primitive type/wrapper  field DESC order
                //.map(Person::getAge).sorted() //sorting stream of Integer ASC
                //.map(Person::getAge).sorted(Comparator.reverseOrder()) //sorting stream of Integer DESC

                //Сортировка по полю вложенного класса processing_class_user.Address (Думаю вохможно нужна вложенная Lambda) Разберись!!


                                    //                .forEach()
                .forEach(System.out::println);

    }

    static void transformCollection () {
        System.out.println("==============================");

        //List<Employee> newCollection = CollectionTransformation.toLinkedList(list);
        Set<Employee> newCollection = CollectionTransformation.toHashSet(list);
        System.out.println(newCollection.getClass());
        System.out.println(newCollection);
    }



}
