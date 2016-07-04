/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.dao.ConsumidorDao;
import br.ufpr.ru.dao.ModalidadeDao;
import br.ufpr.ru.dao.VinculoDao;
import br.ufpr.ru.logica.LogicaConsumidor;
import br.ufpr.ru.logica.LogicaModalidade;
import br.ufpr.ru.logica.LogicaVinculo;
import br.ufpr.ru.modelo.Consumidor;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.Vinculo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fabio
 */
@Controller
public class ControllerCadastroConsumidor {

    
        private LogicaConsumidor logicaConsumidor ;
        private LogicaModalidade logicaModalidade ;
        private LogicaVinculo logicaVinculo ;
@Autowired 
    public ControllerCadastroConsumidor(LogicaConsumidor logicaConsumidor, LogicaModalidade logicaModalidade, LogicaVinculo logicaVinculo) {
        this.logicaConsumidor = logicaConsumidor;
        this.logicaModalidade = logicaModalidade;
        this.logicaVinculo = logicaVinculo;
    }
    
  
    
    
    
    @RequestMapping("novoConsumidor")
    public String form(Model model, Integer idModalidade, String nome, String grr) {
       
        model.addAttribute("modalidades", logicaModalidade.listaAtivos());
        model.addAttribute("nome", nome);
        model.addAttribute("grr", grr);

        if (idModalidade != null) {
            Modalidade modalidade = logicaModalidade.buscaModalidade(idModalidade);
            model.addAttribute("vinculos", logicaVinculo.listaAtivos(modalidade));
        } else {
            model.addAttribute("vinculos", null);
        }

        return "subMenu/cadastro/fNovoConsumidor";
    }

    @RequestMapping("adicionaConsumidor")
    public String adiciona(Consumidor consumidor, Integer modalidade_id, Integer vinculo_id) {
        
        consumidor.setModalidade(logicaModalidade.buscaModalidade(modalidade_id));
        consumidor.setVinculo(logicaVinculo.buscaVinculo(vinculo_id));
        if (consumidor.getGrr().equals("")) {
            consumidor.setGrr("---");
        }
        logicaConsumidor.cadastrarConsumidor(consumidor);
        return "redirect:listaConsumidores";
    }

    @RequestMapping("listaConsumidores")
    public String listarConsumidor(Model model) {
       
        List<Consumidor> consumidores = logicaConsumidor.listarConsumidores();

        model.addAttribute("consumidores", consumidores);
        return "subMenu/cadastro/consumidor";
    }

    @RequestMapping("mostraConsumidor")
    public String mostraConsumidor(int id, Model model) {
        
        Modalidade modalidade = logicaModalidade.buscaModalidade(id);
        model.addAttribute("consumidor", logicaConsumidor.buscarConsumidor(id));
        model.addAttribute("modalidades", logicaModalidade.listaAtivos());      
        model.addAttribute("vinculos", logicaVinculo.listaAtivos(modalidade));
        return "subMenu/cadastro/fAltConsumidor";

    }
    
    @RequestMapping("mostraConsumidorAterado")
    public String formAltera(Model model, Integer id,Integer idModalidade, String nome, String grr, Boolean ativo) {
       
        Consumidor consumidor = new Consumidor();
        
        consumidor.setId(id);
        consumidor.setNome(nome);
        consumidor.setGrr(grr);
        consumidor.setModalidade(logicaModalidade.buscaModalidade(idModalidade));
        consumidor.setAtivo(ativo);
        
        model.addAttribute("consumidor", consumidor);
        model.addAttribute("modalidades", logicaModalidade.listaAtivos());        
        model.addAttribute("vinculos", logicaVinculo.listaAtivos(consumidor.getModalidade()));
        
        return "subMenu/cadastro/fAltConsumidor";
    }
    

    @RequestMapping("alteraConsumidor")
    public String alteraConsumidor(Consumidor consumidor, Integer modalidade_id, Integer vinculo_id) {
        
        consumidor.setModalidade(logicaModalidade.buscaModalidade(modalidade_id));
        consumidor.setVinculo(logicaVinculo.buscaVinculo(vinculo_id));
        if (consumidor.getGrr().equals("")) {
            consumidor.setGrr("---");
        }
        logicaConsumidor.alterarConsumidor(consumidor);
        return "redirect:listaConsumidores";
    }
}
