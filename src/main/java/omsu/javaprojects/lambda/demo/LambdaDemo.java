package omsu.javaprojects.lambda.demo;

import omsu.javaprojects.lambda.models.Human;
import omsu.javaprojects.lambda.runner.func.FourFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaDemo {
    public static Function<String, Integer> lengthPredicate = String::length;
    public static Function<String, Character> symbolPredicate = (String s) -> {
        if (s == null || s.length() == 0) {
            return null;
        } else {
            return s.charAt(0);
        }
    };
    public static Function<String, Boolean> spacePredicate = (String s) -> !s.contains(" ");
    public static Function<String, Integer> wordPredicate = (String s) -> s.isEmpty() ? null : s.split(",").length;
    public static Function<Human, Integer> agePredicate = Human::getAge;
    public static BiFunction<Human, Human, Boolean> surnamePredicate =
            (Human p1, Human p2) -> p1.getSurname().equals(p2.getSurname());
    public static Function<Human, String> fullNamePredicate =
            (Human p) -> p.getFirstName() + ' ' + p.getSurname() + ' ' + p.getPatronymic();
    public static Function<Human, Human> ageGrowPredicate =
            (Human p) -> new Human(p.getFirstName(), p.getSurname(), p.getPatronymic(), p.getSex(), p.getAge() + 1);
    public static FourFunction<Human, Human, Human, Integer, Boolean> youngPredicate =
            (Human h1, Human h2, Human h3, Integer maxAge) -> h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge;
}
