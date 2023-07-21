package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT new com.devsuperior.dsmeta.dto.SaleMinDTO(obj.id, obj.amount, obj.date, obj.seller.name) "
            + "FROM Sale obj "
            + "WHERE (:minDate IS NULL OR obj.date >= :minDate) AND "
            + "(:maxDate IS NULL OR obj.date <= :maxDate) AND "
            + "(:name IS NULL OR UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')))")
    Page<SaleMinDTO> getReport(@Param("minDate") LocalDate minDate,
                               @Param("maxDate") LocalDate maxDate,
                               @Param("name") String name,
                               Pageable pageable);

    @Query(value = "SELECT new com.devsuperior.dsmeta.dto.SellerMinDTO(obj.seller.name, SUM(obj.amount)) "
            + "FROM Sale obj WHERE obj.date BETWEEN :minDate AND :maxDate AND "
            + "(COALESCE(:name, '') = '' or obj.seller.name = :name) "
            + "GROUP BY obj.seller.name")
    List<SellerMinDTO> getSummary(@Param("minDate") LocalDate minDate,
                                  @Param("maxDate") LocalDate maxDate,
                                  @Param("name") String name);

}
