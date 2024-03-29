public class animal_type {
    private final String animalType;
    private final animal_friend af;
    private static int id = 0;
    private final int internal_int;

    public static void setId(int id) {
        animal_type.id = id;
    }

    public animal_type(String animalType, animal_friend af) {
        this.animalType = animalType;
        this.af = af;
        this.internal_int = id++;
    }

    @Override
    public String toString() {
        return internal_int + " " + animalType + " " + af;
    }

    public String to_string() {
        return animalType + " " + af;
    }


}
