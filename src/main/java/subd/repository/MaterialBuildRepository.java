package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.Entity.MaterialBuild;

@Repository
public interface MaterialBuildRepository extends JpaRepository<MaterialBuild,Integer> {
}
