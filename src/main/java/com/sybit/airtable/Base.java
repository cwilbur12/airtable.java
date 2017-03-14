package com.sybit.airtable;

import com.sybit.airtable.vo.Records;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
class Base {

    private Map<String, Table> tableMap = new HashMap<>();

    private String base;

    private Airtable parent;

    /**
     *
     * @param base
     */
    public Base(String base) {
        this.base = base;
    }

    /**
     *
     * @param parent
     */
    void setParent(Airtable parent) {
        this.parent = parent;
    }

    /**
     *
     * @return
     */
    Airtable airtable() {
        return parent;
    }

    /**
     *
     * @param name
     * @return
     */
    public Table table(String name) {

        return table(name, Records.class);
    }

    /**
     *
     * @param name
     * @param clazz
     * @return
     */
    public Table table(String name, Class clazz) {

        if(!tableMap.containsKey(name)) {
            Table t = new Table(name, clazz);
            t.setParent(this);
            tableMap.put(name, t);
        }

        return  tableMap.get(name);
    }

    /**
     *
     * @return
     */
    public String name() {
        return base;
    }
}