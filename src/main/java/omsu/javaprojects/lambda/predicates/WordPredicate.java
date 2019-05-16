package omsu.javaprojects.lambda.predicates;
@FunctionalInterface
public interface WordPredicate {
    Integer getWordCount(String s);
}
