/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.airtable;

import com.sybit.airtable.exception.AirtableException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author fzr
 */
public class BaseTest {
    
    private Airtable airtable;
    
    @Before
    public void before() throws AirtableException{
    
        this.airtable = new Airtable().configure(new Configuration("123","url",null));
        
        
    }
    
    @Test
    public void baseTest(){
    
        Base base = new Base("base", this.airtable);
        assertNotNull(base);        
    }
    
    
    @Test
    public void airtableTest(){
    
        Base base = new Base("base", this.airtable);
        assertEquals(base.airtable(),this.airtable);
    }
    
    @Test
    public void baseNameTest(){
        
        Base base = new Base("base", this.airtable);
        assertEquals(base.name(),"base");
    }

    @Test(expected = java.lang.AssertionError.class )
    public void baseAssertationTest() {
        Base base = new Base(null,null);
    }
    
}