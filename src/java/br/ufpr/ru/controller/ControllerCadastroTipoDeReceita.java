/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaModalidade;
import br.ufpr.ru.logica.LogicaTipoDeReceita;
import br.ufpr.ru.logica.LogicaVinculo;
import br.ufpr.ru.modelo.TipoDeReceita;
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
public class ControllerCadastroTipoDeReceita {
    
        
        private LogicaTipoDeReceita logicaTipoDeReceita;
@Autowired
    public ControllerCadastroTipoDeReceita(LogicaTipoDeReceita logicaTipoDeReceita) {
        this.logicaTipoDeReceita = logicaTipoDeReceita;
    }
        
        
    
     @RequestMapping("novoTipoDeReceita")
    public String form(Model model) {        
        return "subMenu/cadastro/fNovoTipoDeReceita";
    }

    @RequestMapping("adicionaTipoDeReceita")
    public String adiciona(TipoDeReceita tipo) {
        
        logicaTipoDeReceita.cadastraTipoDeReceita(tipo);
        return "redirect:listaTiposDeReceitas";
    }

    @RequestMapping("listaTiposDeReceitas")
    public String listarTiposDeReceitas(Model model) {
        List<TipoDeReceita> tipos = logicaTipoDeReceita.lista();

        model.addAttribute("tipos", tipos);
        return "subMenu/cadastro/tipoDeReceita";
    }
    
    
    @RequestMapping("mostraTipoDeReceita")
    public String mostraTipoDeReceita(int id, Model model) {
        model.addAttribute("tipo", logicaTipoDeReceita.buscaTipoDeReceita(id));
        
        return "subMenu/cadastro/fAltTipoDeReceita";

    }

    @RequestMapping("alteraTipoDeReceita")
    public String alteraVinculo(TipoDeReceita tipo) {
        
        logicaTipoDeReceita.alteraTipoDeReceita(tipo);
        return "redirect:listaTiposDeReceitas";
    }
}
