package com.shop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.EmployeeDAO;
import com.shop.entity.Employee;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.entity.Stock;
import com.shop.repository.EmployeeRepository;
import com.shop.repository.OrderRepository;
import com.shop.repository.StockRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeDAO {

    private final EmployeeRepository employeeRepository;
    
    
    
    @Autowired
    private OrderRepository orderRepo;
    
    @Autowired
	StockRepository stockRepository; 
    
    @Autowired
	StockService stockService; 

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


	public void confirm(Long oId, Long eId) {
		Order order=orderRepo.findById(oId).get();
		order.setOrderStatus(true);
		orderRepo.save(order);
		
		List<Product> prod=order.getCart().getProducts();
		for(Product p:prod) {
			int res=p.getStock().getQuantity()-order.getCart().getQuantity();
			Stock stock=stockService.getStockByProductId(p.getId()).get();
			stock.setQuantity(res);
		}
		
//		
//		int stockk=order.getCart().getProducts().getStock().getQuantity()-order.getCart().getQuantity();
//		Stock stock=order.getCart().getProducts().getStock();
//		stock.setQuantity(stockk);
//		stockRepository.save(stock);
		
		Employee employee=employeeRepository.findById(eId).get();
		employee.setOrdersAccepted(employee.getOrdersAccepted()+1);
		employeeRepository.save(employee);
		
		
	}

	
   }
