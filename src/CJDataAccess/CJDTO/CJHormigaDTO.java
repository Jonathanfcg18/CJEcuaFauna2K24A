package CJDataAccess.CJDTO;

public class CJHormigaDTO {
    private Integer idCJHormiga  ;
    private Integer idCJSexo     ;
    private Integer idCJProvincia;
    private String  tipo         ;
    private String  genoAlimento ;
    private String  ingestaNativa;
    private String  estado       ;
    private String  fechaCreacion;
    private String  fechaModifica;
    
    public CJHormigaDTO(Integer idCJHormiga, Integer idCJSexo, Integer idCJProvincia, String tipo, String genoAlimento,
            String ingestaNativa, String estado, String fechaCreacion, String fechaModifica) {
        this.idCJHormiga = idCJHormiga;
        this.idCJSexo = idCJSexo;
        this.idCJProvincia = idCJProvincia;
        this.tipo = tipo;
        this.genoAlimento = genoAlimento;
        this.ingestaNativa = ingestaNativa;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    public CJHormigaDTO() {
    }

    public Integer getIdCJHormiga() {
        return idCJHormiga;
    }
    public void setIdCJHormiga(Integer idCJHormiga) {
        this.idCJHormiga = idCJHormiga;
    }
    public Integer getIdCJSexo() {
        return idCJSexo;
    }
    public void setIdCJSexo(Integer idCJSexo) {
        this.idCJSexo = idCJSexo;
    }
    public Integer getIdCJProvincia() {
        return idCJProvincia;
    }
    public void setIdCJProvincia(Integer idCJProvincia) {
        this.idCJProvincia = idCJProvincia;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getGenoAlimento() {
        return genoAlimento;
    }
    public void setGenoAlimento(String genoAlimento) {
        this.genoAlimento = genoAlimento;
    }
    public String getIngestaNativa() {
        return ingestaNativa;
    }
    public void setIngestaNativa(String ingestaNativa) {
        this.ingestaNativa = ingestaNativa;
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
                + "\n idCJHormiga   "+ getIdCJHormiga()
                + "\n idCJSexo      "+ getIdCJSexo()
                + "\n idCJProvincia "+ getIdCJProvincia()
                + "\n tipo          "+ getTipo()
                + "\n genoAlimento  "+ getGenoAlimento()
                + "\n ingestaNativa "+ getIngestaNativa()
                + "\n estado         "+ getEstado()
                + "\n fechaCreacion  "+ getFechaCreacion()
                + "\n fechaModifica  "+ getFechaModifica();
    }
}
