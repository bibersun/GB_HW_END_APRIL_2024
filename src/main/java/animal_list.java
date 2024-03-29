import java.util.ArrayList;

public class animal_list {
    private final ArrayList<animal> animals = new ArrayList<>();

    public ArrayList<animal> getAnimals() {
        return animals;
    }

    public void add_animal_to_list(animal an) {
        animals.add(an);
    }

    public animal get_animal_by_id(int i) {
        return animals.get(i);
    }


    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for (animal animal : animals) {
            tmp
                    .append(animal.getInternal_int())
                    .append(" ")
                    .append(animal.getName_animal())
                    .append(" ")
                    .append(animal.getBirth_date())
                    .append(" ")
                    .append(animal.getAnimalType().to_string())
                    .append(" ")
                    .append(animal.getaCommand())
                    .append("\n");
        }

        return tmp.toString();
    }
}
