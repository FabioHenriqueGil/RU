/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaCaixa;
import br.ufpr.ru.modelo.Caixa;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fabio
 */
@Controller
public class ControllerRedirect {

    @RequestMapping("inicio")
    public String inicio() {
        return "index";
    }

    @RequestMapping("cadastro")
    public String cadastro() {
        return "subMenu/cadastro";
    }

   

//    @RequestMapping("caixa")
//    public String caixa(Model model) {
//        LogicaCaixa logica = new LogicaCaixa();
//        List<Caixa> caixas = logica.lista();
//
//        model.addAttribute("caixas", caixas);
//        return "subMenu/caixa";
//    }

    @RequestMapping("relatorio")
    public String relatorio() {
        return "subMenu/relatorio";
    }

}
