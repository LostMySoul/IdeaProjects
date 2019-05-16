package omsu.javaprojects.lambda.predicates.lambdas;

import omsu.javaprojects.lambda.models.Human;

public interface FullNamePredicate<T extends Human> {
    String get(T person);
}
