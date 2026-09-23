package tests.prop;

import org.junit.jupiter.api.Test;

//./gradlew clean test -Dname=Anya --tests "tests.prop.propertiesTests" запуск тестов с определенным параметром перед названием параметра -D
//если 2 слова то брать в кавычки "-Dname=Anya ukolova"
public class propertiesTests {
    @Test
    void propertyTest(){
        String environment = System.getProperty("environment");
        System.out.println("test environment is " + environment);
    }

    @Test
    void propertyNameTest(){
        String name = System.getProperty("name");
        System.out.println("My name is: " + name);
    }

    @Test
    void propertyBrowserTest(){
        String browser = System.getProperty("browser", "chome");
        System.out.println("Browser is: " + browser);
    }
}
