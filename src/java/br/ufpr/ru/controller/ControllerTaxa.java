/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaModalidade;
import br.ufpr.ru.logica.LogicaProduto;
import br.ufpr.ru.logica.LogicaTaxaDeSubsidio;
import br.ufpr.ru.logica.LogicaVinculo;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.TaxaDeSubsidio;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fabio
 */
@Controller
public class ControllerTaxa {

    @RequestMapping("novaTaxa")
    public String form(Model model, Double desconto,Integer modalidade_id) {
        LogicaProduto lp = new LogicaProduto();
        LogicaModalidade lm = new LogicaModalidade();
        model.addAttribute("modalidades", lm.listaAtivos());
        model.addAttribute("desconto", desconto);
       

        if (modalidade_id != null) {
            Modalidade modalidade = lm.buscaModalidade(modalidade_id);
            model.addAttribute("produtos", lp.listaAtivos());
        } else {
            model.addAttribute("produtos", null);
        }

        return "subMenu/cadastro/fNovaTaxa";
    }

    @RequestMapping("adicionaTaxa")
    public String adiciona(TaxaDeSubsidio taxa,Integer modalidade_id, Integer produto_id) {
        LogicaTaxaDeSubsidio logica = new LogicaTaxaDeSubsidio();
        LogicaModalidade lm = new LogicaModalidade();
        LogicaProduto lp =new LogicaProduto();
        taxa.setModalidade(lm.buscaModalidade(modalidade_id));
        taxa.setProduto(lp.buscaProduto(produto_id));

        logica.cadastraTaxa(taxa);
        return "redirect:listaTaxas";
    }

    @RequestMapping("listaTaxas")
    public String listarTaxas(Model model) {
        LogicaTaxaDeSubsidio logica = new LogicaTaxaDeSubsidio();
        List<TaxaDeSubsidio> taxas = logica.lista();

        model.addAttribute("taxas", taxas);
        return "subMenu/cadastro/taxa";
    }

    @RequestMapping("mostraTaxas")
    public String mostraTaxa(int modalidade_id, int produto_id, Model model) {
        LogicaTaxaDeSubsidio logica = new LogicaTaxaDeSubsidio();
        model.addAttribute("taxa", logica.buscaTaxa(modalidade_id, produto_id));

        return "subMenu/cadastro/fAltTaxa";

    }

    @RequestMapping("alteraTaxa")
    public String alteraTaxa(TaxaDeSubsidio taxa) {
        LogicaTaxaDeSubsidio logica = new LogicaTaxaDeSubsidio();

        logica.alteraTaxa(taxa);
        return "redirect:listaTaxas";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
