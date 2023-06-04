package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

    public List<String> listaEstudiantesNoPresentados(List<String> todos, List<String> presentados) {
        List<String> noPresentados = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < todos.size() && j < presentados.size()) {
            String estudianteTodos = todos.get(i);
            String estudiantePresentados = presentados.get(j);

            if (estudianteTodos.equals(estudiantePresentados)) {
                i++;
                j++;
            } else {
                noPresentados.add(estudianteTodos);
                i++;
            }
        }

        while (i < todos.size()) {
            noPresentados.add(todos.get(i));
            i++;
        }

        return noPresentados;
    }
}

