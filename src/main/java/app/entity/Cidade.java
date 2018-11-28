package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela CIDADE
 * @generated
 */
@Entity
@Table(name = "\"CIDADE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Cidade")
public class Cidade implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "cid_id", nullable = false, length=255, insertable=true, updatable=true)
  private java.lang.String cidId = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "cid_nome", nullable = true, unique = false, length=255, insertable=true, updatable=true)
  
  private java.lang.String cidNome;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_estado", nullable = true, referencedColumnName = "est_id", insertable=true, updatable=true)
  
  private Estado estado;

  /**
   * Construtor
   * @generated
   */
  public Cidade(){
  }


  /**
   * Obtém cidId
   * return cidId
   * @generated
   */
  
  public java.lang.String getCidId(){
    return this.cidId;
  }

  /**
   * Define cidId
   * @param cidId cidId
   * @generated
   */
  public Cidade setCidId(java.lang.String cidId){
    this.cidId = cidId;
    return this;
  }

  /**
   * Obtém cidNome
   * return cidNome
   * @generated
   */
  
  public java.lang.String getCidNome(){
    return this.cidNome;
  }

  /**
   * Define cidNome
   * @param cidNome cidNome
   * @generated
   */
  public Cidade setCidNome(java.lang.String cidNome){
    this.cidNome = cidNome;
    return this;
  }

  /**
   * Obtém estado
   * return estado
   * @generated
   */
  
  public Estado getEstado(){
    return this.estado;
  }

  /**
   * Define estado
   * @param estado estado
   * @generated
   */
  public Cidade setEstado(Estado estado){
    this.estado = estado;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Cidade object = (Cidade)obj;
    if (cidId != null ? !cidId.equals(object.cidId) : object.cidId != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((cidId == null) ? 0 : cidId.hashCode());
    return result;
  }

}
