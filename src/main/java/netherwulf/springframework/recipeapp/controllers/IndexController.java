package netherwulf.springframework.recipeapp.controllers;

import netherwulf.springframework.recipeapp.domain.Category;
import netherwulf.springframework.recipeapp.domain.UnitOfMeasure;
import netherwulf.springframework.recipeapp.repositories.CategoryRepository;
import netherwulf.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;


    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex(Model model){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category Id: " + categoryOptional.get().getId());
        System.out.println("Unit of Measure Id: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
