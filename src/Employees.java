// Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
public class Employees {
    private String name;
    String position;
    private String email;
    String phoneNumber;
    int salary;
    int age;

// Конструктор класса должен заполнять эти поля при создании объекта
    Employees (String name, String position, String email, String phoneNumber,int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    // Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    void information(){
        System.out.println("ФИО: " + name);
        System.out.println("Должность: " + position);
        System.out.println("Эл.адрес: " + email);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

