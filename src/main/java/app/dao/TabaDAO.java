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
@Repository("TabaDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface TabaDAO extends JpaRepository<Taba, java.lang.String> {

  /**
   * Obtém a instância de Taba utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Taba entity WHERE entity.id = :id")
  public Taba findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Taba utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Taba entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Tabatabb entity WHERE entity.taba.id = :id")
  public Page<Tabatabb> findTabatabb(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.tabb FROM Tabatabb entity WHERE entity.taba.id = :id")
  public Page<Tabb> listTabb(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Tabatabb entity WHERE entity.taba.id = :instanceId AND entity.tabb.id = :relationId")
  public int deleteTabb(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

}
