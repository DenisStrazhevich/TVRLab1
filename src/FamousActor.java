
import java.io.Serializable;
public class FamousActor implements Serializable{

    private static FamousActor famousActor;

    private String name;
    private String surname;
    private int age;
    private String country;

    public FamousActor() {

    }

    public FamousActor(String name, String surname, int age, String country) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.country = country;
    }

    public static FamousActor getFamousActor(){
        if(famousActor == null) {
            famousActor = new FamousActor();
        }
        return famousActor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamousActor that = (FamousActor) o;

        if (age != that.age) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FamousActor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}
