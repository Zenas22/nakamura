import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.apache.velocity.app.Velocity;
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

            model.put("template", "templates/successful.vtl");
            return new ModelAndView(model, layout);
        }), new VelocityTemplateEngine());

        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
            model.put("heroes", hero);
            model.put("template", "templates/hero.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/squad-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String squadName = request.queryParams("squadName");
            int size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");

            Squad newSquad = new Squad(squadName,size,cause);
            model.put("template", "templates/success-squad.vtl");

            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", Squad.getSquads());
            model.put("template", "templates/squads.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squad.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}