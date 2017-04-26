/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swipeanno.Facades;

import com.swipeanno.entities.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cyriljeanneret
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "SwipeAnnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    
    public void addRoleUser(Users user, String rolename){
    Query query = em.createNativeQuery("INSERT INTO users_groups (login_name, group_name)"+"Values(?,?)");
    query.setParameter(1, user.getLoginName());
    query.setParameter(2, rolename);
    query.executeUpdate();
    }
    
    public Users findUserByName(String name) {
    Query users = em.createNamedQuery("Users.findByName").setParameter("login_name", name);
    return (Users) users.getSingleResult();
}
}
