package omsu.javaprojects.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<Human, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addPhone(String number, Human human) {
        if (!phoneBook.containsKey(human)) {
            List<String> phones = new ArrayList<>();
            phones.add(number);
            phoneBook.put(human, phones);
        } else {
            phoneBook.get(human).add(number);
        }
    }

    public void deletePhone(String number) {
        Iterator<Human> iterKeys = phoneBook.keySet().iterator();
        while (iterKeys.hasNext()) {
            Human human = iterKeys.next();
            phoneBook.get(human).remove(number);
        }
    }

    public List<String> getPhonesOfHuman(Human human) {
        return phoneBook.get(human);
    }

    public Human findHumanWithPhone(String number) {
        Iterator<Human> iterKeys = phoneBook.keySet().iterator();
        while (iterKeys.hasNext()) {
            Human temp = iterKeys.next();
            List<String> allPhone = phoneBook.get(temp);
            if (allPhone.contains(number)) {
                return temp;
            }
        }
        return null;
    }

    public Map<Human, List<String>> getPhonesWithPeopleWhereSurnameStartsWith(String start) {
        if (start == null) {
            throw new IllegalArgumentException("start cannot be null");
        }
        Map<Human, List<String>> res = new HashMap<>();
        Iterator<Human> iterKeys = phoneBook.keySet().iterator();
        while (iterKeys.hasNext()) {
            Human temp = iterKeys.next();
            if (temp.getSurname().startsWith(start)) {
                res.put(temp, getPhonesOfHuman(temp));
            }
        }
        return res;
    }
}
