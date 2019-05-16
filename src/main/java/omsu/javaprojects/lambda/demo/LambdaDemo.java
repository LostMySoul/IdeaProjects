package omsu.javaprojects.lambda.demo;

import omsu.javaprojects.lambda.models.Human;
import omsu.javaprojects.lambda.predicates.lambdas.AgeGrowPredicate;
import omsu.javaprojects.lambda.predicates.lambdas.AgePredicate;
import omsu.javaprojects.lambda.predicates.lambdas.FullNamePredicate;
import omsu.javaprojects.lambda.predicates.lambdas.LengthPredicate;
import omsu.javaprojects.lambda.predicates.lambdas.SpacePredicate;
import omsu.javaprojects.lambda.predicates.lambdas.SurnamePredicate;
import omsu.javaprojects.lambda.predicates.lambdas.SymbolPredicate;
import omsu.javaprojects.lambda.predicates.lambdas.WordPredicate;
import omsu.javaprojects.lambda.predicates.lambdas.YoungPredicate;

public class LambdaDemo {
    public static LengthPredicate lengthPredicate = String::length;
    public static SymbolPredicate symbolPredicate = (String s) -> {
        if (s == null || s.length() == 0) {
            return null;
        } else {
            return s.charAt(0);
        }
    };
    public static SpacePredicate spacePredicate = (String s) -> s.contains(" ");
    public static WordPredicate wordPredicate = (String s) -> s.isEmpty() ? null : s.split(",").length;
    public static AgePredicate agePredicate = Human::getAge;
    public static SurnamePredicate surnamePredicate = (Human p1, Human p2) -> p1.getSurname().equals(p2.getSurname());
    public static FullNamePredicate fullNamePredicate = (Human p) -> p.getFirstName() + ' ' + p.getSurname() + ' ' + p.getPatronymic();
    public static AgeGrowPredicate ageGrowPredicate = (Human p) -> new Human(p.getFirstName(), p.getSurname(), p.getPatronymic(), p.getSex(), p.getAge() + 1);
    public static YoungPredicate youngPredicate = (Human h1, Human h2, Human h3, int maxAge) -> h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge;
}
