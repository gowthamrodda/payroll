package payroll;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;
    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/employees")
    Employee create(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
        String msg = "Employee not found" + id;
        return repository.findById(id)
                .orElseThrow();
    }

    @PutMapping("/employees/{id}")
    Optional<Employee> upsert(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                });
    }
}

