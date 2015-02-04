package com.springapp.entities;

import java.io.Serializable;

/**
 * Created by Volodymyr Bodnar on 04.02.2015.
 * Identified object interface
 */
public interface Identified<PK extends Serializable> {
    /**
     * Returns unique object identifier
     */
    public PK getId();

}

