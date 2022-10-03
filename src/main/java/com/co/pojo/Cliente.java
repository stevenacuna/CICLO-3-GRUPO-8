package com.co.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;


//genera los getter a setter en la pestaña navigator
@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    @Id
    private Integer idcliente;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    
    
    
    
}
