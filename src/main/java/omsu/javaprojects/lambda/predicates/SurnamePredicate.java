package omsu.javaprojects.lambda.predicates;

import omsu.javaprojects.lambda.models.Human;

@FunctionalInterface
public interface SurnamePredicate<T extends Human> {
    Boolean hasSame(T p1, T p2);
}
