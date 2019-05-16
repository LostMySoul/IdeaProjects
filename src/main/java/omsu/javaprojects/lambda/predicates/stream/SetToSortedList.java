package omsu.javaprojects.lambda.predicates.stream;

import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface SetToSortedList {
    List<String> get(Set<String> set);
}
