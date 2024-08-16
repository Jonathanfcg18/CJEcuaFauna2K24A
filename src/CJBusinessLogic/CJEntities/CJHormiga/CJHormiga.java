package CJBusinessLogic.CJEntities.CJHormiga;

public abstract class CJHormiga implements CJIHormiga {
    private String cjTipo;

    @Override
    public String toString() {
        return "Tipo: " + cjTipo;
    }

    // Implementación del método comer de la interfaz CJIHormiga
    @Override
    public boolean cjComer(CJAlimento cjAlimento) {
        return true;
    }
}
