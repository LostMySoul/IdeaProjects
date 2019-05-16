package omsu.javaprojects.lambda.predicates.stream;

import java.util.List;

@FunctionalInterface
public interface NotNullList {
    List<Object> get(List<Object> list);
}
