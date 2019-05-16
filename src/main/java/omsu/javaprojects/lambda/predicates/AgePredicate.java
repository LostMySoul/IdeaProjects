package omsu.javaprojects.lambda.predicates;

import omsu.javaprojects.lambda.models.Human;

@FunctionalInterface
public interface AgePredicate<T extends Human> {
    Integer get(T person);
}
