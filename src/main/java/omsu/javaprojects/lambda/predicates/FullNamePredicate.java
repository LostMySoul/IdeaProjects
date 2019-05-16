package omsu.javaprojects.lambda.predicates;

import omsu.javaprojects.lambda.models.Human;

public interface FullNamePredicate<T extends Human> {
    String get(T person);
}
