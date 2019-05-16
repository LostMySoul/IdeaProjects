package omsu.javaprojects.lambda.predicates.lambdas;

@FunctionalInterface
public interface WordPredicate {
    Integer getWordCount(String s);
}
