/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaCaixa;
import br.ufpr.ru.logica.LogicaVinculo;
import br.ufpr.ru.modelo.Caixa;
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
public class ControllerCaixa {

    private LogicaCaixa logicaCaixa;
@Autowired
    public ControllerCaixa(LogicaCaixa logicaCaixa) {
        this.logicaCaixa = logicaCaixa;
    }
    
    
    
    @RequestMapping("novoCaixa")
    public String form(Model model) {
        return "subMenu/fNovoCaixa";
    }

    @RequestMapping("adicionaCaixa")
    public String adiciona(Caixa caixa) {
      
        logicaCaixa.cadastraCaixa(caixa);
        return "redirect:listaCaixas";
    }

    @RequestMapping("listaCaixas")
    public String listarCaixa(Model model) {
       
        List<Caixa> caixas = logicaCaixa.lista();

        model.addAttribute("caixas", caixas);
        return "subMenu/caixa";
    }

}
