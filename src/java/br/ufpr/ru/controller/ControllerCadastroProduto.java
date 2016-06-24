/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaProduto;
import br.ufpr.ru.modelo.Produto;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fabio
 */
@Controller
public class ControllerCadastroProduto {

    @RequestMapping("novoProduto")
    public String form(Model model) {        
        return "subMenu/cadastro/fNovoProduto";
    }

    @RequestMapping("adicionaProduto")
    public String adiciona(Produto produto) {
        LogicaProduto logica = new LogicaProduto();
        
        logica.cadastraVinculo(produto);
        return "redirect:listaProdutos";
    }

    @RequestMapping("listaProdutos")
    public String listarProduto(Model model) {
        LogicaProduto logica = new LogicaProduto();
        List<Produto> produtos = logica.lista();

        model.addAttribute("produtos", produtos);
        return "subMenu/cadastro/produto";
    }

    @RequestMapping("mostraProduto")
    public String mostraProduto(int id, Model model) {
        LogicaProduto logica = new LogicaProduto();
        model.addAttribute("produto", logica.buscaProduto(id));
        
        return "subMenu/cadastro/fAltProduto";

    }

    @RequestMapping("alteraProduto")
    public String alteraProduto(Produto produto) {
        LogicaProduto logica = new LogicaProduto();
        
        logica.alteraProduto(produto);
        return "redirect:listaProdutos";
    }
}
