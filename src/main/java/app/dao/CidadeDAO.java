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
@Repository("CidadeDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface CidadeDAO extends JpaRepository<Cidade, java.lang.String> {

  /**
   * Obtém a instância de Cidade utilizando os identificadores
   * 
   * @param cidId
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Cidade entity WHERE entity.cidId = :cidId")
  public Cidade findOne(@Param(value="cidId") java.lang.String cidId);

  /**
   * Remove a instância de Cidade utilizando os identificadores
   * 
   * @param cidId
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Cidade entity WHERE entity.cidId = :cidId")
  public void delete(@Param(value="cidId") java.lang.String cidId);



  /**
   * Foreign Key estado
   * @generated
   */
  @Query("SELECT entity FROM Cidade entity WHERE entity.estado.estId = :estId")
  public Page<Cidade> findCidadesByEstado(@Param(value="estId") java.lang.String estId, Pageable pageable);

}
