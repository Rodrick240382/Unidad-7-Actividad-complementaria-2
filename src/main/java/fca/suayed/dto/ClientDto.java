package fca.suayed.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class ClientDto {
    private long id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String RFC;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     @ColumnName("nombre")
    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    @ColumnName("apellido_paterno")
    public String getapellido_paterno() {
        return apellido_paterno;
    }

    public void setapellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    @ColumnName("apellido_materno")
    public String getapellido_materno() {
        return apellido_materno;
    }

    public void setapellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    @ColumnName("RFC")
    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }
}
