/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Piece;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface PieceFacadeLocal {

    void create(Piece piece);

    void edit(Piece piece);

    void remove(Piece piece);

    Piece find(Object id);

    List<Piece> findAll();

    List<Piece> findRange(int[] range);

    int count();
    
}
