package FormaGeometrica;


import java.util.List;
public abstract class FormaGeometrica


implements IFormaGeometrica{
    private List<Double> medidas;
  
    public FormaGeometrica(List<Double> medidas) {
        this.medidas = medidas;
    }
    public List<Double> getMedidas() {
        return medidas;
    }
    public void setMedidas(List<Double> medidas) {
        this.medidas = medidas;
    }

   
}

