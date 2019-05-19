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
            model.put("template", index);
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}