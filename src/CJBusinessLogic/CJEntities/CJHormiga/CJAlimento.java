package CJBusinessLogic.CJEntities.CJHormiga;

public abstract class CJAlimento {
    private String cjTipo;

    // Método toString() público que devuelve el valor de 'Tipo'
    @Override
    public String toString() {
        return "Tipo: " + cjTipo;
    }
}