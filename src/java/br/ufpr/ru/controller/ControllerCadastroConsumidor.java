/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaConsumidor;
import br.ufpr.ru.logica.LogicaModalidade;
import br.ufpr.ru.logica.LogicaVinculo;
import br.ufpr.ru.modelo.Consumidor;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.Vinculo;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fabio
 */
@Controller
public class ControllerCadastroConsumidor {

    @RequestMapping("novoConsumidor")
    public String form(Model model, Integer idModalidade, String nome, String grr) {
        LogicaVinculo lv = new LogicaVinculo();
        LogicaModalidade lm = new LogicaModalidade();
        model.addAttribute("modalidades", lm.lista());
        model.addAttribute("nome", nome);
        model.addAttribute("grr", grr);

        if (idModalidade != null) {
            Modalidade modalidade = lm.buscaModalidade(idModalidade);
            model.addAttribute("vinculos", lv.lista(modalidade));
        } else {
            model.addAttribute("vinculos", null);
        }

        return "subMenu/cadastro/fNovoConsumidor";
    }

    @RequestMapping("adicionaConsumidor")
    public String adiciona(Consumidor consumidor, Integer modalidade_id, Integer vinculo_id) {
        LogicaConsumidor logica = new LogicaConsumidor();
        LogicaModalidade lm = new LogicaModalidade();
        LogicaVinculo lv = new LogicaVinculo();
        consumidor.setModalidade(lm.buscaModalidade(modalidade_id));
        consumidor.setVinculo(lv.buscaVinculo(vinculo_id));

        logica.cadastrarConsumidor(consumidor);
        return "redirect:listaConsumidores";
    }

    @RequestMapping("listaConsumidores")
    public String listarConsumidor(Model model) {
        LogicaConsumidor logica = new LogicaConsumidor();
        List<Consumidor> consumidores = logica.listarConsumidores();

        model.addAttribute("consumidores", consumidores);
        return "subMenu/cadastro/consumidor";
    }

    @RequestMapping("mostraConsumidor")
    public String mostraConsumidor(int id, Model model) {
        LogicaConsumidor logica = new LogicaConsumidor();
        LogicaVinculo lv = new LogicaVinculo();
        LogicaModalidade lm = new LogicaModalidade();
        Modalidade modalidade = lm.buscaModalidade(id);
        model.addAttribute("consumidor", logica.buscarConsumidor(id));
        model.addAttribute("modalidades", lm.lista());      
        model.addAttribute("vinculos", lv.lista(modalidade));
        return "subMenu/cadastro/fAltConsumidor";

    }
    
    @RequestMapping("mostraConsumidorAterado")
    public String formAltera(Model model, Integer id,Integer idModalidade, String nome, String grr, Boolean ativo) {
        LogicaVinculo lv = new LogicaVinculo();
        LogicaModalidade lm = new LogicaModalidade();
        Consumidor consumidor = new Consumidor();
        
        consumidor.setId(id);
        consumidor.setNome(nome);
        consumidor.setGrr(grr);
        consumidor.setModalidade(lm.buscaModalidade(idModalidade));
        consumidor.setAtivo(ativo);
        
        model.addAttribute("consumidor", consumidor);
        model.addAttribute("modalidades", lm.lista());        
        model.addAttribute("vinculos", lv.lista(consumidor.getModalidade()));
        
        return "subMenu/cadastro/fAltConsumidor";
    }
    

    @RequestMapping("alteraConsumidor")
    public String alteraConsumidor(Consumidor consumidor, Integer modalidade_id, Integer vinculo_id) {
        LogicaConsumidor logica = new LogicaConsumidor();
        LogicaModalidade lm = new LogicaModalidade();
        LogicaVinculo lv = new LogicaVinculo();
        consumidor.setModalidade(lm.buscaModalidade(modalidade_id));
        consumidor.setVinculo(lv.buscaVinculo(vinculo_id));
        
        System.out.println("br.ufpr.ru.controller.ControllerCadastroConsumidor.alteraConsumidor()"+consumidor.getId());
        System.out.println("br.ufpr.ru.controller.ControllerCadastroConsumidor.alteraConsumidor()"+consumidor.getNome());
        System.out.println("br.ufpr.ru.controller.ControllerCadastroConsumidor.alteraConsumidor()"+consumidor.getGrr());
        System.out.println("br.ufpr.ru.controller.ControllerCadastroConsumidor.alteraConsumidor()"+consumidor.isAtivo());
        System.out.println("br.ufpr.ru.controller.ControllerCadastroConsumidor.alteraConsumidor()"+consumidor.getModalidade().getDescricao());
        System.out.println("br.ufpr.ru.controller.ControllerCadastroConsumidor.alteraConsumidor()"+consumidor.getVinculo().getDescricao());
        
        logica.alterarConsumidor(consumidor);
        return "redirect:listaConsumidores";
    }
}
