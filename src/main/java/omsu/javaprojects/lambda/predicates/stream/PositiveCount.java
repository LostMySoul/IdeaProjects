package omsu.javaprojects.lambda.predicates.stream;

import java.util.Set;

@FunctionalInterface
public interface PositiveCount {
    long get(Set<Integer> list);
}
