package CJDataAccess.CJDTO;

public class CJSexoDTO {
    private Integer idCJSexo     ;
    private String  nombre       ;
    private String  estado       ;
    private String  fechaCreacion;
    private String  fechaModifica;
    
    public CJSexoDTO() {
    }

    public CJSexoDTO(Integer idCJSexo, String nombre, String estado, String fechaCreacion, String fechaModifica) {
        this.idCJSexo = idCJSexo;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }
    
    public Integer getIdCJSexo() {
        return idCJSexo;
    }
    public void setIdCJSexo(Integer idCJSexo) {
        this.idCJSexo = idCJSexo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getFechaModifica() {
        return fechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    @Override
    public String toString(){
        return  "  \n" + getClass().getName()
                + "\n idCJSexo       "+ getIdCJSexo()
                + "\n nombre         "+ getNombre()
                + "\n estado         "+ getEstado()
                + "\n fechaCreacion  "+ getFechaCreacion()
                + "\n fechaModifica  "+ getFechaModifica();
    }
}
