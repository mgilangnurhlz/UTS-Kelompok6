package password.forgotpassword.service.implementation;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import password.forgotpassword.entity.Employee;
import password.forgotpassword.repository.EmployeeRepository;
import password.forgotpassword.service.framework.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public void saveEmployee(Employee emp) {
        repo.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> opt = repo.findById(id);
        if(opt.isEmpty()) {
            return null;
        }
        return opt.get();
    }

    @Override
    public void updateEmployee(Employee emp) {
        repo.save(emp);
    }

}
