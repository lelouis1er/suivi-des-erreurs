/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.converter;

import entities.Application;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "applicationConverter")
public class ApplicationConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ValueExpression valueExpression = context.getApplication()
                .getExpressionFactory()
                .createValueExpression(context.getELContext(), "#{superConverter}", SuperConverter.class);

        SuperConverter converter = (SuperConverter) valueExpression.getValue(context.getELContext());

        return converter.find_appli_in_list_appli(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Integer id = ((Application) value).getIdappli();

            if (id != null) {
                return id.toString();
            }

        }

        return "";
    }

}
