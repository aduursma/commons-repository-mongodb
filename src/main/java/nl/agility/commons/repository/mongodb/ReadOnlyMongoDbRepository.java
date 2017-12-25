package nl.agility.commons.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface ReadOnlyMongoDbRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {

    @Override
    @RestResource(exported = false)
    <S extends T> List<S> save(Iterable<S> entites);

    @Override
    @RestResource(exported = false)
    <S extends T> S insert(S entity);

    @Override
    @RestResource(exported = false)
    <S extends T> List<S> insert(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    <S extends T> S save(S entity);

    @Override
    @RestResource(exported = false)
    void delete(ID id);

    @Override
    @RestResource(exported = false)
    void delete(T entity);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends T> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
