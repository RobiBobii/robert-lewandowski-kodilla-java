package com.kodilla.kodillahibernate.invoice.dao;

import com.kodilla.kodillahibernate.invoice.Invoice;
import com.kodilla.kodillahibernate.invoice.Item;
import com.kodilla.kodillahibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("009/11/2017");

        Product bread = new Product("bread");
        Product butter = new Product("butter");
        Product knife = new Product("knife");

        Item itemBread = new Item(bread, new BigDecimal(5), 2);
        Item itemButter = new Item(butter, new BigDecimal(9), 1);
        Item itemKnife = new Item(knife, new BigDecimal(250), 1);

        itemBread.setInvoice(invoice);
        itemButter.setInvoice(invoice);
        itemKnife.setInvoice(invoice);

        List<Item> items = new ArrayList<>();
        items.add(itemBread);
        items.add(itemButter);
        items.add(itemKnife);

        invoice.setItems(items);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int itemSize = invoice.getItems().size();

        Invoice invoiceReadFromDB = invoiceDao.findById(invoiceId);

        //Then
        Assertions.assertEquals(invoiceId, invoiceReadFromDB.getId());
        Assertions.assertEquals(3, itemSize);
        Assertions.assertEquals(itemSize, invoiceReadFromDB.getItems().size());
    }
}