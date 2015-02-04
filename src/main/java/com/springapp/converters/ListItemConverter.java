package com.springapp.converters;

import com.springapp.entities.ListItem;

import java.util.List;

/**
 * Created by Volodymyr Bodnar on 04.02.2015.
 */
public class ListItemConverter {

        private List<ListItem> listItems;

        public List<ListItem> getListItems() {
            return listItems;
        }

        public void setListItems(List<ListItem> listItems) {
            this.listItems = listItems;
        }
    }