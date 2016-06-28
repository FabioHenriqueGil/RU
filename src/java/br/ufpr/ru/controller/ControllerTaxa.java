/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaTaxaDeSubsidio;
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
    public String form(Model model) {        
        return "subMenu/cadastro/fNovaTaxa";
    }

    @RequestMapping("adicionaTaxa")
    public String adiciona(TaxaDeSubsidio taxa) {
        LogicaTaxaDeSubsidio logica = new LogicaTaxaDeSubsidio();
        
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
    public String mostraTaxa(int modalidade_id,int produto_id, Model model) {
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

