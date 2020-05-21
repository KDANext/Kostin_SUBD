package subd.repository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class SelectBindingModel {
    private Integer id;
    private Date date;
    private String clientName;
    private String buildName;
    private String type;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", date=" + date +
                ", clientName='" + clientName + '\'' +
                ", buildName='" + buildName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public SelectBindingModel(Integer id,
                              Date date,
                              String clientName,
                              String buildName,
                              String type) {
        this.id = id;
        this.date = date;
        this.clientName = clientName;
        this.buildName = buildName;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
