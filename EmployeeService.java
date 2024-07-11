@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployee(Long id) {
        return repository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Optional<Employee> updateEmployee(Long id, Employee employee) {
        return repository.findById(id)
               .map(oldEmployee -> {
                    oldEmployee.setName(employee.getName());
                    oldEmployee.setSalary(employee.getSalary());
                    oldEmployee.setAge(employee.getAge());
                    return repository.save(oldEmployee);
                });
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}