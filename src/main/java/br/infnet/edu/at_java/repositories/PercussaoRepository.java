package br.infnet.edu.at_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.infnet.edu.at_java.Classes.Filhas.Percussao;

@Repository
public interface PercussaoRepository extends JpaRepository<Percussao, Long>{

}
