public class Main {

    public static void main(String[] args) {

        // Создать массив из 5 сотрудников
        Employees[] persArray = new Employees[5];
        persArray[0] = new Employees("Иванов Иван Иванович", "Менеджер", "ivanov@mail.ru", "234-56-78", 65000, 25);
        persArray[1] = new Employees("Сидоров Петр Михайлович", "Менеджер", "sidorov@mail.ru", "345-57-89", 70000, 37);
        persArray[2] = new Employees("Петрова Марья Ивановна", "Бухгалтер", "petrova@mail.ru", "123-45-67", 80000, 45);
        persArray[3] = new Employees("Климов Алексей Анатольевич", "Директор", "klimov@mail.ru", "456-78-90", 95000, 42);
        persArray[4] = new Employees("Пиманова Ольга Игоревна", "Администратор", "pimanova@mail.ru", "674-96-08", 40000, 22);

        // С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (Employees element : persArray) {
            if (element.age > 40) {
                element.information();
                System.out.println();
            }



//	    Employees firstEmployee = new Employees("Иванов Иван Иванович", "Менеджер", "ivanov@mail.ru", "234-56-78", 25, 65000);
//	    firstEmployee.name = "Иванов Иван Иванович";  - можно или так заводить каждого, или как на строке выше
//	    firstEmployee.email = "ivanov@mail.ru";
//	    firstEmployee.telefonNumber = "234-56-78";
//	    firstEmployee.salary = 65000;
// 	    firstEmployee.age = 25;

//     	Employees secondEmployee = new Employees("Сидоров Петр Михайлович","Менеджер","sidorov@mail.ru", "345-57-89", 70000, 37);
//        secondEmployee.name = "Сидоров Петр Михайлович";
//        secondEmployee.position = "Менеджер";
//        secondEmployee.email = "sidorov@mail.ru";
//        secondEmployee.telefonNumber = "345-57-89";
//        secondEmployee.salary = 70000;
//        secondEmployee.age = 37;

            //firstEmployee.information();
            //secondEmployee.information();

        }
    }
}