package br.com.scherer.index.repository;

import br.com.scherer.index.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexRepository extends JpaRepository<Contato, Long> {

}
