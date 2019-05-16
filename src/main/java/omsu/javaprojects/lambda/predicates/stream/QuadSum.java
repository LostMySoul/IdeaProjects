package omsu.javaprojects.lambda.predicates.stream;

import java.util.Set;

@FunctionalInterface
public interface QuadSum {
    Integer get(Set<Integer> set);
}
