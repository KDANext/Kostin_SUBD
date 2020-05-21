package subd.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer count;
    private Integer price;
    @OneToMany
    private List<MaterialBuild> materialBuilds;

    public Material(Integer id, String name, Integer count, Integer price, List<MaterialBuild> materialBuilds) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.materialBuilds = materialBuilds;
    }

    public Material() {
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
