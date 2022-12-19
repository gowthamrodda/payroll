package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class LoadDatabase {
    Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    CommandLineRunner initDatabase(EmployeeRepository repository) {
            return args -> {
                log.info("Preloading", repository.save(new Employee("rgk", "dev")));
                log.info("Preloading", repository.save(new Employee("SRG", "dev")));
            };
    }
}
