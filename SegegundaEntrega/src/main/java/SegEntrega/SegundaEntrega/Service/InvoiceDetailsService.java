package SegEntrega.SegundaEntrega.Service;

import SegEntrega.SegundaEntrega.Entity.InvoiceDetails;
import SegEntrega.SegundaEntrega.Repository.InvoiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailsService {

    @Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;

    public void createdInvoiceDetails(InvoiceDetails invoiceDetails){
        invoiceDetailsRepository.save(invoiceDetails);
    }

    public List<InvoiceDetails>getInvoiceDetails(){
        return invoiceDetailsRepository.findAll();
    }

    public InvoiceDetails getInvoiceDetailsById(Integer id) throws Exception{
        Optional<InvoiceDetails> invoiceDetails = invoiceDetailsRepository.findById(id);
            if (invoiceDetails.isPresent()){
                return invoiceDetails.get();
            }else {
                throw new Exception("Invoice Detail no exist");
            }
    }

    public void deleteInvoiceDetailById (Integer id) throws Exception{
        InvoiceDetails invoiceDetails = getInvoiceDetailsById(id);
        invoiceDetailsRepository.delete(invoiceDetails);
    }

}
