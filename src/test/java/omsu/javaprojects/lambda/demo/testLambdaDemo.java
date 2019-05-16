package omsu.javaprojects.lambda.demo;

import omsu.javaprojects.lambda.demo.LambdaDemo;
import omsu.javaprojects.lambda.models.Gender;
import omsu.javaprojects.lambda.models.Human;
import omsu.javaprojects.lambda.models.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class testLambdaDemo {

    @Test
    public void testLengthPredicate() {
        assertEquals(LambdaDemo.lengthPredicate.getStringLength("50000"), new Integer(5));
        assertEquals(LambdaDemo.lengthPredicate.getStringLength("String"), new Integer(6));
        assertEquals(LambdaDemo.lengthPredicate.getStringLength(""), new Integer(0));
    }

    @Test
    public void testSymbolPredicate() {
        assertEquals(LambdaDemo.symbolPredicate.getFirst("50000"), new Character('5'));
        assertEquals(LambdaDemo.symbolPredicate.getFirst("String"), new Character('S'));
        assertNull(LambdaDemo.symbolPredicate.getFirst(""));
    }

    @Test
    public void testSpacePredicate() {
        assertTrue(LambdaDemo.spacePredicate.hasSpacing(" "));
        assertTrue(LambdaDemo.spacePredicate.hasSpacing("has space"));
        assertTrue(LambdaDemo.spacePredicate.hasSpacing("hasSpaceAtEnd "));
        assertFalse(LambdaDemo.spacePredicate.hasSpacing("NoSpace"));
    }

    @Test
    public void testWordPredicate() {
        assertEquals(LambdaDemo.wordPredicate.getWordCount("three, words,here"), new Integer(3));
        assertEquals(LambdaDemo.wordPredicate.getWordCount("four, words,is,here"), new Integer(4));
        assertEquals(LambdaDemo.wordPredicate.getWordCount("no delimeters"), new Integer(1));
        assertEquals(LambdaDemo.wordPredicate.getWordCount("at end,"), new Integer(1));
        assertNull(LambdaDemo.wordPredicate.getWordCount(""));
    }

    @Test
    public void testAgePredicate() {
        assertEquals(LambdaDemo.agePredicate.get(new Human("A", "A", "A", Gender.FEMALE, 18)), new Integer(18));
        assertEquals(LambdaDemo.agePredicate.get(new Student("B", "B", "B", Gender.MALE, 24, "B", "B", "B")), new Integer(24));
    }

    @Test
    public void testSurnamePredicate() {
        assertTrue(LambdaDemo.surnamePredicate.hasSame(new Human("B", "AAA", "B", Gender.FEMALE, 18),
                new Human("A", "AAA", "A", Gender.MALE, 20)));
    }

    @Test
    public void testFullNamePredicate() {
        assertEquals(LambdaDemo.fullNamePredicate.get(new Human("AAA", "AAA", "AAA", Gender.FEMALE, 18)), "AAA AAA AAA");
        assertEquals(LambdaDemo.fullNamePredicate.get(new Student("BBB", "BBB", "BBB", Gender.MALE, 24, "B", "B", "B")), "BBB BBB BBB");
    }

    @Test
    public void testAgeGrowPredicate() {
        assertEquals(LambdaDemo.ageGrowPredicate.addYear(new Human("AAA", "AAA", "AAA", Gender.FEMALE, 18)).getAge(), 19);
        assertEquals(LambdaDemo.ageGrowPredicate.addYear(new Human("AAA", "AAA", "AAA", Gender.MALE, 35)).getAge(), 36);
    }

    @Test
    public void testYoungPredicate() {
        Human[] arr = {
                new Human("AAA", "AAA", "AAA", Gender.MALE, 35),
                new Human("BBB", "BBB", "BBB", Gender.MALE, 23),
                new Human("CCC", "CCC", "CCC", Gender.MALE, 13)
        };
        assertTrue(LambdaDemo.youngPredicate.isAllYounger(arr[0],arr[1],arr[2],36));
        assertFalse(LambdaDemo.youngPredicate.isAllYounger(arr[0],arr[1],arr[2],22));
        assertTrue(LambdaDemo.youngPredicate.isAllYounger(arr[0],arr[1],arr[2],40));
        assertFalse(LambdaDemo.youngPredicate.isAllYounger(arr[0],arr[1],arr[2],3));
    }
}
