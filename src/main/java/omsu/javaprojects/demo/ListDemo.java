package omsu.javaprojects.demo;

import omsu.javaprojects.model.Human;

import java.util.*;
import java.util.stream.Collectors;


public class ListDemo {
    //1
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

    //2
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

    //3
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

    //4
    public static List<Set<Integer>> removeIntersectSets(List<Set<Integer>> setList, Set<Integer> set) {
        List<Set<Integer>> result = new ArrayList<>();
        for (int i = 0; i < setList.size(); i++) {
            Set<Integer> temp = new HashSet<>(setList.get(i));
            temp.retainAll(set); //retainAll удаляет все элементы из temp, который не содержатся в set
            if (temp.size() == 0) {
                result.add(setList.get(i));
            }
        }
        return result;
    }

    //5
    public static Set<Human> getSetOfOldest(List<Human> humanList) {
        Set<Human> result = new HashSet<>();
        int maxAge = 0;
        for (int i = 0; i < humanList.size(); i++) {
            if (maxAge < humanList.get(i).getAge()) {
                result.clear();
                maxAge = humanList.get(i).getAge();
            }
            if (maxAge == humanList.get(i).getAge()) {
                result.add(humanList.get(i));
            }
        }
        return result;
    }

    //7
    public static Set<Human> identifyHumans(Map<Integer, Human> mapId, Set<Integer> setOfId) {
        Set<Human> result = new HashSet<>();
        for (Integer id : setOfId) {
            if (mapId.get(id) != null) {
                result.add(mapId.get(id));
            }
        }
        return result;
    }

    //8
    public static Set<Integer> getIdOfFullAged(Map<Integer, Human> mapId) {
        Set<Integer> result = new HashSet<>();
        for(Integer id: mapId.keySet()){
            if (mapId.get(id).getAge() >= 18) {
                result.add(id);
            }
        }
        return result;
    }

    //9
    public static Map<Integer, Integer> getIdAgeMap(Map<Integer, Human> humanMap) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer id: humanMap.keySet()){
            map.put(id, humanMap.get(id).getAge());
        }
        return map;
    }

    //10
    public static Map<Integer, List<Human>> getWithAge(Set<Human> humanSet) {
        Map<Integer, List<Human>> res = new HashMap<>();
        for(Human human: humanSet){
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
}
