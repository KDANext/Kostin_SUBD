package subd.Entity;

import javax.persistence.*;

@Entity
public class MaterialBuild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Build build;
    @ManyToOne
    private Material material;

    public MaterialBuild() {
    }

    public MaterialBuild(Integer id, Build build, Material material) {
        this.id = id;
        this.build = build;
        this.material = material;
    }

    @Override
    public String toString() {
        return "MaterialBuild{" +
                "id=" + id +
                '}';
    }
}
