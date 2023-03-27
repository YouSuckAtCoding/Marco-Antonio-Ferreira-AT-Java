package br.infnet.edu.at_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.infnet.edu.at_java.Classes.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>, CompraCustomRepository{

}
