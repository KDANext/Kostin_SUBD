package subd.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String phone;
    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private List<Orders> orders;

    public Client(Integer id, String name, String phone, List<Orders> orders) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.orders = orders;
    }

    public Client() {
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", orders=" + orders +
                '}';
    }
}
