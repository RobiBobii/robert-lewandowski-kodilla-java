package com.kodilla.kodillahibernate.invoice.dao;

import com.kodilla.kodillahibernate.invoice.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface InoviceDao extends CrudRepository<Invoice, Integer> {

    @Query
    List<Invoice> retrieveInvoicesByInvoiceNr(@Param("INVOICE_NR") String invoiceNr);

}