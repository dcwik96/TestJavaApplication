package com.projekt.projekt2;

import com.projekt.projekt2.entity.Customer;
import com.projekt.projekt2.repository.CustomerRepo;
import com.projekt.projekt2.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerTest {

    @MockBean
    CustomerRepo customerRepo;

    @Autowired
    CustomerService customerService;

    private String firstname = "firstname";
    private String lastname = "lastname";
    private String email = "email@costam.com";

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer(firstname, lastname, email);

        when(customerRepo.save(any(Customer.class))).thenReturn(customer);
    }

    @Test
    public void checkIfSaveNewCustomer() {
        when(customerRepo.findByEmail(anyString())).thenReturn(null);

        Customer c = customerService.save(customer);

        verify(customerRepo).save(any(Customer.class));
        assertEquals(email, c.getEmail());
        assertEquals(lastname, c.getLastname());
        assertEquals(firstname, c.getFirstname());
    }

    @Test
    public void checkIfThrownExceptionWhenEmailIsInDBWhileSaveNewCustomer() {
        when(customerRepo.findByEmail(anyString())).thenReturn(customer);

        assertThrows(IllegalArgumentException.class, () -> customerService.save(customer));

        verify(customerRepo, times(0)).save(any(Customer.class));
    }

    @Test
    public void checkIfUpdateFirstNameWorksGood() {
        when(customerRepo.findByEmail(anyString())).thenReturn(customer);

        Customer c = customerService.updateFirstName(customer, "ZmienioneImie");

        verify(customerRepo).save(any(Customer.class));
        verify(customerRepo).findByEmail(anyString());
        assertEquals("ZmienioneImie", c.getFirstname());
    }

    @Test
    public void checkIfUpdateFirstNameReturnNullWhenCustomerNotFound() {
        when(customerRepo.findByEmail(anyString())).thenReturn(null);

        assertNull(customerService.updateFirstName(customer, "ZmienioneImie"));
        verify(customerRepo).findByEmail(anyString());
        verify(customerRepo, times(0)).save(any(Customer.class));
    }

    @Test
    public void checkIfUpdateLastNameWorksProperly() {
        when(customerRepo.findByEmail(anyString())).thenReturn(customer);

        Customer c = customerService.updateLastName(customer, "ZmienioneNazwisko");

        verify(customerRepo).save(any(Customer.class));
        verify(customerRepo).findByEmail(anyString());
        assertEquals("ZmienioneNazwisko", c.getLastname());
    }

    @Test
    public void checkIfUpdateLastNameReturnNullWhenCustomerNotFound() {
        when(customerRepo.findByEmail(anyString())).thenReturn(null);

        assertNull(customerService.updateLastName(customer, "ZmienioneNazwisko"));
        verify(customerRepo).findByEmail(anyString());
        verify(customerRepo, times(0)).save(any(Customer.class));
    }

    @Test
    public void checkIfUpdateEmailWorksProperly() {
        when(customerRepo.findByEmail(email)).thenReturn(customer);
        when(customerRepo.findByEmail("ZmienionyEmail")).thenReturn(null);

        Customer c = customerService.updateEmail(customer, "ZmienionyEmail");

        verify(customerRepo).save(any(Customer.class));
        verify(customerRepo, times(2)).findByEmail(anyString());
        assertEquals("ZmienionyEmail", c.getEmail());
    }

    @Test
    public void checkIfUpdateEmailReturnNullWhenCustomerNotFound() {
        when(customerRepo.findByEmail(anyString())).thenReturn(null);

        assertNull(customerService.updateEmail(customer, "ZmienionyEmail"));
        verify(customerRepo, times(0)).save(any(Customer.class));
        verify(customerRepo).findByEmail(anyString());
    }

    @Test
    public void checkIfUpdateEmailReturnNullWhenCustomerNewEmailIsAlreadyUsed() {
        when(customerRepo.findByEmail(anyString())).thenReturn(customer);

        assertNull(customerService.updateEmail(customer, "ZmienionyEmail"));
        verify(customerRepo, times(0)).save(any(Customer.class));
        verify(customerRepo, times(2)).findByEmail(anyString());
    }

    @Test
    public void checkIfSaveTwiceSameCustomerThrows() {
        when(customerRepo.findByEmail(anyString())).thenReturn(null).thenReturn(customer);

        customerService.save(customer);
        assertThrows(IllegalArgumentException.class, () -> customerService.save(customer));

        verify(customerRepo, times(2)).findByEmail(anyString());
        verify(customerRepo).save(any(Customer.class));
    }

}
