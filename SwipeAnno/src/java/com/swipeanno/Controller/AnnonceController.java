package com.swipeanno.Controller;

import com.swipeanno.entities.Annonce;
import com.swipeanno.Controller.util.JsfUtil;
import com.swipeanno.Controller.util.PaginationHelper;
import com.swipeanno.Facades.AnnonceFacade;
import com.swipeanno.entities.Users;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("annonceController")
@SessionScoped
public class AnnonceController implements Serializable {

    private Annonce current;
    private DataModel items = null;
    @EJB
    private com.swipeanno.Facades.AnnonceFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private Users authUser;
    
    public void display(Object o) {
        System.out.println(o.toString());
    }

    public AnnonceController() {
    }

    public Annonce getSelected() {
        if (current == null) {
            current = new Annonce();
            selectedItemIndex = -1;
        }
        return current;
    }

    public Users getAuthUser() {
        return this.authUser;
    }

    public void setAuthUser(Users user) {
        this.authUser = user;
    }

    private AnnonceFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Annonce) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }
    
    public String prepareView(Annonce annonce, int a) {
        current =annonce;
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        switch (a) {
                case 0:
                   return "View";
                case 1:
                    return "/other/View";
                default:
                    return "View";
            }
    }

    public String prepareCreate() {
        current = new Annonce();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create(int a) {
        try {
            current.setAnnonceUserId(authUser);
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            current.setAnnoncedateParution(date);
            
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AnnonceCreated"));
           switch (a) {
                case 0:
                    return prepareCreate();
                case 1:
                    return "/other/createAnnonce";
                default:
                    return prepareCreate();
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Annonce) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }
    
     public String prepareEdit(Annonce annonce, int a) {
        current =annonce;
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        switch (a) {
                case 0:
                   return "Edit";
                case 1:
                    return "/other/Edit";
                default:
                    return "Edit";
            }
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AnnonceUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Annonce) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }
    
     public String destroy(Annonce annonce, int a) {
        current = annonce;
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
         switch (a) {
                case 0:
                   return "List";
                case 1:
                    return "/index";
                default:
                    return "List";
            }
    }
    

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AnnonceDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }
    
    public String next(int a) {
         getPagination().nextPage();
        recreateModel();
        return "/other/viewAnnonceUser";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }
     public String previous(int a) {
        getPagination().previousPage();
        recreateModel();
        return "/other/viewAnnonceUser";
    }
    

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }
    
    public SelectItem[] getItemsAvailableSelectManyMe(int id) {
        return JsfUtil.getSelectItems(ejbFacade.findForUser(id), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Annonce getAnnonce(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Annonce.class)
    public static class AnnonceControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AnnonceController controller = (AnnonceController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "annonceController");
            return controller.getAnnonce(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Annonce) {
                Annonce o = (Annonce) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Annonce.class.getName());
            }
        }

    }

}
