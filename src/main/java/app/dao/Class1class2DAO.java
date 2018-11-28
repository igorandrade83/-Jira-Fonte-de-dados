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
@Repository("Class1class2DAO")
@Transactional(transactionManager="app-TransactionManager")
public interface Class1class2DAO extends JpaRepository<Class1class2, java.lang.String> {

  /**
   * Obtém a instância de Class1class2 utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Class1class2 entity WHERE entity.id = :id")
  public Class1class2 findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Class1class2 utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Class1class2 entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * Foreign Key class1
   * @generated
   */
  @Query("SELECT entity FROM Class1class2 entity WHERE entity.class1.id = :id")
  public Page<Class1class2> findClass1class2sByClass1(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key class2
   * @generated
   */
  @Query("SELECT entity FROM Class1class2 entity WHERE entity.class2.id = :id")
  public Page<Class1class2> findClass1class2sByClass2(@Param(value="id") java.lang.String id, Pageable pageable);

}
