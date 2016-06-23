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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fabio
 */
@Controller
public class ControllerCadastroModalidade {

    @RequestMapping("novaModalidade")
    public String form(Model model) {
        LogicaVinculo logica = new LogicaVinculo();
        model.addAttribute("vinculos", logica.lista());
        return "subMenu/cadastro/fNovaModalidade";
    }

    @RequestMapping("adicionaModalidade")
    public String adiciona(Modalidade modalidade, String vinculosBloqueados) {
        LogicaModalidade logica = new LogicaModalidade();
        LogicaVinculo lv = new LogicaVinculo();
        List<Vinculo> listaVinculos = new ArrayList<>();
        String[] vbArray = vinculosBloqueados.split(",");

        for (String string : vbArray) {
            System.out.println("br.ufpr.ru.controller.ControllerCadastroModalidade.adiciona()" + string);
            listaVinculos.add(lv.buscaVinculo(Integer.parseInt(string)));

        }
        modalidade.setVinculosBloqueados(listaVinculos);

        logica.cadastraModalidade(modalidade);
        return "redirect:listaModalidades";
    }

    @RequestMapping("listaModalidades")
    public String listarModalidades(Model model) {
        LogicaModalidade logica = new LogicaModalidade();
        List<Modalidade> modalidades = logica.lista();
        List<Vinculo> bloqueados = new LinkedList<>();

        model.addAttribute("modalidades", modalidades);
        model.addAttribute("bloqueados", bloqueados);
        return "subMenu/cadastro/modalidade";
    }

    @RequestMapping("mostraModalidade")
    public String mostraModalidade(int id, Model model) {
        LogicaModalidade logicaModalidade = new LogicaModalidade();
        LogicaVinculo logicaVinculo = new LogicaVinculo();
        model.addAttribute("modalidade", logicaModalidade.buscaModalidade(id));
        model.addAttribute("vinculos", logicaVinculo.lista(logicaModalidade.buscaModalidade(id)));

        return "subMenu/cadastro/fAltModalidade";

    }

    @RequestMapping("alteraModalidade")
    public String alteraModalidade(Modalidade modalidade, String vinculosBloqueados) {
        LogicaModalidade logica = new LogicaModalidade();
        LogicaVinculo lv = new LogicaVinculo();
        List<Vinculo> listaVinculos = new ArrayList<>();
        String[] vbArray = vinculosBloqueados.split(",");

        for (String string : vbArray) {
            System.out.println("br.ufpr.ru.controller.ControllerCadastroModalidade.adiciona()" + string);
            listaVinculos.add(lv.buscaVinculo(Integer.parseInt(string)));

        }
        modalidade.setVinculosBloqueados(listaVinculos);

        logica.alteraModalidade(modalidade);
        return "redirect:listaModalidades";
    }
}
