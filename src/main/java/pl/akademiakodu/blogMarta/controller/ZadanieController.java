package pl.akademiakodu.blogMarta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.blogMarta.model.Comment;
import pl.akademiakodu.blogMarta.model.Zadanie;
import pl.akademiakodu.blogMarta.repository.CommentRepository;
import pl.akademiakodu.blogMarta.repository.ZadanieRepository;

@Controller
public class ZadanieController {
    @Autowired
    ZadanieRepository zadanieRepository;

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    //Ten @GetMapping odpowiedzialny jest za utowrzenie nowego obiektu
    @GetMapping("/")
    public String add(ModelMap map){
        map.put("zadania", zadanieRepository.findAll());
        map.put("zadanie", new Zadanie());
        return "home";
    }

    // Ten @PostMapping odpowiedzialny jest za zapisanie w bazie danych nowego zadania
    // i za to, ze po wcisnieciu przycisk "dodaj" przekierowuje nas na kolejna stronr
    @PostMapping("/zadania") // --> to nas przekierowuje na url localhost:8080/add ,
    /// gdzie beda wyswietlane wszystkie zadania
    /// pliik.html za to dpowiedzialny to all
    public String add(@ModelAttribute Zadanie zadanie, ModelMap map){
        zadanieRepository.save(zadanie);
        map.put("zadania",zadanieRepository.findAll());
        return "all";
    }

    @GetMapping("/zadania")
    public String zadania(ModelMap map){
        map.put("zadania", zadanieRepository.findAll());
        return "all";
    }
    @GetMapping("/zadania/{id}")
    // --------------------------------------------------------------------------------------------
    public String zadaniaID(@PathVariable Integer id, ModelMap map){
        Zadanie zadanie = zadanieRepository.findById(id).get();
        map.put("zadanie", zadanie);
        // do tego momentu, ten GetMapping po wprowadzeniu sciezki zadania/{id} daje nam
        // konkretne zadanie, co zwiazane jest z tym , ze w html znajduje sie th:text=${zadanie}
        // ------------------------------------------------------------------------------------------
        Comment comment = new Comment();
        comment.setZadanie(zadanie);
        map.put("comment", comment);
        return "details";

    }
    @Autowired
    CommentRepository commentRepository;

    @PostMapping ("/comments")
    public String addComment(@ModelAttribute Comment comment, ModelMap map){
        commentRepository.save(comment);
        map.put("comments", commentRepository.findAll());

        return "redirect:/zadania/"+comment.getZadanie().getId();
    }

}