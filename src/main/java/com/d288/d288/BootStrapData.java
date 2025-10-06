package com.d288.d288;

import com.d288.d288.dao.CustomerRepository;
import com.d288.d288.dao.DivisionRepository;
import com.d288.d288.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 1) {
            Customer cust1 = new Customer();
            cust1.setFirstName("Steve");
            cust1.setLastName("Smith");
            cust1.setAddress("1234 Home Avenue");
            cust1.setPhone("12345678");
            cust1.setPostal_code("102030");
            cust1.setDivisions(divisionRepository.getReferenceById(6L));

            customerRepository.save(cust1);

            Customer cust2 = new Customer();
            cust2.setFirstName("Steve");
            cust2.setLastName("Jobs");
            cust2.setAddress("312 Apple Avenue");
            cust2.setPhone("910293893");
            cust2.setPostal_code("4324383");
            cust2.setDivisions(divisionRepository.getReferenceById(2L));

            customerRepository.save(cust2);

            Customer cust3 = new Customer();
            cust3.setFirstName("SpongeBob");
            cust3.setLastName("SquarePants");
            cust3.setAddress("Pineapple Road");
            cust3.setPhone("39537573");
            cust3.setPostal_code("00000000");
            cust3.setDivisions(divisionRepository.getReferenceById(3L));

            customerRepository.save(cust3);

            Customer cust4 = new Customer();
            cust4.setFirstName("Avocado");
            cust4.setLastName("Plant");
            cust4.setAddress("9328 Farm Road");
            cust4.setPhone("73827498237");
            cust4.setPostal_code("473922");
            cust4.setDivisions(divisionRepository.getReferenceById(4L));

            customerRepository.save(cust4);


            Customer cust5 = new Customer();
            cust5.setFirstName("Bob");
            cust5.setLastName("Smith");
            cust5.setAddress("123 Somewhere Drive");
            cust5.setPhone("432798423");
            cust5.setPostal_code("782978");
            cust5.setDivisions(divisionRepository.getReferenceById(5L));

            customerRepository.save(cust5);
        }

    }
}
