package de.nordakademie.flxplzk.transferleistungangular.service;

import com.google.common.collect.Lists;
import de.nordakademie.flxplzk.transferleistungangular.domain.RestResource;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class CrudService<T extends RestResource> {

    private final CrudRepository<T, Long> crudRepository;

    public CrudService(CrudRepository<T, Long> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public T save(final T model) {
        return this.crudRepository.save(model);
    }

    public void delete(final long id) {
        final T model = this.crudRepository.findOne(id);
        model.setActive(false);
        this.crudRepository.save(model);
    }

    public List<T> findAll() {
        return Lists.newArrayList(this.crudRepository.findAll());
    }

    public List<T> findAllActive() {
        return Lists.newArrayList(this.crudRepository.findAll())
                .stream()
                .filter(RestResource::isActive)
                .collect(Collectors.toList());
    }
}
