package com.haydikodlayalim.api;

import com.haydikodlayalim.model.Book;
import com.haydikodlayalim.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookApi {
    private  final BookRepository bookRepository;


    //Manuel Pagination
    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize
            ,@RequestParam Integer page){

        Pageable pageable = PageRequest.of(page, pageSize);
        return bookRepository.findAll(pageable);
    }
    //Springin Pagination'u
    @GetMapping("/p")
    public Page<Book> pagination(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
    /*Slice ile pagination yapınca totalElement'i çekmiyor
        onun yerine pagesize+1 kayıt çekiyor
        çok fazla veri dönen sorgularda kullanmak için ideal
        ornek olarak twitter'da aşşağıya kaydıkça yeni verilerin
        load edilmesi veya forum sitelerinde alttaki sayfa indexi olarak
        1,2,3....,n değilde yanlızca previous,current,next page indexlerinin
        bulunması
    */
    @GetMapping("/s")
    public Slice<Book> slice(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}
