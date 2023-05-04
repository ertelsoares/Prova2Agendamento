/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import model.Equipe;

/**
 *
 * @author ertel
 */
public class EquipeDao extends GenericDAO<Equipe> implements Serializable {
    
    
    
    public Equipe findById(int id) {
        for (Equipe e : lista) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    
}
