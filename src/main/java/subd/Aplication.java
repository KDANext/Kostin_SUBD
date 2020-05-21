package subd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.Entity.*;
import subd.repository.*;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class Aplication {
    private BuildRepository buildRepository;
    private ClientRepository clientRepository;
    private MaterialRepository materialRepository;
    private OrderRepository orderRepository;
    private MaterialBuildRepository materialBuildRepository;

    @Autowired
    public Aplication(BuildRepository buildRepository,
                      ClientRepository clientRepository,
                      MaterialRepository materialRepository,
                      OrderRepository orderRepository,
                      MaterialBuildRepository materialBuildRepository) {
        this.buildRepository = buildRepository;
        this.clientRepository = clientRepository;
        this.materialRepository = materialRepository;
        this.orderRepository = orderRepository;
        this.materialBuildRepository = materialBuildRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Aplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStart() {
            readBuilds();
            readClients();
            readMaterials();
            readOrders();
            firstRequest();
            secondRequest();
    }

    public void firstRequest(){
        Timestamp start = new Timestamp(System.currentTimeMillis());
        List<SelectBindingModel> result = orderRepository.getAllOrders();
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");
        for (SelectBindingModel model: result) {
            System.out.println("model = " + model);
        }
    }

    public void secondRequest(){
        Timestamp start = new Timestamp(System.currentTimeMillis());
        List<SelectBindingModel> result = orderRepository.getAllOrdersOnDate(new Date(1537750800000L),new Date(1537923600000L));
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");
        for (SelectBindingModel model: result) {
            System.out.println("model = " + model);
        }
    }

    private void createClient() {
        Client client = new Client(null,"Boric","479800",null);
        clientRepository.save(client);
    }

    private void delClient() {clientRepository.deleteById(1);}

    private void updateClient() {
        Client client = new Client(1,"Борис","5465123",null);
        clientRepository.save(client);
    }

    private void readClients() {
        for (Client client: clientRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(client);
        }
    }

    private void readBuilds(){
        for (Build build: buildRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(build);
        }
    }

    private void readMaterials(){
        for (Material material: materialRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(material);
        }
    }

    private void readOrders(){
        for (Orders orders : orderRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(orders);
        }
    }
    private void readMaterialBuild() {
        for (MaterialBuild materialBuild : materialBuildRepository.findAll(PageRequest.of(0,3, Sort.unsorted()))){
            System.out.println(materialBuild);
        };
    }

}
