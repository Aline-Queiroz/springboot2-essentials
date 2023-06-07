package com.alinequeiroz.springboot2.Repository;

import com.alinequeiroz.springboot2.domain.Anime;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AnimeRepository {

    List<Anime> listAll();
}
