package test.spring;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller1 {

	/*@RequestMapping(value = { "/article", "/article/{id}" })
	public String getArticle(@PathVariable(name = "id", required = false) Integer articleId) {
		
		return null;
	}*/
/*
	@RequestMapping(value = { "/articleOpt/{id}" })
	public String getArticle(@PathVariable() Optional<Integer> id) {

		if(id != null)
			return id.get().toString();
		else return "empty";
	}
	*/

	@RequestMapping(value = {"/articleMap/{id}"})
	@ResponseBody
    public String getArticle(@PathVariable Map<String, String> id) {
		if(id != null)
			return id.toString();
		else return "empty";
    }

}
