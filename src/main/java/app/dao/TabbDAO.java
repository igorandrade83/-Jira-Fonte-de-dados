package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 


/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("TabbDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface TabbDAO extends JpaRepository<Tabb, java.lang.String> {

  /**
   * Obtém a instância de Tabb utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Tabb entity WHERE entity.id = :id")
  public Tabb findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Tabb utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Tabb entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Tabatabb entity WHERE entity.tabb.id = :id")
  public Page<Tabatabb> findTabatabb(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.taba FROM Tabatabb entity WHERE entity.tabb.id = :id")
  public Page<Taba> listTaba(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Tabatabb entity WHERE entity.tabb.id = :instanceId AND entity.taba.id = :relationId")
  public int deleteTaba(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  /**
   * Foreign Key tabdFilhob
   * @generated
   */
  @Query("SELECT entity FROM Tabb entity WHERE entity.tabdFilhob.id = :id")
  public Page<Tabb> findTabbsByTabdFilhob(@Param(value="id") java.lang.String id, Pageable pageable);

}
