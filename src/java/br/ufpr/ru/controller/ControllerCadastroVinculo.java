/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaVinculo;
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
public class ControllerCadastroVinculo {
        private LogicaVinculo logicaVinculo ;
@Autowired
    public ControllerCadastroVinculo(LogicaVinculo logicaVinculo) {
        this.logicaVinculo = logicaVinculo;
    }
    
        
        
        
    @RequestMapping("novoVinculo")
    public String form(Model model) {        
        return "subMenu/cadastro/fNovoVinculo";
    }

    @RequestMapping("adicionaVinculo")
    public String adiciona(Vinculo vinculo) {
       
        
        logicaVinculo.cadastraVinculo(vinculo);
        return "redirect:listaVinculos";
    }

    @RequestMapping("listaVinculos")
    public String listarVinculo(Model model) {
        
        List<Vinculo> vinculos = logicaVinculo.lista();

        model.addAttribute("vinculos", vinculos);
        return "subMenu/cadastro/vinculo";
    }

    @RequestMapping("mostraVinculo")
    public String mostraVinculo(int id, Model model) {
        
        model.addAttribute("vinculo", logicaVinculo.buscaVinculo(id));
        
        return "subMenu/cadastro/fAltVinculo";

    }

    @RequestMapping("alteraVinculo")
    public String alteraVinculo(Vinculo vinculo) {
        logicaVinculo.alteraVinculo(vinculo);
        return "redirect:listaVinculos";
    }
}
