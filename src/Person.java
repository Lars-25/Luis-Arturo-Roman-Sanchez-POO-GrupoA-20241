public class Person {
    public String name;
    public int age;
    public String gender;

    public Person(String name, int age, String gender) {
        this.name = name;   
        this.age = age;
        this.gender = gender;
    }
    public String getPersonInfo() {
        return String.format(
                "Name: %s, Age: %d, Gender: %s",
                 name, age, gender);
    }

}