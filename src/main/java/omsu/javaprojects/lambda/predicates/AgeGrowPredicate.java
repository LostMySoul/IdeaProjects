package omsu.javaprojects.lambda.predicates;

import omsu.javaprojects.lambda.models.Human;

@FunctionalInterface
public interface AgeGrowPredicate {
    Human addYear(Human h);
}
