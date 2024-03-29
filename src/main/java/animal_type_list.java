import java.util.ArrayList;

public class animal_type_list {
    private final ArrayList<animal_type> animal_type_list;

    public ArrayList<animal_type> getAnimal_type_list() {
        return animal_type_list;
    }

    public animal_type_list() {
        animal_type_list = new ArrayList<>();
    }

    public void add_animal_type_to_list(animal_type at) {
        animal_type_list.add(at);
    }

    public animal_type getAnimal_type_list(int i) {
        return animal_type_list.get(i);
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for (animal_type animalType : animal_type_list) {
            tmp.append(animalType).append(", ");
        }
        tmp.setLength(tmp.length() - 2);
        return tmp.toString();
    }
}
