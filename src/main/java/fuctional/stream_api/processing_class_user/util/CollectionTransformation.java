package fuctional.stream_api.processing_class_user.util;



import fuctional.stream_api.processing_class_user.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionTransformation {

    /**
     * Example of Using Collectors
     * But of course its more complex than simply using constructors
     */

    public static  List<Employee> toLinkedList(Collection<Employee> collection) {
//        return (List<Employee>) collection.stream()
//                .collect(Collectors.toCollection(LinkedList::new));
        return new LinkedList<>(collection);
    }

    public static Set<Employee> toHashSet(Collection<Employee> collection) {
//        return (Set<Employee>) collection.stream()
//                .collect(Collectors.toCollection(HashSet::new));
        return new HashSet<>(collection);
    }
}
