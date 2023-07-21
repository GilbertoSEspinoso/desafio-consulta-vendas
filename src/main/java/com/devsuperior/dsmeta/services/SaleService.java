package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SellerMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public SaleMinDTO findById(Long id) {
        Optional<Sale> result = repository.findById(id);
        Sale entity = result.get();
        return new SaleMinDTO(entity);
    }

    public Page<SaleMinDTO> getReport(String minDate, String maxDate, String name, Pageable pageable) {
        LocalDate searchMinDate;
        LocalDate searchMaxDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        if (maxDate != null && !maxDate.isEmpty())
            searchMaxDate = LocalDate.parse(maxDate);

        if (minDate != null && !minDate.isEmpty()) {
            searchMinDate = LocalDate.parse(minDate);
        } else {
            searchMinDate = searchMaxDate.minusYears(2L);
        }

        if (name == null)
            name = "";
        return repository.getReport(searchMinDate, searchMaxDate, name, pageable);
    }

    public List<SellerMinDTO> getSummary (String minDate, String maxDate, String name){
        LocalDate searchMinDate, searchMaxDate;

        if (maxDate == null) {
            searchMaxDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        } else {
            searchMaxDate = LocalDate.parse(maxDate);
        }

        if (minDate == null) {
            searchMinDate = searchMaxDate.minusYears(2L);
        } else {
            searchMinDate = LocalDate.parse(minDate);
        }

        return repository.getSummary(searchMinDate, searchMaxDate, name);
    }
}
