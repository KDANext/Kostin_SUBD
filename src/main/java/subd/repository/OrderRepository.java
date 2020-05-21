package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import subd.Entity.Orders;

import java.util.Date;
import java.util.*;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {

    @Query(" SELECT new subd.repository.SelectBindingModel(z.id,z.date,cl.name,bl.name,bl.type) FROM Orders z " +
            " JOIN Build bl ON z.id = bl.id" +
            " JOIN Client cl ON z.id = cl.id")
    List<SelectBindingModel> getAllOrders();

    @Query(" SELECT new subd.repository.SelectBindingModel(z.id,z.date,cl.name,bl.name,bl.type) FROM Orders z " +
            " JOIN Build bl ON z.id = bl.id" +
            " JOIN Client cl ON z.id = cl.id" +
            " WHERE z.date BETWEEN :dateFrom AND :dateTo")
    List<SelectBindingModel> getAllOrdersOnDate(Date dateFrom,Date dateTo);
}
