package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

    public List<String> listaEstudiantesNoPresentados(List<String> todos, List<String> presentados) {
        List<String> noPresentados = new ArrayList<>();

        for (String estudiante : todos) {
            if (!presentados.contains(estudiante)) {
                noPresentados.add(estudiante);
            }
        }

        return noPresentados;
    }
}

