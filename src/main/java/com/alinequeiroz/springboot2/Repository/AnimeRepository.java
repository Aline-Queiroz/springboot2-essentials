package com.alinequeiroz.springboot2.Repository;

import com.alinequeiroz.springboot2.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
