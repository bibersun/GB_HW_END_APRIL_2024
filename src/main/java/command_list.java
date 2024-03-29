import java.util.ArrayList;

public record command_list(ArrayList<String> a_command) {

    public void add_command_to_list(String s) {
        if (!a_command.contains(s)) {
            a_command.add(s);
//            System.out.println(a_command.size());
            System.out.println(a_command);
            System.out.println("команда " + s + " добавлена в список доступных команд");
        } else {
            System.out.println("Попытка добавления команды " + s + " - такая команда уже есть");
        }
    }

    @Override
    public String toString() {
        return String.join(" ", (a_command.toString() + "\n"));
    }

    public String to_string() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < a_command.size(); i++) {
            s.append(i).append(" ").append(a_command.get(i)).append(", ");
        }
        s.setLength(s.length() - 2);
        return s.toString();
    }
}
