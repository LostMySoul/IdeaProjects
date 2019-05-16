package omsu.javaprojects.lambda.predicates.lambdas;

@FunctionalInterface
public interface LengthPredicate {
    Integer getStringLength(String str);
}
