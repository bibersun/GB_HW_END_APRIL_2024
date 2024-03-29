import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class fill {

    public static animal_friend_list start_animal_friend_list() {
        animal_friend_list afl = new animal_friend_list();
        afl.add_animal_friend_to_list(new animal_friend("Pets"));
        afl.add_animal_friend_to_list(new animal_friend("Pack_animals"));
        animal_friend.setId(0);
        return afl;
    }

    public static ArrayList<String> start_command_list() {
        return new ArrayList<>(Arrays.asList("Sit", "Pounce", "Scratch", "Roll", "Spin",
                "Stay", "Meow", "Jump", "Trot", "Canter", "Gallop", "Walk", "Carry Load", "Bray", "Kick",
                "Run", "Fetch", "Hide", "Paw", "Bark"));
    }

    public static animal_type_list start_animal_type() {
        animal_type_list atl = new animal_type_list();
        animal_friend_list afl = start_animal_friend_list();
        atl.add_animal_type_to_list(new animal_type("Dog", afl.getAnimal_friend_list(0)));
        atl.add_animal_type_to_list(new animal_type("Cat", afl.getAnimal_friend_list(0)));
        atl.add_animal_type_to_list(new animal_type("Hamster", afl.getAnimal_friend_list(0)));
        atl.add_animal_type_to_list(new animal_type("Horse", afl.getAnimal_friend_list(1)));
        atl.add_animal_type_to_list(new animal_type("Camel", afl.getAnimal_friend_list(1)));
        atl.add_animal_type_to_list(new animal_type("Donkey", afl.getAnimal_friend_list(1)));
        animal_type.setId(0);
        return atl;
    }

    public static animal_list start_animals() {
        animal_type_list atl = start_animal_type();
        ArrayList<String> cl = start_command_list();
        animal_list al = new animal_list();
        al.add_animal_to_list(new animal("Fido", LocalDate.parse("2011-01-01"), atl.getAnimal_type_list(0)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(0));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(5));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(16));
        al.add_animal_to_list(new animal("Whiskers", LocalDate.parse("2019-05-15"), atl.getAnimal_type_list(1)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(0));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(1));
        al.add_animal_to_list(new animal("Hammy", LocalDate.parse("2021-03-10"), atl.getAnimal_type_list(2)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(3));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(17));
        al.add_animal_to_list(new animal("Buddy", LocalDate.parse("2018-12-10"), atl.getAnimal_type_list(0)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(0));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(18));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(19));
        al.add_animal_to_list(new animal("Smudge", LocalDate.parse("2020-02-20"), atl.getAnimal_type_list(1)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(0));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(1));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(2));
        al.add_animal_to_list(new animal("Peanut", LocalDate.parse("2021-08-01"), atl.getAnimal_type_list(2)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(3));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(4));
        al.add_animal_to_list(new animal("Bella", LocalDate.parse("2019-11-11"), atl.getAnimal_type_list(0)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(0));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(5));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(3));
        al.add_animal_to_list(new animal("Oliver", LocalDate.parse("2020-06-30"), atl.getAnimal_type_list(1)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(6));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(2));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(7));
        al.add_animal_to_list(new animal("Thunder", LocalDate.parse("2015-07-21"), atl.getAnimal_type_list(3)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(8));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(9));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(10));
        al.add_animal_to_list(new animal("Sandy", LocalDate.parse("2016-11-03"), atl.getAnimal_type_list(4)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(11));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(12));
        al.add_animal_to_list(new animal("Eeyore", LocalDate.parse("2017-09-18"), atl.getAnimal_type_list(5)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(11));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(12));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(13));
        al.add_animal_to_list(new animal("Storm", LocalDate.parse("2014-05-05"), atl.getAnimal_type_list(3)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(8));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(9));
        al.add_animal_to_list(new animal("Dune", LocalDate.parse("2018-12-12"), atl.getAnimal_type_list(4)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(11));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(0));
        al.add_animal_to_list(new animal("Burro", LocalDate.parse("2019-01-23"), atl.getAnimal_type_list(5)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(11));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(13));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(14));
        al.add_animal_to_list(new animal("Blaze", LocalDate.parse("2016-02-29"), atl.getAnimal_type_list(3)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(8));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(7));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(10));
        al.add_animal_to_list(new animal("Sahara", LocalDate.parse("2015-08-14"), atl.getAnimal_type_list(4)));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(11));
        al.getAnimals().get(al.getAnimals().size() - 1).add_command(cl.get(15));
        return al;
    }


}
