package org.danekja.edu.pia.domain;

import java.io.Serializable;

/**
 * Base class for data objects. Enforces implementation of
 * equals(), hashCode() and toString() methods, thus ensuring
 * developers don't forget to implement them.
 *
 * Is serializable.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public abstract class BaseObject implements Serializable {

    @Override
    public abstract boolean equals(Object object);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
