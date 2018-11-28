package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela TABB
 * @generated
 */
@Entity
@Table(name = "\"TABB\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Tabb")
public class Tabb implements Serializable {

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
  @Column(name = "nome", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String nome;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_tabD_filhoB", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private TabdFilhob tabdFilhob;

  /**
   * Construtor
   * @generated
   */
  public Tabb(){
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
  public Tabb setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém nome
   * return nome
   * @generated
   */
  
  public java.lang.String getNome(){
    return this.nome;
  }

  /**
   * Define nome
   * @param nome nome
   * @generated
   */
  public Tabb setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém tabdFilhob
   * return tabdFilhob
   * @generated
   */
  
  public TabdFilhob getTabdFilhob(){
    return this.tabdFilhob;
  }

  /**
   * Define tabdFilhob
   * @param tabdFilhob tabdFilhob
   * @generated
   */
  public Tabb setTabdFilhob(TabdFilhob tabdFilhob){
    this.tabdFilhob = tabdFilhob;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Tabb object = (Tabb)obj;
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
