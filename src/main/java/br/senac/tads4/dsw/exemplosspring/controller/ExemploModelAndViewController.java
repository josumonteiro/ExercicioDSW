/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import br.senac.tads4.dsw.exemplosspring.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/exemplo")
public class ExemploModelAndViewController {
    
    private ProdutoService prod = new ProdutoServiceFakeImpl();

  @GetMapping("/ex1")
  public ModelAndView executar1() {
    return new ModelAndView("exemplo1");
  }

  @GetMapping("/ex2")
  public ModelAndView executar2() {
    List<Produto> lista = prod.listar(0, 0);

    return new ModelAndView("index")
            .addObject("listaAtrib", lista);
  }

  @GetMapping("/ex3")
  public ModelAndView executar3(@RequestParam(value = "nome", required = false) String nomeParam) {
    return new ModelAndView("exemplo3")
            .addObject("nomeInformado", nomeParam);
  }

  @GetMapping("/ex4/{nome}")
  public ModelAndView executar4(@PathVariable("nome") String nomeParam) {
    return new ModelAndView("exemplo4")
            .addObject("nomeInformado", nomeParam);
  }
}
