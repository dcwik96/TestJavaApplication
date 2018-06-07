package com.projekt.projekt2;


import com.projekt.projekt2.entity.Article;
import com.projekt.projekt2.entity.Purchase;
import com.projekt.projekt2.repository.ArticleRepo;
import com.projekt.projekt2.repository.PurchaseRepo;
import com.projekt.projekt2.service.ArticleService;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;


@RunWith(EasyMockRunner.class)
public class ArticleTest {

    @TestSubject
    ArticleService articleService = new ArticleService();

    @Mock
    ArticleRepo articleRepoMock;

    @Mock
    PurchaseRepo purchaseRepo;

    private String name = "Name";
    private double value = 19.99;
    private Article article;

    @Before
    public void setUp() {
        article = new Article(name, value, null);
    }

    @Test
    public void checkIfUpdateNameWorksProperly() {
        expect(articleRepoMock.findByName(anyString())).andReturn(article);
        expect(articleRepoMock.save(anyObject())).andReturn(article);
        replay(articleRepoMock);

        Article newA = articleService.updateName(article, "nowa");

        assertEquals("nowa", newA.getName());
        verify(articleRepoMock);
    }

    @Test
    public void checkIfUpdateNameReturnNullWhenArticleNotFound() {
        expect(articleRepoMock.findByName(anyString())).andReturn(null);
        replay(articleRepoMock);

        assertNull(articleService.updateName(article, "nowa"));
        verify(articleRepoMock);
    }

    @Test
    public void checkIfSaveNewArticleReturnNew() {
        expect(articleRepoMock.findByName(anyString())).andReturn(null);
        expect(articleRepoMock.save(anyObject())).andReturn(article);
        replay(articleRepoMock);

        Article a = articleService.save(article);

        assertEquals(name, a.getName());
        assertEquals(value, a.getValue(), 0.00);
        verify(articleRepoMock);
    }

    @Test
    public void checkIfUpdateValueWorks() {
        expect(articleRepoMock.findByName(anyString())).andReturn(article);
        expect(articleRepoMock.save(anyObject())).andReturn(article);
        replay(articleRepoMock);

        Article newA = articleService.updateValue(article, 1000.00);

        assertEquals(1000.00, newA.getValue(), 0.00);
        verify(articleRepoMock);
    }

    @Test
    public void checkIfUpdateValueReturnNullWhenNotFound() {
        expect(articleRepoMock.findByName(anyString())).andReturn(null);
        replay(articleRepoMock);

        assertNull(articleService.updateValue(article, 1000.00));
        verify(articleRepoMock);
    }

    @Test
    public void checkIfDeleteArticleWorksProperly() {
        expect(articleRepoMock.findByName(anyString())).andReturn(article);
        expect(articleRepoMock.deleteByName(anyString())).andReturn(true);
        replay(articleRepoMock);

        assertTrue(articleService.deleteArticle(article));
        verify(articleRepoMock);
    }

    @Test
    public void checkIfDeleteArticleReturnFalseWhenNotFoundArticle() {
        expect(articleRepoMock.findByName(anyString())).andReturn(article);
        expect(articleRepoMock.deleteByName(anyString())).andReturn(false);
        replay(articleRepoMock);

        assertFalse(articleService.deleteArticle(article));
        verify(articleRepoMock);
    }

    @Test
    public void checkIfUpdatePurchaseWorks() {
        Purchase p = new Purchase();
        ArrayList<Purchase> purchases = new ArrayList<>();
        purchases.add(p);
        expect(articleRepoMock.findByName(anyString())).andReturn(article);
        expect(purchaseRepo.findPurchaseById(anyLong())).andReturn(p);
        expect(articleRepoMock.save(anyObject())).andReturn(article);
        replay(articleRepoMock);
        replay(purchaseRepo);

        assertEquals(purchases, articleService.updatePurchase(article, purchases).getPurchases());
        verify(articleRepoMock);
        verify(purchaseRepo);
    }

    @Test
    public void checkIfUpdateAtLeastTwoPurchasesWork() {
        Purchase p1 = new Purchase();
        Purchase p2 = new Purchase();
        ArrayList<Purchase> purchases = new ArrayList<>();
        purchases.add(p1);
        purchases.add(p2);
        expect(articleRepoMock.findByName(anyString())).andReturn(article);
        expect(purchaseRepo.findPurchaseById(anyLong())).andReturn(p1).anyTimes();
        expect(articleRepoMock.save(anyObject())).andReturn(article);
        replay(articleRepoMock);
        replay(purchaseRepo);

        assertEquals(2, articleService.updatePurchase(article, purchases).getPurchases().size());
        verify(articleRepoMock);
        verify(purchaseRepo);
    }

    @Test
    public void checkIfUpdatePurchaseReturnNullWhenPurchaseDoNotExists() {
        Purchase p = new Purchase();
        ArrayList<Purchase> purchases = new ArrayList<>();
        purchases.add(p);
        expect(articleRepoMock.findByName(anyString())).andReturn(article);
        expect(purchaseRepo.findPurchaseById(anyLong())).andReturn(null);
        replay(articleRepoMock);
        replay(purchaseRepo);

        assertNull(articleService.updatePurchase(article, purchases));
        verify(articleRepoMock);
        verify(purchaseRepo);
    }

}
