package FormaGeometrica;

import java.util.List;

public class Retangulo extends FormaGeometrica implements IFormaGeometrica2D {

    public Retangulo(List<Double> medidas) {
        super(medidas);
    }
    @Override
    public double calculaArea() {
        return getMedidas().get(0) * getMedidas().get(1);
    }
	
  
   
}
