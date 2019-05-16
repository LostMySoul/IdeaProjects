package omsu.javaprojects.lambda.predicates;
@FunctionalInterface
public interface LengthPredicate {
    Integer getStringLength(String str);
}
