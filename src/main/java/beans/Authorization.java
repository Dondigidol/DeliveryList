package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Authorization {
    private String name = "Emil";
    private String lastName = "Tulbaev";

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String showGreeting() {
        return "Hello " + name + " " + lastName + "!";
    }
}
