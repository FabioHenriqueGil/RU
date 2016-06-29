/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaConsumidor;
import br.ufpr.ru.logica.LogicaVenda;
import br.ufpr.ru.modelo.Consumidor;
import br.ufpr.ru.modelo.Venda;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fabio
 */
@Controller
public class ControllerVenda {
    
    @RequestMapping("vendas")
    public String vendas(Model model) {
        LogicaConsumidor logica = new LogicaConsumidor();
        List<Consumidor> consumidores = logica.listarConsumidoresAtivos();

        model.addAttribute("consumidores", consumidores);
        return "subMenu/vendas/vendas";
    }
    
    @RequestMapping("selecionaProdutos")
    public String selecConsumidor(Model model, Integer consumidor_id) {
        model.addAttribute("consumidor_id", consumidor_id);

        return "subMenu/vendas/selecionaProdutos";
    }
    
    
    
}
