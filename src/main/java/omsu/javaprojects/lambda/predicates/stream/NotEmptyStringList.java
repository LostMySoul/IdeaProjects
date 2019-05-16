package omsu.javaprojects.lambda.predicates.stream;

import java.util.List;

@FunctionalInterface
public interface NotEmptyStringList {
    List<String> get(List<String> list);
}
