package es.upm.miw.apaw_practice.domain.models.bank;

public class ClientNameUpdating {

    private String dni;
    private String name;

    public ClientNameUpdating() {
        // empty for framework
    }

    public ClientNameUpdating(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClientNameUpdating other = (ClientNameUpdating) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClientNameUpdating [dni=" + dni + ", name=" + name + "]";
    }

}
