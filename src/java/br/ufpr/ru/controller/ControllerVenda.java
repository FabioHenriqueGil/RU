/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.controller;

import br.ufpr.ru.logica.LogicaCaixa;
import br.ufpr.ru.logica.LogicaConsumidor;
import br.ufpr.ru.logica.LogicaProduto;
import br.ufpr.ru.logica.LogicaTaxaDeSubsidio;
import br.ufpr.ru.logica.LogicaTipoDeReceita;
import br.ufpr.ru.logica.LogicaVenda;
import br.ufpr.ru.modelo.Caixa;
import br.ufpr.ru.modelo.Checkin;
import br.ufpr.ru.modelo.Consumidor;
import br.ufpr.ru.modelo.Produto;
import br.ufpr.ru.modelo.TipoDeReceita;
import br.ufpr.ru.modelo.Venda;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fabio
 */
@Controller
public class ControllerVenda {

    private LogicaConsumidor logicaConsumidor;
    private LogicaProduto logicaProdutos;
    private LogicaTaxaDeSubsidio logicaTaxaDeSubsidio;
    private LogicaTipoDeReceita logicaTipoDeReceita;
    private LogicaVenda logicaVenda;
    private LogicaCaixa logicaCaixa;

    @Autowired
    public ControllerVenda(LogicaConsumidor logicaConsumidor, LogicaProduto logicaProdutos, 
            LogicaTaxaDeSubsidio logicaTaxaDeSubsidio, LogicaTipoDeReceita logicaTipoDeReceita,
            LogicaVenda logicaVenda, LogicaCaixa logicaCaixa) {
        this.logicaConsumidor = logicaConsumidor;
        this.logicaProdutos = logicaProdutos;
        this.logicaTaxaDeSubsidio = logicaTaxaDeSubsidio;
        this.logicaTipoDeReceita = logicaTipoDeReceita;
        this.logicaVenda = logicaVenda;
        this.logicaCaixa = logicaCaixa;
    }

    @RequestMapping("/filtrarConsumidor")
    public String filtraConsumidor(String filtroC, Model model) throws SQLException {
        List<Consumidor> list = logicaConsumidor.listarConsumidores(filtroC);
        System.out.print(filtroC);

        model.addAttribute("consumidores", list);
        return "subMenu/vendas/filtroClientes";

    }
    

    @RequestMapping("vendas")
    public String vendas(Model model) {

        List<Consumidor> consumidores = logicaConsumidor.listarConsumidoresAtivos();

        model.addAttribute("consumidores", consumidores);
        return "subMenu/vendas/vendas";
    }

    @RequestMapping("selecionaProdutos")
    public String selecConsumidor(Model model, Integer consumidor_id) {
        Consumidor consumidor = logicaConsumidor.buscarConsumidor(consumidor_id);
        model.addAttribute("consumidor", consumidor);
        model.addAttribute("qtdItens", 0);
        model.addAttribute("total", 0.00);
        List<Produto> produtos = logicaProdutos.listaAtivos();
        for (Produto produto : produtos) {
            produto.setPrecoVenda((produto.getPrecoPadrao()
                    - logicaTaxaDeSubsidio.buscaTaxa(consumidor.getModalidade().getId(), produto.getId()).getDesconto()));

        }
        Checkin checkin = new Checkin(consumidor, Calendar.getInstance());
        
        TipoDeReceita tipoDeReceita = logicaTipoDeReceita.buscaTipoDeReceita(1);
        Caixa caixa = logicaCaixa.buscaUltimoCaixa();
        Venda venda = new Venda(checkin, tipoDeReceita, caixa);
        logicaVenda.cadastraVenda(venda);
        model.addAttribute("venda", venda);
        model.addAttribute("buscaProdutos", produtos);
        model.addAttribute("tiposDeReceita", logicaTipoDeReceita.lista());

        return "subMenu/vendas/selecionaProdutos";
    }

    @RequestMapping("/adicionaProdutoVenda")
    public String AdicionaProdutos(Integer idProduto, Double precoVenda ,Integer idVenda, Model model ) throws SQLException {
        Produto produto = logicaProdutos.buscaProduto(idProduto);
        produto.setPrecoVenda(precoVenda);
        Venda venda = logicaVenda.buscaVenda(idVenda);        
        venda.addProduto(produto);
        logicaVenda.alteraVenda(venda);
        
        
        model.addAttribute("venda",venda);
        model.addAttribute("produtos", venda.getListaDeProdutos());
        return "subMenu/vendas/produtosSelecionados";

    }
}
