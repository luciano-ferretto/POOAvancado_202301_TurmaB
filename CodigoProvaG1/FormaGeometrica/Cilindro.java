package FormaGeometrica;

import java.util.List;

public class Cilindro extends FormaGeometrica implements IFormaGeometrica3D{
    public Cilindro(List<Double> medidas) {
        super(medidas);
    }
    @Override
    public double calculaArea() {
        return (2 * Math.PI * getMedidas().get(0) * getMedidas().get(1)) 
        + (Math.PI * Math.pow(getMedidas().get(0), 2));
    }
    @Override
    public double calculaVolume() {
        return Math.PI * Math.pow(getMedidas().get(0), 2) 
        * getMedidas().get(1);
    }
}
