package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.Entity.Build;

@Repository
public interface BuildRepository extends JpaRepository<Build, Integer> {
}
