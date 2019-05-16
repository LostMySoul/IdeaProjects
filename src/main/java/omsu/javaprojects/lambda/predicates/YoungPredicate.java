package omsu.javaprojects.lambda.predicates;

import omsu.javaprojects.lambda.models.Human;

@FunctionalInterface
public interface YoungPredicate {
    Boolean isAllYounger(Human h1, Human h2, Human h3, int maxAge);
}
