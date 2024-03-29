import java.time.LocalDate;
import java.util.HashSet;

public class animal {
    private static int id = 0;
    private final int internal_int;
    private final String name_animal;
    private final LocalDate birth_date;
    private final animal_type animalType;
    private final HashSet<String> aCommand = new HashSet<>();

    public static int getId() {
        return id;
    }

    public int getInternal_int() {
        return internal_int;
    }

    public String getName_animal() {
        return name_animal;
    }

    public animal_type getAnimalType() {
        return animalType;
    }

    public HashSet<String> getaCommand() {
        return aCommand;
    }

    public animal(String name_animal, LocalDate birth_date, animal_type animalType) {
        this.internal_int = id++;
        this.name_animal = name_animal;
        this.birth_date = birth_date;
        this.animalType = animalType;
    }

    public void add_command(String command) {
        aCommand.add(command);
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    @Override
    public String toString() {
        return internal_int + ", " + name_animal + ", " + birth_date + ", " + animalType.to_string() + ", " + aCommand;
    }
}
