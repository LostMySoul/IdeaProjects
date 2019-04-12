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
            List<String> bobsPhones = phoneBook.get(human);
            bobsPhones.add(number);
            phoneBook.put(human, bobsPhones);
        }
    }

    public void deletePhone(String number) {
        Iterator<List<String>> iterValues = phoneBook.values().iterator();
        Iterator<Human> iterKeys = phoneBook.keySet().iterator();
        Human someRichard;
        List<String> allPhone;
        while (iterValues.hasNext()) {
            allPhone = iterValues.next();
            someRichard = iterKeys.next();
            if (allPhone.remove(number)) {
                phoneBook.put(someRichard, allPhone);
            }
        }
    }

    public List<String> getPhonesOfHuman(Human human) {
        return phoneBook.get(human);
    }

    public Human findHumanWithPhone(String number) {
        Human res = null;
        Iterator<List<String>> iterValues = phoneBook.values().iterator();
        Iterator<Human> iterKeys = phoneBook.keySet().iterator();
        Human temp;
        List<String> allPhone;
        boolean flag = true;
        while (iterValues.hasNext() && flag) {
            allPhone = iterValues.next();
            temp = iterKeys.next();
            if (allPhone.contains(number)) {
                flag = false;
                res = temp;
            }
        }
        return res;
    }

    public Map<Human, List<String>> getPhonesWithPeopleWhereSurnameStartsWith(String start) {
        Map<Human, List<String>> res = new HashMap<>();
        Iterator<Human> iterKeys = phoneBook.keySet().iterator();
        Human temp;
        while (iterKeys.hasNext()) {
            temp = iterKeys.next();
            if (temp.getSurname().length() > start.length() && temp.getSurname().startsWith(start)){
                res.put(temp, getPhonesOfHuman(temp));
            }
        }
        return res;
    }
}
