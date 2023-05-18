package FormaGeometrica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;



public class Executa {
    public static void main(String[] args) {
    	
    	Cesta<Double> cestaFormas = new Cesta<>();
    	
    	List<Object> formas = new ArrayList<>();
    	cestaFormas.addAll(formas);
    	   	
    	List<Retangulo> retangulos = new ArrayList<>();
    	cestaFormas.addAll(retangulos);
    
    	
    	
    	
    	//lista.add(2222);
    	//lista.add( new Cubo(Arrays.asList(2.)));

    	
        List<IFormaGeometrica3D> formas3D = (Arrays.asList(
                new Cubo(Arrays.asList(2.))
                ,new Cilindro(Arrays.asList(4.5, 5.))
            ));
        imprimeMedidas3D(formas3D);
        List<IFormaGeometrica2D> formas2D = Arrays.asList(new Retangulo(Arrays.asList(1.3, 3.2)));
        imprimeMedidas2D(formas2D);
    }

    static void imprimeMedidas3D (List<IFormaGeometrica3D> formas) {
        for (IFormaGeometrica3D forma : formas) {
        		System.out.println("--------------------------------------");
                System.out.println("Forma: " + forma.getClass().getName());
                System.out.println("Área: " + forma.calculaArea());
                System.out.println("Volume: " + forma.calculaVolume());
                System.out.println("--------------------------------------");
			
        }
    }
    static void imprimeMedidas2D (List<IFormaGeometrica2D> formas) {
        for (IFormaGeometrica2D forma : formas) {
        		System.out.println("--------------------------------------");
                System.out.println("Forma: " + forma.getClass().getName());
                System.out.println("Área: " + forma.calculaArea());
                
              
                
                System.out.println("--------------------------------------");
			
        }
    }
}
