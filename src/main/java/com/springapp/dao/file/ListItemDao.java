package com.springapp.dao.file;

import com.springapp.dao.GenericDao;
import com.springapp.dao.PersistException;
import com.springapp.entities.ListItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Volodymyr Bodnar on 04.02.2015.
 *
 * DAO class to manage persistence state of ListItem entity
 */
public class ListItemDao implements GenericDao<ListItem, Integer> {

    private static final  Logger LOG = Logger.getLogger(ListItemDao.class.getName());

    /** Path to persistence file */
    private static final String PATH_TO_PERSISTENCE_FILE = ListItemDao.class.getResource("/storage.dat").getPath();

    /** List of Items from file */
    private static List<ListItem> itemsList;

    /** File size at the time of last reading */
    private static Long  fileSize;

    {
        LOG.info("Path to persistence storage: " + PATH_TO_PERSISTENCE_FILE);
    }

    //TODO make synchronisation
    //TODO find method for partial writing of file

    @Override
    public void create(ListItem object) throws PersistException {
        itemsList.add(object);
        writeFile();
    }

    @Override
    public void update(ListItem object) throws PersistException {
        itemsList.set(object.getId()-1, object);
        writeFile();
    }

    @Override
    public void remove(ListItem object) throws PersistException {
        itemsList.remove(object);
        writeFile();
    }

    @Override
    public void removeAll() throws PersistException {
        itemsList = new ArrayList<ListItem>();
        writeFile();
    }

    @Override
    public ListItem find(Integer key) throws PersistException {
        //Updating itemList if file was modified
        if (itemsList == null || isModified()) readFile();
        return itemsList.get(key-1);
    }

    @Override
    public List<ListItem> findAll() throws PersistException {
        LOG.info("findAll");
        //Updating itemList if file was modified
        if (itemsList == null || isModified()) readFile();
        return itemsList;
    }

    /** Reading the whole file */
    private void readFile() throws PersistException{
        LOG.info("Start of file reading");
        List<ListItem> itemsList = new ArrayList<ListItem>();
        //Set size of the file
        fileSize = new File(PATH_TO_PERSISTENCE_FILE).length();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_PERSISTENCE_FILE)))
        {
            String sCurrentLine;
            Integer id=1;
            while ((sCurrentLine = br.readLine()) != null) {
                itemsList.add(new ListItem(id, sCurrentLine));
                id++;
            }

        } catch (IOException e) {
            throw new PersistException(e);
        }
        LOG.info("End of file reading");
        this.itemsList = itemsList;
    }

    /** Writing the whole file */
    private void writeFile() throws PersistException{
        LOG.info("Start of file writing");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_TO_PERSISTENCE_FILE)))
        {
            for (ListItem item : itemsList){
                bw.write(item.getValue()+"\n");
            }

        } catch (IOException e) {
            throw new PersistException(e);
        }
        LOG.info("End of file writing");
    }

    /** Checking if the file was modified (checking by size)*/
    private boolean isModified(){
        if (fileSize == null)
            return true;
        else{
            return !fileSize.equals(new File(PATH_TO_PERSISTENCE_FILE).length());
        }
    }
}
