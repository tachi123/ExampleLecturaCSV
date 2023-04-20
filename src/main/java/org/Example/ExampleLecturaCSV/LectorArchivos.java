package org.Example.ExampleLecturaCSV;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.Example.ExampleLecturaCSV.models.Pronostico;
import org.Example.ExampleLecturaCSV.models.Resultado;

public class LectorArchivos {

    public List<Resultado> parsearResultados(String rutaDelArchivoResultados) {
        List<Resultado> listaDeResultados = null;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
        	listaDeResultados = new CsvToBeanBuilder(new FileReader(rutaDelArchivoResultados))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(',')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(Resultado.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
    }
        return listaDeResultados;
    }
    
    public List<Pronostico> parsearPronosticos(String rutaDelArchivoPronosticos) {
        List<Pronostico> listaDePronosticos = null;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
        	listaDePronosticos = new CsvToBeanBuilder(new FileReader(rutaDelArchivoPronosticos))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(',')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(Pronostico.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
    }
        return listaDePronosticos;
    }

}
