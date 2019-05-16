package omsu.javaprojects.lambda.predicates.stream;

import omsu.javaprojects.lambda.models.Human;

import java.util.Collection;

public interface GenderAgeSorted {
    Collection<Human> get(Collection<Human> collection);
}
