package com.example.demo.control;

import com.example.demo.entity.Buku;
import com.example.demo.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StokService {

    @Autowired
    private BukuRepository bukuRepository;

    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }

    @Transactional
    public void updateStok(Long idBuku, int tambahanStok) {
        Buku buku = bukuRepository.findById(idBuku)
                .orElseThrow(() -> new IllegalArgumentException("Buku tidak ditemukan"));
        
        buku.tambahStok(tambahanStok);
        
        bukuRepository.save(buku);
    }
}