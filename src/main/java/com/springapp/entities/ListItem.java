package com.springapp.entities;

/**
 * Created by Volodymyr Bodnar on 04.02.2015.
 */
public class ListItem implements Identified<Integer> {

    /**Unified identifier*/
    private Integer id;

    /**String value of the List Item*/
    private String value;

    public ListItem(){};

    public ListItem(String value){
        this.value = value;
    };

    public ListItem(Integer id, String value){
        this.id = id;
        this.value = value;
    };

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListItem listItem = (ListItem) o;

        if (!id.equals(listItem.id)) return false;
        if (value != null ? !value.equals(listItem.value) : listItem.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return value;
    }
}
