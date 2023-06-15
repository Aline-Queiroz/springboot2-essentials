package com.alinequeiroz.springboot2.service;

import com.alinequeiroz.springboot2.Repository.AnimeRepository;
import com.alinequeiroz.springboot2.domain.Anime;
import com.alinequeiroz.springboot2.requests.AnimePostRequestBody;
import com.alinequeiroz.springboot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService{

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return  animeRepository.findAll();
    }
    public Anime findByIdOrThrowBadRequestException(Long id) {
        return animeRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));

    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());

    }
    public void deleteAnime(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void updateAnime(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBody.getName())
                .build();

        animeRepository.save(anime);



    }
}
