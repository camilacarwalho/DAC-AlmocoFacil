
package br.edu.ifpb.service;


import br.edu.ifpb.domain.Autorizacao;
import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.enums.StatusAutorizacao;
import java.time.LocalDate;
import java.util.List;

public interface AutorizacaoService {

    public void salvar(Autorizacao autorizacao);
    public List<Autorizacao> listar();
    public List<Autorizacao> buscarData(LocalDate data, Refeicao refeicao);
    public Autorizacao buscar(int id);
    public void Atualizar(Autorizacao autorizacao);
    public List<Autorizacao> buscar(LocalDate data);
    public void gerarAutorizacoes();
    public void gerarAutorizacoes(LocalDate data, Refeicao refeicao);
    public void finalizarAutorizacoes(LocalDate data, Refeicao refeicao);
    public void alterarStatusAutorizacao(Long idAltorizacao, StatusAutorizacao statusAutorizacao);
    public void finalizarTodasAutorizacoesPendentesHoje();
    public int quantAutorizacaoRR(LocalDate dataInicial, LocalDate dataFinal);
    public List<AutorizacaoRR> listarAutorizacaoRR(int min, int quant, LocalDate dataInicial, LocalDate dataFinal);
<<<<<<< HEAD

=======
    public List<AutorizacaoRR> listarAutorizacaoRRApi(LocalDate dataInicial, LocalDate dataFinal);
        
>>>>>>> develop-android
}
