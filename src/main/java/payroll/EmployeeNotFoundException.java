package payroll;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class EmployeeNotFoundException extends RuntimeException {
    private static final Logger log = (Logger) LoggerFactory.getLogger(EmployeeNotFoundException.class);
    EmployeeNotFoundException(Long id) {
        super("Could not find employee" + id);
        log.info("Could not find employee" + id);
    }
}
