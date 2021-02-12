package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import java.sql.SQLException;
import java.util.ArrayList;


@Controller
public class HomeController {

    public HomeController() {
        System.out.println("*** HomeController ***");
    }

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model) throws SQLException {

        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts",posts);

        return "index";
    }
}
