/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.converter;

import entities.Gravite;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



/**
 *
 * @author Lafortune
 */
@FacesConverter (value = "graviteConverter")
public class GraviteConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ValueExpression valueExpression = context.getApplication()
                .getExpressionFactory()
                .createValueExpression(context.getELContext(), "#{superConverter}", SuperConverter.class);
        SuperConverter converter =(SuperConverter) valueExpression.getValue(context.getELContext());
        return converter.find_gravite_in_list_gravite(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
           Integer id = ((Gravite)value).getIdgravite();
           if (id != null){
               return id.toString();
           }
        }
        return "";
    }
    
    
}