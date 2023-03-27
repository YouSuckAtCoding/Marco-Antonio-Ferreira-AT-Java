package br.infnet.edu.at_java.repositories;

import java.util.List;

import br.infnet.edu.at_java.Classes.Compra;
import br.infnet.edu.at_java.Classes.Responsavel;

public interface CompraCustomRepository {

	List<Compra> GetCompraByUsuario(long UsuarioId);
}
