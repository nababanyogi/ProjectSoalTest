package tamvan.magangTest.soalTest.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import tamvan.magangTest.soalTest.Dao.UserDao;
import tamvan.magangTest.soalTest.Model.User;

@Controller
public class UserController extends WebMvcConfigurerAdapter {
    
	
	private UserDao userDao;
			
    @Autowired    
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    
    @RequestMapping("/index")
	public String MahasiswaList(Model model){		
		model.addAttribute("user",userDao.listUser());
		return "list";
	}

    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("list");
    }

    
    @GetMapping("/add")
    public String showForm2(User user) {
        return "add";
    }

    @PostMapping("/add")
    public String checkPersonInfo2(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "add";
        }
        model.addAttribute("user",userDao.saveOrUpdate(user));
        return "redirect:/index";
    }
	@RequestMapping(value = "/index/{id}")
	public String hapus(@PathVariable Integer id){
		userDao.hapus(id);
		return "redirect:/index";
	}
}
