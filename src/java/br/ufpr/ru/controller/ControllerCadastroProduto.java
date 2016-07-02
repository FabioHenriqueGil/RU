/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaProduto;
import br.ufpr.ru.modelo.Produto;
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
public class ControllerCadastroProduto {

      
    
        private LogicaProduto logicaProduto ;
@Autowired
    public ControllerCadastroProduto(LogicaProduto logicaProduto) {
        this.logicaProduto = logicaProduto;
    }
       
        
    
    
    
    @RequestMapping("novoProduto")
    public String form(Model model) {        
        return "subMenu/cadastro/fNovoProduto";
    }

    @RequestMapping("adicionaProduto")
    public String adiciona(Produto produto) {
      
        
        logicaProduto.cadastraVinculo(produto);
        return "redirect:listaProdutos";
    }

    @RequestMapping("listaProdutos")
    public String listarProduto(Model model) {
       
        List<Produto> produtos = logicaProduto.lista();

        model.addAttribute("produtos", produtos);
        return "subMenu/cadastro/produto";
    }

    @RequestMapping("mostraProduto")
    public String mostraProduto(int id, Model model) {
       
        model.addAttribute("produto", logicaProduto.buscaProduto(id));
        
        return "subMenu/cadastro/fAltProduto";

    }

    @RequestMapping("alteraProduto")
    public String alteraProduto(Produto produto) {
      
        logicaProduto.alteraProduto(produto);
        return "redirect:listaProdutos";
    }
}
