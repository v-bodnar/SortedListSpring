package com.springapp.mvc;

import com.springapp.dao.FileDaoFactory;
import com.springapp.dao.GenericDao;
import com.springapp.dao.PersistException;
import com.springapp.entities.ListItem;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HelloController {

    private static final Logger LOG = Logger.getLogger(HelloController.class.getName());
    private static GenericDao<ListItem, Integer> itemsDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("title", "Awesome List!");

        try {
            if (itemsDao == null)
                itemsDao = new FileDaoFactory().getDao(ListItem.class);
            model.addAttribute("items", itemsDao.findAll());
        } catch (PersistException e) {
            LOG.severe(e.getMessage());
        }

        return "hello";
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "content-type=application/x-www-form-urlencoded")
    @ResponseBody
    public String saveList(HttpServletRequest request) {
        //Getting params sent by ajax call
        String items[] = request.getParameterValues("listItems[]");

        //getting dao
        try {
            if (itemsDao == null)
                itemsDao = new FileDaoFactory().getDao(ListItem.class);
        } catch (PersistException e) {
            LOG.severe(e.getMessage());
        }

        //If no params were sent or array is null
        if (items == null) {
            try {
                itemsDao.removeAll();
            } catch (PersistException e) {
                LOG.severe(e.getMessage());
            }
        }else {

            //Cleaning file and writing to file
            List<ListItem> listItems = new ArrayList<ListItem>();
            Integer id = 1;
            for (String value : items) {
                listItems.add(new ListItem(id, value));
                id++;
            }

            try {
                itemsDao.removeAll();
                for (ListItem item : listItems)
                    itemsDao.create(item);
            } catch (PersistException e) {
                LOG.severe(e.getMessage());
            }
        }
        return "200";
    }


}