package com.springapp.mvc;

import com.springapp.dao.FileDaoFactory;
import com.springapp.dao.GenericDao;
import com.springapp.dao.file.ListItemDao;
import com.springapp.entities.Identified;
import com.springapp.entities.ListItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.logging.Logger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    private static final Logger LOG = Logger.getLogger(AppTests.class.getName());
/**
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }
*/
    @Test
    public void crudFile()  throws Exception {
        GenericDao<Identified<Integer>, Integer> listDao = new FileDaoFactory().getDao(ListItem.class);
        assert(listDao.findAll() != null);
        LOG.info(listDao.findAll().toString());
        LOG.info(listDao.find(2).toString());
        listDao.update(new ListItem(2, "5"));
        LOG.info(listDao.find(2).toString());
        listDao.remove(new ListItem (6,"6"));
        LOG.info(listDao.findAll().toString());
    }
}
