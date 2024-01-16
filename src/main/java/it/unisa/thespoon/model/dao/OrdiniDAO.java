package it.unisa.thespoon.model.dao;

import it.unisa.thespoon.model.entity.Ordine;
import it.unisa.thespoon.model.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdiniDAO extends JpaRepository<Ordine, Integer> {

    @Query(value = "select ordine.* FROM ORDINE where ordine.IdRistorante = ?" , nativeQuery = true)
    List<Ordine> findAllByIdRistorante(@Param("idRistorante") Integer idRistorante);

    @Query(value = "SELECT po.prodotto FROM ProdottoOrdine po WHERE po.ordine.idordine = :idOrdine and po.ordine.Idristorante = :idRistorante")
    /*@Query(value = "select p1_0.id_prodotto, p1_0.descrizione, p1_0.nome, p1_0.prezzo from " +
            "prodotto_ordine po1_0 join prodotto p1_0 on p1_0.id_prodotto=po1_0.id_prodotto " +
            "join ordine o1_0 on o1_0.idordine=po1_0.idordine where  " +
            "o1_0.idristorante=? and po1_0.idordine=?", nativeQuery = true)*/
    List<Prodotto> getProdottiByIdOrdineAndIdRistorante(@Param("idRistorante") Integer idRistorante, @Param("idOrdine") Integer idOrdine);
}
