package showcase.swagger.server.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import showcase.swagger.server.domain.Contact;
import showcase.swagger.server.domain.ContactRepository;
import showcase.swagger.server.domain.Customer;
import showcase.swagger.server.domain.CustomerRepository;

@RestController
@Api
public class Service {

    private final CustomerRepository customerRepository;
    private final ContactRepository contactRepository;

    public Service(CustomerRepository customerRepository, ContactRepository contactRepository) {
        this.customerRepository = customerRepository;
        this.contactRepository = contactRepository;
    }

    @GetMapping("/customer/{id}")
    @ApiOperation("Get customer")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerRepository.findOne(id);
    }

    @GetMapping("/contact/{id}")
    @ApiOperation(value = "Get contact")
    public Contact getContact(@PathVariable("id") Long id) {
        return contactRepository.findOne(id);
    }

    @PutMapping("/customer")
    @ApiOperation("Save Customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}
