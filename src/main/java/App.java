import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";
        String index = "templates/index.vtl";

        get("/", ((request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heroes", request.session().attribute("heroes"));
            model.put("template", index);
            return new ModelAndView(model, layout);
        }), new VelocityTemplateEngine());

        get("/hero-form", ((request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/hero-form.vtl");
            return new ModelAndView(model, layout);
        }), new VelocityTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heroes", Hero.getHeroes());
            model.put("template", "templates/heroes.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/heroes", ((request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = request.session().attribute("heroes");
            if (heroes == null){
                heroes = new ArrayList<Hero>();
                request.session().attribute("heroes", heroes);
            }

            String jina = request.queryParams("jina");
            int miaka = Integer.parseInt(request.queryParams("miaka"));
            String strength = request.queryParams("strength");
            String weakness = request.queryParams("weakness");

            Hero newHero = new Hero(jina,miaka,strength,weakness);
            heroes.add(newHero);

            model.put("template", "template/successful.vtl");
            return new ModelAndView(model, layout);
        }), new VelocityTemplateEngine());

    }
}