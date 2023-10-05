package SegEntrega.SegegundaEntrega.Repository;


import SegEntrega.SegegundaEntrega.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
