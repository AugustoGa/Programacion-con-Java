package SegEntrega.SegegundaEntrega.Repository;

import SegEntrega.SegegundaEntrega.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
