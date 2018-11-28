package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela ESTADO
 * @generated
 */
@Entity
@Table(name = "\"ESTADO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Estado")
public class Estado implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "est_id", nullable = false, length=255, insertable=true, updatable=true)
  private java.lang.String estId = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "est_nome", nullable = true, unique = false, length=255, insertable=true, updatable=true)
  
  private java.lang.String estNome;

  /**
   * Construtor
   * @generated
   */
  public Estado(){
  }


  /**
   * Obtém estId
   * return estId
   * @generated
   */
  
  public java.lang.String getEstId(){
    return this.estId;
  }

  /**
   * Define estId
   * @param estId estId
   * @generated
   */
  public Estado setEstId(java.lang.String estId){
    this.estId = estId;
    return this;
  }

  /**
   * Obtém estNome
   * return estNome
   * @generated
   */
  
  public java.lang.String getEstNome(){
    return this.estNome;
  }

  /**
   * Define estNome
   * @param estNome estNome
   * @generated
   */
  public Estado setEstNome(java.lang.String estNome){
    this.estNome = estNome;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Estado object = (Estado)obj;
    if (estId != null ? !estId.equals(object.estId) : object.estId != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((estId == null) ? 0 : estId.hashCode());
    return result;
  }

}
