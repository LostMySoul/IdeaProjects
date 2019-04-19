package omsu.javaprojects.demo;

import omsu.javaprojects.model.Human;

import java.util.*;
import java.util.stream.Collectors;


public class ListDemo {

    public static int getNumberOfStringWithChar(List<String> listOfString, char first) {
        int res = 0;
        for (int i = 0; i < listOfString.size(); i++) {
            if (listOfString.get(i) != null && !listOfString.get(i).equals("")) {
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
            Set<Integer> temp = new HashSet<>(setList.get(i));
            temp.retainAll(set);
            if (temp.size() == 0) {
                result.add(setList.get(i));
            }
        }
        return result;
    }

    public static Set<Integer> getIdOfFullAged(Map<Integer, Human> mapId) {
        Set<Integer> result = new HashSet<>();
        Iterator<Integer> iterKeys = mapId.keySet().iterator();
        int id;
        while (iterKeys.hasNext()) {
            id = iterKeys.next();
            if (mapId.get(id).getAge() >= 18) {
                result.add(id);
            }
        }
        return result;
    }

    public static List<Human> makeListFromSet(Set<Human> humanSet) {
        return humanSet.stream().sorted((o1, o2) -> {
            String fullname1 = o1.getSurname() + " " + o1.getName() + " " + o1.getPatronymic();
            String fullname2 = o2.getSurname() + " " + o2.getName() + " " + o2.getPatronymic();
            return fullname1.compareTo(fullname2);
        }).collect(Collectors.toList());
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
        List<Integer> keys = new ArrayList<>(humanMap.keySet());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), humanMap.get(keys.get(i)).getAge());
        }
        return map;
    }

    public static Map<Integer, List<Human>> getWithAge(Set<Human> humanSet) {
        Map<Integer, List<Human>> res = new HashMap<>();
        Iterator<Human> iter = humanSet.iterator();
        while (iter.hasNext()) {
            Human human = iter.next();
            List<Human> temp = res.get(human.getAge());
            if (temp == null) {
                temp = new ArrayList<>();
                temp.add(human);
                res.put(human.getAge(), temp);
            } else {
                temp.add(human);
            }
        }
        return res;
    }

    public static Map<Integer, Map<Character, List<Human>>> ageCharMap(Set<Human> humanSet) {
        Map<Integer, Map<Character, List<Human>>> res = new HashMap<>();
        Map<Integer, List<Human>> ageMap = getWithAge(humanSet);
        Iterator<Integer> keysIter = ageMap.keySet().iterator();
        while (keysIter.hasNext()) {
            int age = keysIter.next();
            Iterator<Human> temp = ageMap.get(age).iterator();
            while (temp.hasNext()) {
                Human human = temp.next();
                res.putIfAbsent(age, new HashMap<>());
                Map<Character, List<Human>> tempMap = res.get(age);
                char first = human.getSurname().charAt(0);
                tempMap.putIfAbsent(first, new ArrayList<>());
                List<Human> list = res.get(age).get(first);
                list.add(human);
                list.sort((o1, o2) -> {
                    String fullname1 = o1.getSurname() + " " + o1.getName() + " " + o1.getPatronymic();
                    String fullname2 = o2.getSurname() + " " + o2.getName() + " " + o2.getPatronymic();
                    return fullname2.compareTo(fullname1);
                });
            }
        }
        return res;
    }

}
