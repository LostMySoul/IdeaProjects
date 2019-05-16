package omsu.javaprojects.lambda.demo;

import omsu.javaprojects.lambda.models.Human;
import omsu.javaprojects.lambda.predicates.stream.FirstEven;
import omsu.javaprojects.lambda.predicates.stream.GenderAgeSorted;
import omsu.javaprojects.lambda.predicates.stream.LastElements;
import omsu.javaprojects.lambda.predicates.stream.MaxAge;
import omsu.javaprojects.lambda.predicates.stream.NotEmptyStringList;
import omsu.javaprojects.lambda.predicates.stream.NotNullList;
import omsu.javaprojects.lambda.predicates.stream.PositiveCount;
import omsu.javaprojects.lambda.predicates.stream.QuadSet;
import omsu.javaprojects.lambda.predicates.stream.QuadSum;
import omsu.javaprojects.lambda.predicates.stream.SetToSortedList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiDemo {
    public static NotNullList removeNull = (List<Object> list) ->
            list.stream().filter(value -> value != null).collect(Collectors.toList());
    public static PositiveCount positiveCount = (Set<Integer> list) ->
            list.stream().filter(value -> value > 0).count();
    public static LastElements lastElements = (List<Object> list) ->
            list.stream().skip(Math.max(0, list.size() - 3)).collect(Collectors.toList());
    public static FirstEven firstEven = (List<Integer> list) ->
            list.stream().filter(item -> item % 2 == 0).findAny().orElse(null);
    public static QuadSet quadSet = (Integer[] list) ->
            Arrays.stream(list).distinct().map(item -> item * item).collect(Collectors.toList());
    public static NotEmptyStringList notEmptyStringList = (List<String> list) ->
            list.stream().filter((item) -> !item.isEmpty()).collect(Collectors.toList());
    public static SetToSortedList setToSortedList = (Set<String> set) ->
            set.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    public static QuadSum quadSum = (Set<Integer> set) ->
            set.stream().map(item -> item * item).mapToInt(Integer::intValue).sum();
    public static MaxAge maxAge = (Collection<Human> collection) ->
            collection.stream().mapToInt(Human::getAge).max().orElseThrow(NoSuchElementException::new);
    public static GenderAgeSorted genderAgeSorted = (Collection<Human> collection)->
            collection.stream().sorted(Comparator.comparing(Human::getSex).thenComparing(Human::getAge)).collect(Collectors.toList());
}
