package com.co;

import com.co.DAO.ClienteDAO;
import com.co.pojo.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



/**
 *
 * @author ArqStevenAcuñaEspino
 */

//Anotacion de contro --- clase controladora
@Controller
public class ControladorInicio {
    @Autowired
    private ClienteDAO clienteDao;
    
    //Mapeo con Get --- mostrar Pagina
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
    
    @GetMapping("/login")
    public String iniciosesion(){
        return "iniciosesion";
    }
    
    @GetMapping("/loginadmin")
    public String loginadmin(Model model){
        var clientes = clienteDao.findAll();
        model.addAttribute("clientes",clientes);
        return "loginadmin";
    }
    

    
    @GetMapping("/crear")
    public String crear(){
        return "crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cliente cliente){
        clienteDao.save(cliente);        
        return "redirect:/loginadmin";
        
    }
    @GetMapping("/editar/{idcliente}")
    public String editar(@PathVariable("idcliente") Integer idcliente, Model model){
        var clientes=clienteDao.findById(idcliente);
        model.addAttribute("clientes", clientes);
        return "modificar";
        
    }
    
    @GetMapping("/eliminar/{idcliente}")
    public String eliminar(@PathVariable("idcliente") Integer idcliente){
        clienteDao.deleteById(idcliente);
        return "redirect:/loginadmin";
        
    }
   
        
    }
    
    