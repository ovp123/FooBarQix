package springboot;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private  TestEntityManager entityManager;

    @Autowired
    private  EmployeeRepository employeeRepository;

    private void loadData() {
        Employee alex = new Employee("Alex",33);
        Employee riri = new Employee("Riri",10);
        Employee fifi = new Employee("Fifi",9);
        Employee loulou = new Employee("Loulou",8);
        entityManager.persist(alex);
        entityManager.persist(riri);
        entityManager.persist(fifi);
        entityManager.persist(loulou);
        entityManager.flush();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Riri", "Fifi", "Loulou"})
    public void whenFindByName_thenReturnEmployee(String name){
        loadData();
        Employee found = employeeRepository.findByName(name);
        Assertions.assertEquals(name,found.getName());

    }

    @Test
    public void whenMax_thenReturnMax() {
        loadData();
        Assertions.assertEquals(33,employeeRepository.findMaxAge());
    }

    @ParameterizedTest
    @ValueSource(ints = {32,15,11})
    public void whenMaxParam_thenReturnMax(int age) {
        loadData();
        Assertions.assertEquals(10,employeeRepository.findMaxAge(age));
    }

    @Test
    public void whenNameAndSurname_thenReturn() {
        loadData();
        Employee riri = new Employee("Riri",10);
        Assertions.assertEquals(riri,employeeRepository.findByNameAndAge("Riri", 10));
        Assertions.assertEquals(null,employeeRepository.findByNameAndAge("Riri", 11));
        Assertions.assertEquals(null,employeeRepository.findByNameAndAge("Fifi", 10));
    }

}
