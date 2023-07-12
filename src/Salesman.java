import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Salesman {
    private String firstName;
    private String lastName;
    private int salary;

    public boolean equals(Salesman salesman) {
    return  this.firstName.equals(salesman.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, soldByDays);
    }

    private HashMap <Integer, List<Product>>soldByDays;
}
