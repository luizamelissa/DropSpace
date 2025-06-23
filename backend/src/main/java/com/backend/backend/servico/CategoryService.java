
package com.backend.backend.servico;

import com.backend.backend.model.Category;
import com.backend.backend.repository.CategoryRepository;
import com.backend.backend.exception.ResourceNotFoundException;
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

    public Category buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria com ID " + id + " não encontrada"));
    }
}
