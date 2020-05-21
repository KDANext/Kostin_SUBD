package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.Entity.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Integer> {
}
