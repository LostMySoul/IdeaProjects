package omsu.javaprojects.lambda.predicates.stream;

import java.util.List;

@FunctionalInterface
public interface QuadSet {
    List<Integer> get(Integer[] list);
}
