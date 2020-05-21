package subd.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date date;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Build build;

    public Orders(Integer id, Date date, Client client, Build build) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.build = build;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
