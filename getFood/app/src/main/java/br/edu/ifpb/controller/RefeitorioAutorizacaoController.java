package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Autorizacao;
import br.edu.ifpb.domain.enums.StatusAutorizacao;
import br.edu.ifpb.firebase.GerenteNotificacao;
import br.edu.ifpb.firebase.Notificacao;
import br.edu.ifpb.service.AutorizacaoService;
import com.google.firebase.messaging.FirebaseMessagingException;
import java.io.IOException;



import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class RefeitorioAutorizacaoController implements Serializable {

    @Inject
    private AutorizacaoService autorizacaoService;

    @Inject
    private Notificacao notificacao;
    
    private LocalDate dataHoje;
    private LocalTime horaAgora;
    private List<Autorizacao> todasAltorizacoes;
    private List<Autorizacao> autorizacaoJantar;
    private List<Autorizacao> autorizacaoAumoco;
    private List<Autorizacao> autorizacaoAgora;
    private String tipoRefeicao;
    private Boolean ativo; 
    private final LocalTime terminoAlmoco = LocalTime.parse("14:00:00");

    @PostConstruct
    private void init() {
        dataHoje = LocalDate.now();
        horaAgora = LocalTime.now();
        autorizacaoAumoco = new ArrayList<>();
        autorizacaoJantar = new ArrayList<>();
        autorizacoesHoje();
        separarPorRefeicao();
        auternarRefeicao();
        verificaSeAtivo();
    }

    private void autorizacoesHoje() {
        todasAltorizacoes = autorizacaoService.buscar(dataHoje);
    }

    private void separarPorRefeicao() {
        todasAltorizacoes.stream().forEach(a -> {
            if (a.getRefeicao().getNome().equalsIgnoreCase("Jantar")) {
                autorizacaoJantar.add(a);
            } else {
                autorizacaoAumoco.add(a);
            }
        }
        );
    }

    private void auternarRefeicao() {
        int value = horaAgora.compareTo(terminoAlmoco);
        if (value > 0) {
            tipoRefeicao = "Jantar";
            autorizacaoAgora = autorizacaoJantar;
        } else {
            tipoRefeicao = "Almoço";
            autorizacaoAgora = autorizacaoAumoco;
        }
    }

    public String finalizarRefeicao() {
        autorizacaoAgora.stream().forEach(a -> {
            if (a.getStatusAutorizacao().equals(StatusAutorizacao.PENDENTE)) {
                ausenteAutorizacao(a.getId());
                try {
                    notificacao.notificarAll();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (FirebaseMessagingException e) {
                    e.printStackTrace();
                }
            }
        }
        );
        return "listagem.xhtml";
    }
    
     private void verificaSeAtivo() {
        ativo = false;
        boolean result = autorizacaoAgora.stream().anyMatch(obj -> obj.getStatusAutorizacao().equals(StatusAutorizacao.PENDENTE));
        ativo = result;
    }

    public String confirmarAutorizacao(Long idAltorizacao) {
        autorizacaoService.alterarStatusAutorizacao(idAltorizacao, StatusAutorizacao.REALIZADA);
        return "listagem.xhtml";
    }

    public String renunciarAutorizacao(Long idAltorizacao) {
        autorizacaoService.alterarStatusAutorizacao(idAltorizacao, StatusAutorizacao.RENUNCIADA);
        return "listagem.xhtml";
    }

    public void ausenteAutorizacao(Long idAltorizacao) {
        autorizacaoService.alterarStatusAutorizacao(idAltorizacao, StatusAutorizacao.AUSENTE);
    }

    public LocalDate getDataHoje() {
        return dataHoje;
    }

    public LocalTime getHoraAgora() {
        return horaAgora;
    }

    public List<Autorizacao> getAutorizacaoJantar() {
        return autorizacaoJantar;
    }

    public List<Autorizacao> getAutorizacaoAumoco() {
        return autorizacaoAumoco;
    }

    public List<Autorizacao> getAutorizacaoAgora() {
        return autorizacaoAgora;
    }

    public int totalAlmoco() {
        return autorizacaoAumoco.size();
    }

    public int totalJantares() {
        return autorizacaoJantar.size();
    }

    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

   

}