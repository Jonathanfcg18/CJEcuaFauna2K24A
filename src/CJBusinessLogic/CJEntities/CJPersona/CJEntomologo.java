package CJBusinessLogic.CJEntities.CJPersona;

import CJBusinessLogic.CJEntities.CJHormiga.CJHormiga;

public class CJEntomologo extends CJPersona {

    public CJEntomologo(String cjNombre) {
        super(cjNombre);
    }

    public void cjExperimentar(CJHormiga cjHormiga){
        System.out.println("Experimentando con la hormiga " + cjHormiga);
    }
}
