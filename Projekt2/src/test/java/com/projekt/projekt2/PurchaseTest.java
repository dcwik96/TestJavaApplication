package com.projekt.projekt2;

import com.projekt.projekt2.entity.Article;
import com.projekt.projekt2.entity.Customer;
import com.projekt.projekt2.entity.Purchase;
import com.projekt.projekt2.repository.ArticleRepo;
import com.projekt.projekt2.repository.CustomerRepo;
import com.projekt.projekt2.repository.MockPurchaseRepo;
import com.projekt.projekt2.service.PurchaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PurchaseTest {

    @MockBean
    ArticleRepo articleRepo;

    @MockBean
    CustomerRepo customerRepo;

    @Autowired
    PurchaseService purchaseService;

    private Customer c;
    private Purchase p;
    private Article a;

    @BeforeEach
    public void setUp() {
        purchaseService.setPurchaseRepo(new MockPurchaseRepo());
        c = new Customer("firstname", "asdf", "asdf");
        p = new Purchase();
        a = new Article("name", 10.00, null);
    }

    @Test
    public void checkUpdateCustomerProperly() {
        when(customerRepo.findByEmail(anyString())).thenReturn(c);
        assertNotNull(purchaseService.updateCustomer(p, c));

        verify(customerRepo).findByEmail(anyString());
    }

    @Test
    public void checkIfUpdateCustomerReturnNullWhenCustomerNotFound() {
        when(customerRepo.findByEmail(anyString())).thenReturn(null);

        assertNull(purchaseService.updateCustomer(p, c));
        verify(customerRepo).findByEmail(anyString());
    }

    @Test
    public void checkUpdateArticlesProperly() {
        when(articleRepo.findByName(anyString())).thenReturn(a);
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(a);

        assertNotNull(purchaseService.updateArticles(p, articles));
        verify(articleRepo).findByName(anyString());
    }

    @Test
    public void checkIfUpdateArticleReturnNullWhenArticleNotFound() {
        when(articleRepo.findByName(anyString())).thenReturn(null);
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(a);

        assertNull(purchaseService.updateArticles(p, articles));
        verify(articleRepo).findByName(anyString());
    }

    @Test
    public void checkSaveProperly() {
        when(customerRepo.findByEmail(anyString())).thenReturn(c);
        when(articleRepo.findByName(anyString())).thenReturn(a);
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(a);
        p.setCustomer(c);
        p.setArticles(articles);

        assertEquals(p, purchaseService.save(p));
        verify(articleRepo).findByName(anyString());
        verify(customerRepo).findByEmail(anyString());
    }

    @Test
    public void checkIfThrowExceptionWhenCustomerNotFound() {
        when(customerRepo.findByEmail(anyString())).thenReturn(null);
        when(articleRepo.findByName(anyString())).thenReturn(a);
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(a);
        p.setCustomer(c);
        p.setArticles(articles);

        assertThrows(IllegalArgumentException.class, () -> purchaseService.save(p));

        verify(articleRepo, never()).findByName(anyString());
        verify(customerRepo).findByEmail(anyString());
    }

    @Test
    public void checkIfThrowExceptionWhenFirstArticleNotFound() {
        when(customerRepo.findByEmail(anyString())).thenReturn(c);
        when(articleRepo.findByName(anyString())).thenReturn(null);
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(a);
        p.setCustomer(c);
        p.setArticles(articles);

        assertThrows(IllegalArgumentException.class, () -> purchaseService.save(p));

        verify(articleRepo).findByName(anyString());
        verify(customerRepo).findByEmail(anyString());
    }

    @Test
    public void checkIfThrowExceptionWhenSecondArticleNotFound() {
        when(customerRepo.findByEmail(anyString())).thenReturn(c);
        when(articleRepo.findByName(anyString())).thenReturn(a).thenReturn(null);
        Article a2 = new Article("nazwa2", 12.22, null);
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(a);
        articles.add(a2);
        p.setCustomer(c);
        p.setArticles(articles);

        assertThrows(IllegalArgumentException.class, () -> purchaseService.save(p));

        verify(articleRepo, times(2)).findByName(anyString());
        verify(customerRepo).findByEmail(anyString());
    }

    @Test
    public void checkIfAtrapWorks() {
        assertTrue(purchaseService.checkIfExistsInDb(10l));
    }

    @Test
    public void checkIfAtrapWorksTwo() {
        assertFalse(purchaseService.checkIfExistsInDb(101l));
    }


}
