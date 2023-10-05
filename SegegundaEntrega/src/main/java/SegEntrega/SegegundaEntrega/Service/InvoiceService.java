package SegEntrega.SegegundaEntrega.Service;

import SegEntrega.SegegundaEntrega.Entity.Invoice;
import SegEntrega.SegegundaEntrega.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public void createdInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public List<Invoice>getInvoice(){
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Integer id) throws Exception{
        Optional<Invoice> invoice = invoiceRepository.findById(id);
            if (invoice.isPresent()){
                return invoice.get();
            }else{
                throw new Exception("Invoice no exist");
            }
    }

    public void deleteInvoiceById(Integer id) throws Exception{
        Invoice invoice = getInvoiceById(id);
        invoiceRepository.delete(invoice);
    }
}
