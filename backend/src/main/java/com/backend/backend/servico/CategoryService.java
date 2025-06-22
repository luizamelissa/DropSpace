package com.backend.backend.servico;

import com.backend.backend.modelo.Category;
import com.backend.backend.repositorio.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category salvar(Category category) {
        return repo.save(category);
    }

    public List<Category> listar() {
        return repo.findAll();
    }
}
