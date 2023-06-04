package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class Ejercicio2Test {

	@ParameterizedTest (name = "{index} => De los alumnos ({0}) se han presentado ({1}), por lo que no se han presentado ({2})")
	@CsvFileSource(files = "test/ejercicio2/listas.csv", numLinesToSkip = 1)
	void testListaEstudiantesNoPresentados(String todosCSV, String presentadosCSV, String noPresentadosCSV) {

		Ejercicio2 ejercicio2 = new Ejercicio2();

        List<String> todos = new ArrayList<>();
        todos.addAll(Arrays.asList(todosCSV.split(", ")));

        List<String> presentados = new ArrayList<>();
        presentados.addAll(Arrays.asList(presentadosCSV.split(", ")));

        List<String> noPresentados = new ArrayList<>();
        noPresentados.addAll(Arrays.asList(noPresentadosCSV.split(", ")));

		assertEquals(noPresentados, ejercicio2.listaEstudiantesNoPresentados(todos, presentados));
	}
}
