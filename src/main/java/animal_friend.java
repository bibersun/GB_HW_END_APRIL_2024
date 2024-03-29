public class animal_friend {
    private final String animalFriend;
    private static int id = 0;
    private int internal_int;

    public static void setId(int id) {
        animal_friend.id = id;
    }

    public animal_friend(String animalFriend) {
        this.animalFriend = animalFriend;
        this.internal_int = id++;
    }

    public String get_animalFriend(){
        return animalFriend;
    }
    @Override
    public String toString() {
        return animalFriend;
    }
}
