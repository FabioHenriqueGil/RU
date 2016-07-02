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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fabio
 */
@Controller
public class ControllerTaxa {

    private LogicaTaxaDeSubsidio  logicaTaxaDeSubsidio;
    private LogicaModalidade logicaModalidade;
    private LogicaProduto logicaProduto; 
@Autowired
    public ControllerTaxa(LogicaTaxaDeSubsidio logicaTaxaDeSubsidio, LogicaModalidade logicaModalidade, LogicaProduto logicaProduto) {
        this.logicaTaxaDeSubsidio = logicaTaxaDeSubsidio;
        this.logicaModalidade = logicaModalidade;
        this.logicaProduto = logicaProduto;
    }
    
    

    @RequestMapping("novaTaxa")
    public String form(Model model, Double desconto, Integer modalidade_id) {
      
        model.addAttribute("modalidades", logicaModalidade.listaAtivos());
        model.addAttribute("desconto", desconto);

        if (modalidade_id != null) {
            Modalidade modalidade = logicaModalidade.buscaModalidade(modalidade_id);
            model.addAttribute("produtos", logicaProduto.listaAtivos());
        } else {
            model.addAttribute("produtos", null);
        }

        return "subMenu/cadastro/fNovaTaxa";
    }

    @RequestMapping("adicionaTaxa")
    public String adiciona(Model model, TaxaDeSubsidio taxa, Integer modalidade_id, Integer produto_id) {
       
        taxa.setModalidade(logicaModalidade.buscaModalidade(modalidade_id));
        taxa.setProduto(logicaProduto.buscaProduto(produto_id));
        if (logicaTaxaDeSubsidio.buscaTaxa(modalidade_id, produto_id).getModalidade() == null) {
            logicaTaxaDeSubsidio.cadastraTaxa(taxa);
            return "redirect:listaTaxas";
        } else {
            model.addAttribute("taxa", logicaTaxaDeSubsidio.buscaTaxa(modalidade_id, produto_id));

            model.addAttribute("flagInsert", true);
            return "subMenu/cadastro/fAltTaxa";
        }

    }

    @RequestMapping("listaTaxas")
    public String listarTaxas(Model model) {
        
        List<TaxaDeSubsidio> taxas = logicaTaxaDeSubsidio.lista();

        model.addAttribute("taxas", taxas);
        return "subMenu/cadastro/taxa";
    }

    @RequestMapping("mostraTaxa")
    public String mostraTaxa(Integer modalidade_id, Integer produto_id, Model model) {
        System.out.println("br.ufpr.ru.controller.ControllerTaxa.mostraTaxa() " + modalidade_id);
        System.out.println("br.ufpr.ru.controller.ControllerTaxa.mostraTaxa() " + produto_id);
        
        model.addAttribute("taxa", logicaTaxaDeSubsidio.buscaTaxa(modalidade_id, produto_id));
        return "subMenu/cadastro/fAltTaxa";

    }

    @RequestMapping("alteraTaxa")
    public String alteraTaxa(TaxaDeSubsidio taxa, Integer modalidade_id, Integer produto_id) {

        taxa.setModalidade(logicaModalidade.buscaModalidade(modalidade_id));
        taxa.setProduto(logicaProduto.buscaProduto(produto_id));
        logicaTaxaDeSubsidio.alteraTaxa(taxa);
        return "redirect:listaTaxas";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
