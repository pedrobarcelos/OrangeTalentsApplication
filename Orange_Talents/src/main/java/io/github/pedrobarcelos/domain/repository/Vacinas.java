package io.github.pedrobarcelos.domain.repository;

import io.github.pedrobarcelos.domain.entity.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vacinas extends JpaRepository<Vacina,Integer> {
}
