package com.capgemini.services;

import java.util.List;

import com.capgemini.entites.Mechanics;
import com.capgemini.exception.MechanicsException;

public interface IMechanicsServices {
public String createMechanic(Mechanics mechanics)throws MechanicsException;
public String updateMechanic(Mechanics mechanics) throws MechanicsException;
public Mechanics findMechanicById(int id) throws MechanicsException;
public List<Mechanics> findMechanics();
public String deleteMechanic(int id) throws MechanicsException;
}
