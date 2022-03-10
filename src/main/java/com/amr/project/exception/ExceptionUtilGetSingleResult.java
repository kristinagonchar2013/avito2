package com.amr.project.exception;

import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;

public class ExceptionUtilGetSingleResult {

    public static Object getSingleResultOrNull(Query query){
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        else if (results.size() == 1) {
            return results.get(0);
        }
        throw new NonUniqueResultException();
    }
}
