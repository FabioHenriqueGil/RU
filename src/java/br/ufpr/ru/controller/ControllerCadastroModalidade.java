/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaModalidade;
import br.ufpr.ru.logica.LogicaVinculo;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.Vinculo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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
public class ControllerCadastroModalidade {

    
    
        private LogicaModalidade logicaModalidade ;
        private LogicaVinculo logicaVinculo ;
@Autowired
    public ControllerCadastroModalidade(LogicaModalidade logicaModalidade, LogicaVinculo logicaVinculo) {
        this.logicaModalidade = logicaModalidade;
        this.logicaVinculo = logicaVinculo;
    }
    
    
    
    @RequestMapping("novaModalidade")
    public String form(Model model) {
        
        model.addAttribute("vinculos", logicaVinculo.listaAtivos());
        return "subMenu/cadastro/fNovaModalidade";
    }

    @RequestMapping("adicionaModalidade")
    public String adiciona(Modalidade modalidade, String vinculosBloqueados) {
       
        List<Vinculo> listaVinculos = new ArrayList<>();
        String[] vbArray = vinculosBloqueados.split(",");
        if (modalidade.getDescricao() == "") {
            return "redirect:novaModalidade";
        }
        for (String string : vbArray) {
            System.out.println("br.ufpr.ru.controller.ControllerCadastroModalidade.adiciona()" + string);
            listaVinculos.add(logicaVinculo.buscaVinculo(Integer.parseInt(string)));

        }
        modalidade.setVinculosBloqueados(listaVinculos);

        logicaModalidade.cadastraModalidade(modalidade);
        return "redirect:listaModalidades";
    }

    @RequestMapping("listaModalidades")
    public String listarModalidades(Model model) {
        
        List<Modalidade> modalidades = logicaModalidade.lista();
        List<Vinculo> bloqueados = new LinkedList<>();

        model.addAttribute("modalidades", modalidades);
        model.addAttribute("bloqueados", bloqueados);
        return "subMenu/cadastro/modalidade";
    }

    @RequestMapping("mostraModalidade")
    public String mostraModalidade(int id, Model model) {
        
        model.addAttribute("modalidade", logicaModalidade.buscaModalidade(id));
        model.addAttribute("vinculos", logicaVinculo.listaAtivos(logicaModalidade.buscaModalidade(id)));

        return "subMenu/cadastro/fAltModalidade";

    }

    @RequestMapping("alteraModalidade")
    public String alteraModalidade(Modalidade modalidade, String vinculosBloqueados) {
      
        List<Vinculo> listaVinculos = new ArrayList<>();

        if (modalidade.getDescricao() == "") {
            return "redirect:mostraModalidade?id="+modalidade.getId();
        }
        if (vinculosBloqueados != null && vinculosBloqueados != "") {
            String[] vbArray = vinculosBloqueados.split(",");

            for (String string : vbArray) {
                System.out.println("br.ufpr.ru.controller.ControllerCadastroModalidade.adiciona()" + string);
                listaVinculos.add(logicaVinculo.buscaVinculo(Integer.parseInt(string)));

            }
        }
        modalidade.setVinculosBloqueados(listaVinculos);

        logicaModalidade.alteraModalidade(modalidade);
        return "redirect:listaModalidades";
    }
}
