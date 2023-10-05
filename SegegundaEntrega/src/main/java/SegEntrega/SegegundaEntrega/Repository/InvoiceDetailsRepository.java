package SegEntrega.SegegundaEntrega.Repository;

import SegEntrega.SegegundaEntrega.Entity.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails,Integer> {
}
