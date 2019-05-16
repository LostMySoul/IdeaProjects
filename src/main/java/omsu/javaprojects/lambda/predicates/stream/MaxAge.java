package omsu.javaprojects.lambda.predicates.stream;

import omsu.javaprojects.lambda.models.Human;

import java.util.Collection;

@FunctionalInterface
public interface MaxAge {
    Integer get(Collection<Human> collection);
}
