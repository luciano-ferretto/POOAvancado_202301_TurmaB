package FormaGeometrica;

import java.util.List;

public class Cubo extends FormaGeometrica implements IFormaGeometrica3D{

    public Cubo(List<Double> medidas) {
        super(medidas);
    }
    @Override
    public double calculaArea() {
        return 6 * Math.pow(getMedidas().get(0), 2);
    }
    @Override
    public double calculaVolume() {
        return Math.pow(getMedidas().get(0), 3);
    }

}
