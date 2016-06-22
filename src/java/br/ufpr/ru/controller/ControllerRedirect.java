/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import org.springframework.stereotype.Controller;
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

    @RequestMapping("vendas")
    public String vendas() {
        return "subMenu/vendas";
    }

    @RequestMapping("caixa")
    public String caixa() {
        return "subMenu/caixa";
    }

    @RequestMapping("relatorio")
    public String relatorio() {
        return "subMenu/relatorio";
    }
    
}
