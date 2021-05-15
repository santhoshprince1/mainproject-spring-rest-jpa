package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entites.Mechanics;
import com.capgemini.exception.MechanicsException;
import com.capgemini.services.MechanicsServicesImpl;

@RestController
@RequestMapping("/api/mechanic")
public class MechanicsController {
@Autowired
private MechanicsServicesImpl mechanicServices;

@PostMapping("/")
public ResponseEntity<String> createMechanic(@RequestBody Mechanics mechanics) throws MechanicsException {
	
	mechanicServices.createMechanic(mechanics);
	return new ResponseEntity<>("Mechanic is Created", HttpStatus.OK);
}
@PutMapping("/")
public ResponseEntity<String> updateMechanic(@RequestBody Mechanics mechanics) throws MechanicsException {
	
	mechanicServices.updateMechanic(mechanics);
	return new ResponseEntity<>("Mechanic is Updated", HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<Mechanics> findMechanicById(@PathVariable int id) throws MechanicsException {
	Mechanics mechanic=mechanicServices.findMechanicById(id);
	return new ResponseEntity<>(mechanic, HttpStatus.OK);
}
@GetMapping("/")
public ResponseEntity<List<Mechanics>> findMechanics(@PathVariable int id) throws MechanicsException {
	List<Mechanics> mechanic=mechanicServices.findMechanics();
	return new ResponseEntity<>(mechanic, HttpStatus.OK);
}
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteMechanicById(@PathVariable int id) throws MechanicsException{
	mechanicServices.deleteMechanic(id);
	return new ResponseEntity<>("Mechanic was deleted", HttpStatus.OK);
}
}
