package com.haydikodlayalim.api;

import com.haydikodlayalim.entity.Kullanici;
import com.haydikodlayalim.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciApi {
    @Autowired
    private KullaniciRepository kullaniciRepository;

    @PostConstruct
     public void init() {
        Kullanici kullanici = new Kullanici();
        kullanici.setAd("Ahmet");
        kullanici.setSoyadi("Durur");
        HashMap<String , Integer> olculer = new HashMap();
        olculer.put("Burun" , 1);
        olculer.put("Ağız" , 1);
        olculer.put("Kulak" , 2);
        olculer.put("Göz" , 2);
        kullanici.setOzellikleri(olculer);
        kullaniciRepository.save(kullanici);

    }

    @PostMapping
    public ResponseEntity<Kullanici> ekle (@RequestBody Kullanici kullanici){
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));
    }

    @GetMapping
    public ResponseEntity<List<Kullanici>> tumunuListele () {
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }

}
