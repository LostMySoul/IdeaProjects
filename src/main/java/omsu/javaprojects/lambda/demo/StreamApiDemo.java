package omsu.javaprojects.lambda.demo;

import omsu.javaprojects.lambda.models.Human;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiDemo {
    public static Function<List<Object>, List<Object>> removeNull = (List<Object> list) ->
            list.stream().filter(Objects::nonNull).collect(Collectors.toList());

    public static Function<Set<Integer>, Long> positiveCount = (Set<Integer> list) ->
            list.stream().filter(value -> value > 0).count();

    public static Function<List<Object>, List<Object>> lastElements = (List<Object> list) ->
            list.stream().skip(Math.max(0, list.size() - 3)).collect(Collectors.toList());

    public static Function<List<Integer>, Integer> firstEven = (List<Integer> list) ->
            list.stream().filter(item -> item % 2 == 0).findAny().orElse(null);

    public static Function<Integer[], List<Integer>> quadSet = (Integer[] list) ->
            Arrays.stream(list).distinct().map(item -> item * item).collect(Collectors.toList());

    public static Function<List<String>, List<String>> notEmptyStringList = (List<String> list) ->
            list.stream().filter((item) -> !item.isEmpty()).sorted(Comparator.naturalOrder()).collect(Collectors.toList());

    public static Function<Set<String>, List<String>> setToSortedList = (Set<String> set) ->
            set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    public static Function<Set<Integer>, Integer> quadSum = (Set<Integer> set) ->
            set.stream().map(item -> item * item).mapToInt(Integer::intValue).sum();

    public static Function<Collection<Human>, Integer> maxAge = (Collection<Human> collection) ->
            collection.stream().mapToInt(Human::getAge).max().orElseThrow(NoSuchElementException::new);

    public static Function<Collection<Human>, Collection<Human>> genderAgeSorted = (Collection<Human> collection) ->
            collection.stream().sorted(Comparator.comparing(Human::getSex).thenComparing(Human::getAge)).collect(Collectors.toList());
}
