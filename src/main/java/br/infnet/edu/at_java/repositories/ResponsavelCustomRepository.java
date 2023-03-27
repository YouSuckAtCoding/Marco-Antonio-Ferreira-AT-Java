package br.infnet.edu.at_java.repositories;

import java.util.List;

import br.infnet.edu.at_java.Classes.Responsavel;

public interface ResponsavelCustomRepository {

	List<Responsavel> GetByUsuario(long UsuarioId);
}
