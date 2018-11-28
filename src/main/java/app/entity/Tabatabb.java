package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela TABATABB
 * @generated
 */
@Entity
@Table(name = "\"TABATABB\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Tabatabb")
public class Tabatabb implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_tabA", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Taba taba;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_tabB", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Tabb tabb;

  /**
   * Construtor
   * @generated
   */
  public Tabatabb(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public Tabatabb setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém taba
   * return taba
   * @generated
   */
  
  public Taba getTaba(){
    return this.taba;
  }

  /**
   * Define taba
   * @param taba taba
   * @generated
   */
  public Tabatabb setTaba(Taba taba){
    this.taba = taba;
    return this;
  }

  /**
   * Obtém tabb
   * return tabb
   * @generated
   */
  
  public Tabb getTabb(){
    return this.tabb;
  }

  /**
   * Define tabb
   * @param tabb tabb
   * @generated
   */
  public Tabatabb setTabb(Tabb tabb){
    this.tabb = tabb;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Tabatabb object = (Tabatabb)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
