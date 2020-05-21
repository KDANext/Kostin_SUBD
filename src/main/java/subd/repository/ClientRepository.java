package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.Entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
