package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.enums.StatusRequisicao;
import java.time.LocalDate;
import java.util.List;

public interface RequisicaoDao extends DefaultDao<Requisicao> {
    public List<Requisicao> buscarPeloStatus(StatusRequisicao statusRequisicao, LocalDate data);
}
