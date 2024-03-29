import java.util.ArrayList;

public class animal_friend_list {
    private final ArrayList<animal_friend> animal_friend_list;

    public ArrayList<animal_friend> getAnimal_friend_list() {
        return animal_friend_list;
    }

    public animal_friend_list() {
        animal_friend_list = new ArrayList<>();

    }

    public animal_friend getAnimal_friend_list(int i) {
        return animal_friend_list.get(i);
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < animal_friend_list.size(); i++) {
            tmp.append(i).append(" ").append(animal_friend_list.get(i).get_animalFriend()).append(", ");
        }
        tmp.setLength(tmp.length() - 2);
        return tmp.toString();
    }

    public void add_animal_friend_to_list(animal_friend an) {
        animal_friend_list.add(an);
    }
}
