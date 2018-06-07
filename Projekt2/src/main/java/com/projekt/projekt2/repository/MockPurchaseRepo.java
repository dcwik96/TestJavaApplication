package com.projekt.projekt2.repository;

import com.projekt.projekt2.entity.Purchase;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MockPurchaseRepo implements PurchaseRepo {

    @Override
    public <S extends Purchase> S save(S s) {
        return s;
    }

    @Override
    public Optional<Purchase> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return aLong < 100;
    }

    @Override
    public List<Purchase> findAll() {
        return null;
    }

    @Override
    public List<Purchase> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Purchase> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Purchase> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public <S extends Purchase> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Purchase purchase) {

    }

    @Override
    public void deleteAll(Iterable<? extends Purchase> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Purchase> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Purchase> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Purchase getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Purchase> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Purchase> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Purchase> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Purchase> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Purchase> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Purchase> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Purchase findPurchaseById(Long id) {
        return null;
    }
}
