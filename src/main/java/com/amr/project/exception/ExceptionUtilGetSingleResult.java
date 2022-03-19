package com.amr.project.exception;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ExceptionUtilGetSingleResult {

    public static Object getSingleResultOrNull(Query query) {
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (Exception exp) {
            throw exp;
        }
    }

    public static <T> T getSingleResult(TypedQuery<T> query) {
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (Exception exp) {
            throw exp;
        }
    }
}
