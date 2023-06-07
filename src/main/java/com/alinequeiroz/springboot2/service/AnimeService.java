package com.alinequeiroz.springboot2.service;

import com.alinequeiroz.springboot2.Repository.AnimeRepository;
import com.alinequeiroz.springboot2.domain.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService{



    private static List<Anime> animes;




    static {
       animes = new ArrayList<>(List.of(new Anime(1L,"Boruto"), new Anime(2L, "Naruto" )));
    }
    public List<Anime> listAll() {
        return  animes;
    }
    public Anime findById(Long id) {
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3,100000));
        animes.add(anime);
        return anime;
    }
    public void deleteAnime(long id) {
        animes.remove(findById(id));
    }

}
