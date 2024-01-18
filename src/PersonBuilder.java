
public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст должен быть неотрицательным числом");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Недостаточно данных (нет имени или фамилии)");
        }
        Person person;
        if (age > -1) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        if (address != null) {
            person.setAddress(address);
        }
        return person;
    }

}