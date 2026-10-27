package com.example.demo.boundary;

import com.example.demo.control.StokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HalamanStokController {

    @Autowired
    private StokService stokService;

    @GetMapping("/stok")
    public String tampilkanHalamanStok(Model model) {
        model.addAttribute("daftarBuku", stokService.getAllBuku());
        return "stok";
    }

    @PostMapping("/stok/update")
    public String prosesUpdateStok(@RequestParam Long idBuku, @RequestParam int tambahanStok) {
        stokService.updateStok(idBuku, tambahanStok);
        
        return "redirect:/stok";
    }
}