package se.lexicon.formbinding_practice.converter;

import java.util.Collection;

public interface Converter<T, U> {
    T toModel(U dto);
    U toDTO(T model);
    Collection<T> toModels(Collection<U> collection);
    Collection<U> toDTOs(Collection<T> collection);
}
