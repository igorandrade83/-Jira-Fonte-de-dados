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
@Repository("TabatabbDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface TabatabbDAO extends JpaRepository<Tabatabb, java.lang.String> {

  /**
   * Obtém a instância de Tabatabb utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Tabatabb entity WHERE entity.id = :id")
  public Tabatabb findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Tabatabb utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Tabatabb entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Tabc entity WHERE entity.tabatabb.id = :id")
  public Page<Tabc> findTabc(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Tabe entity WHERE entity.tabatabb.id = :id")
  public Page<Tabe> findTabe(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key taba
   * @generated
   */
  @Query("SELECT entity FROM Tabatabb entity WHERE entity.taba.id = :id")
  public Page<Tabatabb> findTabatabbsByTaba(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key tabb
   * @generated
   */
  @Query("SELECT entity FROM Tabatabb entity WHERE entity.tabb.id = :id")
  public Page<Tabatabb> findTabatabbsByTabb(@Param(value="id") java.lang.String id, Pageable pageable);

}
