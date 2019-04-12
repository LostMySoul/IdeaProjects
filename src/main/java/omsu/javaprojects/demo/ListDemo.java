package omsu.javaprojects.demo;

import omsu.javaprojects.model.Human;

import java.util.*;
import java.util.stream.Collectors;


public class ListDemo {

    public static int getNumberOfStringWithChar(List<String> listOfString, char first) {
        int res = 0;
        for (int i = 0; i < listOfString.size(); i++) {
            if (!listOfString.get(i).equals("")) {
                if (first == listOfString.get(i).charAt(0)) {
                    res++;
                }
            }
        }
        return res;
    }
    public static List<Human> getListSameSurname(List<Human> humanList, Human human) {
        List<Human> result = new ArrayList<>();
        int pos = 0;
        for (int i = 0; i < humanList.size(); i++) {
            if (humanList.get(i).getSurname().equals(human.getSurname())) {
                result.add(pos, new Human(humanList.get(i)));
                pos++;
            }
        }
        return result;
    }
    public static List<Human> getListExcludeOne(List<Human> humanList, Human human) {
        List<Human> result = new ArrayList<>();
        int pos = 0;
        for (int i = 0; i < humanList.size(); i++) {
            if (!human.equals(humanList.get(i))) {
                result.add(pos, new Human(humanList.get(i)));
                pos++;
            }
        }
        return result;
    }
    public static List<Set<Integer>> removeIntersectSets(List<Set<Integer>> setList, Set<Integer> set) {
        List<Set<Integer>> result = new ArrayList<>();
        int pos = 0;
        boolean flag = true;
        Iterator<Integer> iter;
        for (int i = 0; i < setList.size(); i++) {
            iter = setList.get(i).iterator();
            while (iter.hasNext() && flag) {
                if (set.contains(iter.next())) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(pos, setList.get(i));
                pos++;
            }
            flag = true;
        }
        return result;
    }
    public static Set<Integer> getIdOfFullAged(Map<Integer, Human> mapId) {
        Set<Integer> result = new HashSet<>();
        Iterator<Human> iterValues = mapId.values().iterator();
        Iterator<Integer> iterKeys = mapId.keySet().iterator();
        Human temp;
        int id;
        while (iterValues.hasNext()) {
            temp = iterValues.next();
            id = iterKeys.next();
            if (temp.getAge() >= 18) {
                result.add(id);
            }
        }
        return result;
    }
    public static List<Human> makeListFromSet(Set<Human> humanSet) {
        List<Human> result = new ArrayList<>();
        int pos = 0;
        int numberOfElem = 0;
        boolean flag = true;
        Iterator<Human> iter = humanSet.iterator();
        Human someJohn;
        while (iter.hasNext()) {
            if (result.isEmpty()) {
                result.add(0, iter.next());
                numberOfElem++;
            } else {
                someJohn = iter.next();
                while (flag) {

                    if (result.get(pos).getSurname().compareTo(someJohn.getSurname()) > 0) {
                        result.add(pos, someJohn);
                        flag = false;
                        numberOfElem++;
                    } else {
                        if ((result.get(pos).getSurname().compareTo(someJohn.getSurname()) == 0) &&
                                result.get(pos).getName().compareTo(someJohn.getName()) > 0) {
                            result.add(pos, someJohn);
                            flag = false;
                            numberOfElem++;
                        } else {
                            if (result.get(pos).getSurname().compareTo(someJohn.getSurname()) == 0 &&
                                    result.get(pos).getName().compareTo(someJohn.getName()) == 0 &&
                                    result.get(pos).getPatronymic().compareTo(someJohn.getPatronymic()) > 0) {
                                result.add(pos, someJohn);
                                flag = false;
                                numberOfElem++;
                            } else {
                                if (result.get(pos).getSurname().compareTo(someJohn.getSurname()) == 0 &&
                                        result.get(pos).getName().compareTo(someJohn.getName()) == 0 &&
                                        result.get(pos).getPatronymic().compareTo(someJohn.getPatronymic()) == 0) {
                                    result.add(pos, someJohn);
                                    flag = false;
                                    numberOfElem++;
                                }
                            }
                        }
                    }
                    pos++;
                    if (pos == numberOfElem) {
                        result.add(pos, someJohn);
                        flag = false;
                        numberOfElem++;
                    }
                }
                flag = true;
                pos = 0;
            }
        }
        return result;
    }
    public static Set<Human> identifyHumans(Map<Integer, Human> mapId, Set<Integer> setOfId) {
        Set<Human> result = new HashSet<>();
        Iterator<Integer> itr = setOfId.iterator();
        int id;
        while (itr.hasNext()) {
            id = itr.next();
            if (mapId.get(id) != null) {
                result.add(mapId.get(id));
            }
        }
        return result;
    }
    public static Set<Human> getSetOfOldest(List<Human> humanList) {
        Set<Human> result = new HashSet<>();
        int maxAge = 0;
        for (int i = 0; i < humanList.size(); i++) {
            if (maxAge < humanList.get(i).getAge()) {
                result.clear();
                maxAge = humanList.get(i).getAge();
                result.add(humanList.get(i));
            }
            if (maxAge == humanList.get(i).getAge()) {
                result.add(humanList.get(i));
            }
        }
        return result;
    }
    public static Map<Integer, Integer> getIdAgeMap(Map<Integer, Human> humanMap) {
        List<Human> hlist = new ArrayList<>(humanMap.values());
        List<Integer> keys = new ArrayList<>(humanMap.keySet());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hlist.size(); i++) {
            map.put(keys.get(i), hlist.get(i).getAge());
        }
        return map;
    }
    public static List<Human> getWithAge(Set<Human> humanSet, int age) {
        return humanSet.stream().filter(man -> man.getAge() == age)
                .sorted((o1, o2) -> o1.getSurname().compareTo(o2.getSurname())).collect(Collectors.toList());
    }
}
