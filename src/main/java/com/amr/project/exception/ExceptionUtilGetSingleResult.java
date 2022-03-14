package com.amr.project.exception;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class ExceptionUtilGetSingleResult {

    public static Object getSingleResultOrNull(Query query) {
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException exp) {
            throw exp;
        }
    }

    public static <T> Optional<T> getOptionalResult(TypedQuery<T> query) {
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        } catch (NonUniqueResultException exp) {
            throw exp;
        }
    }
}
