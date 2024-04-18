package br.com.unicuritiba.cadastrodeplanetas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.unicuritiba.cadastrodeplanetas.models.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Long>{

}
