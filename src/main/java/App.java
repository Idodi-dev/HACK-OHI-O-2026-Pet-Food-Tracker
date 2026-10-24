import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        //"springboot.run()" which starts the localhost

        Database database = new Database();

        User ex1 = new User(database, "0", "0");

        System.out.println((ex1.getUserPets()));

        ArrayList<Reminder> reminders = new ArrayList<>();

        PetFood firstPetFood = new PetFood("DoggieFoo", false, 10.5, 5.9, 10);

        Pet firstPet = new Pet(ex1, "Rex", 0.25, 2, Pet.Animal.dog, firstPetFood, 0, 25.6, 5, 21, false, reminders);

        ex1.newPet(firstPet);
        firstPet.setFoodType(firstPetFood);

        System.out.println(ex1.getUserPets());

    }
}
