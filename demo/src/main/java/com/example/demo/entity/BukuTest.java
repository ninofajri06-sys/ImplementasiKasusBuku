package com.example.demo.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BukuTest {

    @Test
    public void testTambahStok() {
        Buku buku = new Buku();
        buku.setStok(10);
        
        buku.tambahStok(5); // Act
        
        Assertions.assertEquals(15, buku.getStok()); // Assert
    }
}