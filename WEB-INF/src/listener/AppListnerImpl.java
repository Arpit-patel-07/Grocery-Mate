package listener;

import java.util.ArrayList;

import models.Category;
import models.City;
import models.PicType;
import models.WeightType;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListnerImpl  implements ServletContextListener{
    
    public void contextInitialized(ServletContextEvent event){

        ServletContext context = event.getServletContext();

        ArrayList<Category> categories = Category.collectAllCategory();

        ArrayList<City> cities = City.collectAllCities();

        ArrayList<PicType> pics = PicType.collectAllPicType();

        ArrayList<WeightType> weightTypes = WeightType.collectAllWeightTypes();

        context.setAttribute("cities", cities);
        context.setAttribute("categories", categories);
        context.setAttribute("pics", pics);
        context.setAttribute("weights", weightTypes);
    }
}
