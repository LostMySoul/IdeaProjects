package omsu.javaprojects.lambda.predicates;

@FunctionalInterface
public interface SymbolPredicate {
    Character getFirst(String s);
}
