package workshop.dto;

import java.io.Serializable;

import workshop.domain.User;

public class authorDTO implements Serializable {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public authorDTO(){

    }

    public authorDTO(User obj){
        id = obj.getId();
        name = obj.getName();
    }
}
