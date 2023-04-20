package org.Example.ExampleLecturaCSV;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.Example.ExampleLecturaCSV.models.Pronostico;
import org.Example.ExampleLecturaCSV.models.Resultado;

public class App 
{
    public static void main( String[] args )
    {
    	
    	LectorArchivos lectorArchivos = new LectorArchivos();
    	
    	//Leo el archivo de resultado y lo asigno a una variable
        List<Resultado> listaResultado = 
        		lectorArchivos.parsearResultados("src/main/resources/Resultados.csv");

    	//Leo el archivo de pronostico y lo asigno a una variable
        List<Pronostico> listaPronosticos = 
        		lectorArchivos.parsearPronosticos("src/main/resources/Pronosticos.csv");

        //Creo un tipo de dato hash set, así voy sumando puntos de los participantes.
        Map<String,Integer> puntosParticipantes = new HashMap<String, Integer>();
        
        //Recorro todos los pronosticos
        for(Pronostico pronostico : listaPronosticos) {
        	
        	//Primero me fijo si ya tengo agregado al participante
        	if(!puntosParticipantes.containsKey(pronostico.getParticipante())){
        		//si NO esta, lo agrego con 0 puntos
        		puntosParticipantes.put(pronostico.getParticipante(),0);
        	}
        
        	//Busco el partido dentro de resultados
        	for(Resultado resultado : listaResultado) {
        		//Busco hasta que los equipos del pronostico sean el mismo del resultado
        		//Osea, busco el partido
        		if(resultado.getEquipo1().equalsIgnoreCase(pronostico.getEquipo1())
        				&& resultado.getEquipo2().equalsIgnoreCase(pronostico.getEquipo2())) {
        			
        			//Una vez que encuentro el partido, me fijo si pusieron el mismo resultado
        			if(resultado.ganoEmpatoOPerdioElEquipo1() == pronostico.ganoEmpatoOPerdioElEquipo1()) {
        				//si el pronostico es el mismo, sumo puntos
        				puntosParticipantes.put(pronostico.getParticipante(),
        						//busco los puntos del participante y le sumo 1
        						puntosParticipantes.get(pronostico.getParticipante())+1);   				
        			}
        		}
        	}
        }
        
        //Imprimo en pantalla los puntos calculados
        for(String participante : puntosParticipantes.keySet()) {
        	System.out.println(participante+": "+puntosParticipantes.get(participante));
        }
    }
}
