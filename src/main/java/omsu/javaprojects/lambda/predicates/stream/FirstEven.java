package omsu.javaprojects.lambda.predicates.stream;

import java.util.List;

@FunctionalInterface
public interface FirstEven {
    Integer get(List<Integer> list);
}
