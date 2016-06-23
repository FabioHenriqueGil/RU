/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaVinculo;
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
public class ControllerCadastroVinculo {

    @RequestMapping("novoVinculo")
    public String form(Model model) {        
        return "subMenu/cadastro/fNovoVinculo";
    }

    @RequestMapping("adicionaVinculo")
    public String adiciona(Vinculo vinculo) {
        LogicaVinculo logica = new LogicaVinculo();
        
        logica.cadastraVinculo(vinculo);
        return "redirect:listaVinculos";
    }

    @RequestMapping("listaVinculos")
    public String listarVinculo(Model model) {
        LogicaVinculo logica = new LogicaVinculo();
        List<Vinculo> vinculos = logica.lista();

        model.addAttribute("vinculos", vinculos);
        return "subMenu/cadastro/vinculo";
    }

    @RequestMapping("mostraVinculo")
    public String mostraVinculo(int id, Model model) {
        LogicaVinculo logica = new LogicaVinculo();
        model.addAttribute("vinculo", logica.buscaVinculo(id));
        
        return "subMenu/cadastro/fAltVinculo";

    }

    @RequestMapping("alteraVinculo")
    public String alteraVinculo(Vinculo vinculo) {
        LogicaVinculo logica = new LogicaVinculo();
        
        logica.alteraVinculo(vinculo);
        return "redirect:listaVinculos";
    }
}
