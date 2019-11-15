package springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long>{
    public Employee findByName(String name);
    public Employee findByNameAndAge(String name, int age);
    @Query(value = "SELECT MAX(age) FROM Employee")
    public int findMaxAge();
    @Query(value = "SELECT MAX(age) FROM Employee WHERE age < ?1")
    public int findMaxAge(int age);
}
