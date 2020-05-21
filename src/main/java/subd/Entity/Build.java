package subd.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Build{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String type;
    @OneToMany
    private List<Material> materials;

    @Override
    public String toString() {
        return "Build{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @OneToMany
    private List<Orders> orders;

    public Build() {
    }

    public Build(Integer id,
                 String name,
                 String type,
                 List<Material> materials,
                 List<Orders> orders) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.materials = materials;
        this.orders = orders;
    }
}
