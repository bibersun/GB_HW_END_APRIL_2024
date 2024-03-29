import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class Program {
    public static void main(String[] args) {
//        инициализация значениями из задачи
        animal_friend_list afl = fill.start_animal_friend_list();
        command_list cl = new command_list(fill.start_command_list());
        animal_type_list atl = fill.start_animal_type();
        animal_list al = fill.start_animals();

//        ************************
        Scanner scanner = new Scanner(System.in);
        boolean tmp = true;
        while (tmp) {
            System.out.println("Наберите пункт меню и нажмите Enter");
            System.out.println("""
                    1 - вывод реестра животных
                    2 - вывод всех команд животных
                    3 - добавление возможной команды в список
                    4 - добавление команды животному
                    5 - добавление нового животного
                    6 - вывод всех команд животного
                    7 - вывод реестра с сортировкой по дате рождения
                    8 - вывод всех типов животных
                    9 - добавление типа животного
                    10 - вывод всех видов животных
                    11 - добавление вида животного
                    0 - выйти
                    """
            );
            switch (scanner.nextInt()) {
                case (0) -> tmp = false;
                case (1) -> System.out.println(al);
                case (2) -> System.out.println(cl.to_string());
                case (3) -> {
                    System.out.print("Введите текст новой команды: ");
                    cl.add_command_to_list(scanner.next());
//                    System.out.println(cl.to_string());
                }
                case (4) -> {
                    System.out.println(al);
                    System.out.print("Введите номер животного: ");
                    int number = scanner.nextInt();
                    System.out.println(cl.to_string());
                    System.out.println("Введите номер добавляемой команды: ");
                    int aa_command = scanner.nextInt();
                    if (number >= 0 && number < al.getAnimals().size() && aa_command >= 0 && aa_command < cl.a_command().size()) {
                        al.getAnimals().get(number).add_command(cl.a_command().get(aa_command));
                        System.out.println(al.getAnimals().get(number));
                    }
                }
                case (5) -> {
                    System.out.println("Введите имя животного: ");
                    String nm = scanner.next();
                    System.out.println(atl);
                    System.out.println("Введите тип животного: ");
                    int type = scanner.nextInt();
                    System.out.println("Введите дату рождения животного в формате YYYY-DD-MM: ");
                    String b_d = scanner.next();
                    if (type >= 0 && type < atl.getAnimal_type_list().size()) {
                        try {
                            al.add_animal_to_list(new animal(nm, LocalDate.parse(b_d), atl.getAnimal_type_list(type)));
                            System.out.println(al);
                        } catch (DateTimeException e) {
                            System.out.println("Введена неправильная дата");
                        }

                    }
                }
                case (6) -> {
                    System.out.println(al);
                    System.out.print("Введите номер животного: ");
                    int number = scanner.nextInt();
                    if (number < al.getAnimals().size() && number >= 0) {
                        System.out.print("Животное " + al.get_animal_by_id(number).getName_animal() + " умеет ");
                        System.out.println(al.get_animal_by_id(number).getaCommand().toString());
                    }
                }

                case (7) -> {
                    List<animal> s =
                            al.getAnimals().stream().sorted(Comparator.comparing(animal::getBirth_date)).toList();
                    StringBuilder sb = new StringBuilder();
                    for (animal animal : s) {
                        sb.append(animal.getInternal_int())
                                .append(", ")
                                .append(animal.getName_animal())
                                .append(", ")
                                .append(animal.getBirth_date())
                                .append(", ")
                                .append(animal.getAnimalType().to_string())
                                .append(", ")
                                .append(animal.getaCommand())
                                .append("\n");
                    }
                    System.out.println(sb);

                }
                case (8) -> {
                    System.out.println(afl);
                }

                case (9) -> {
                    System.out.print("Введите текст нового типа животного: ");
                    afl.add_animal_friend_to_list(new animal_friend(scanner.next()));
                    System.out.println(afl);
                }
                case (10) -> {
                    System.out.println(atl);
                }
                case (11) -> {
                    System.out.println(afl);
                    System.out.print("Сначала выберите тип животного: ");
                    int type = scanner.nextInt();
                    if (type >= 0 && type < afl.getAnimal_friend_list().size()) {
                        System.out.print("Введите текст нового вида животного: ");
                        atl.add_animal_type_to_list(new animal_type(scanner.next(), afl.getAnimal_friend_list(type)));
                        System.out.println(atl);
                    } else System.out.print("Введён некорректный номер типа животного");
                }
            }
        }
    }
}

