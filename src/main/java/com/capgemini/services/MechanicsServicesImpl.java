package com.capgemini.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entites.Mechanics;
import com.capgemini.exception.MechanicsException;
import com.capgemini.repository.MechanicsRepository;
@Service
public class MechanicsServicesImpl  implements IMechanicsServices{
    @Autowired
	private MechanicsRepository mechanicsRepository;
	@Override
	public String createMechanic(Mechanics mechanics) throws MechanicsException {
		if(mechanics.getMechanicsAge()<18 && mechanics.getMechanicsAge()>60) {
			throw new MechanicsException("Age is invalid");
		}
		if(!mechanics.getMechanicsMobile().matches("[6-9][0-9]{9}")) {
			throw new MechanicsException("mobile number is invalid");
		}
		if(!mechanics.getMechanicsName().matches("[A-Za-z ]+")) {
			throw new MechanicsException("name is invalid");
		}
		mechanicsRepository.save(mechanics);
		return "Mechanic is Created";
	}

	@Override
	public String updateMechanic(Mechanics mechanics) throws MechanicsException {
		if(!mechanicsRepository.existsById(mechanics.getMechanicsId())) {
			throw new MechanicsException("Mechanic Not Found");
		}
		else {
			Mechanics OldMechanic=mechanicsRepository.findById(mechanics.getMechanicsId()).get();
			if(mechanics.getMechanicsName()!=null) {
				if(!mechanics.getMechanicsName().matches("[A-Za-z ]+")) {
					throw new MechanicsException("name is invalid");
				}
			OldMechanic.setMechanicsName(mechanics.getMechanicsName());
			}
			if(mechanics.getMechanicsMobile()!=null) {
				if(!mechanics.getMechanicsMobile().matches("[6-9][0-9]{9}")) {
					throw new MechanicsException("mobile number is invalid");
				}
			OldMechanic.setMechanicsMobile(mechanics.getMechanicsMobile());
			}
			if(mechanics.getMechanicsAge()!=0){
			if(mechanics.getMechanicsAge()<18 && mechanics.getMechanicsAge()>60) {
				throw new MechanicsException("Age is not valid");
			}
			else {
				OldMechanic.setMechanicsAge(mechanics.getMechanicsAge());
			}
		}
			mechanicsRepository.save(OldMechanic);
		}
		return "Mechanic is Updated";
	}

	@Override
	public Mechanics findMechanicById(int id) throws MechanicsException{
		if(mechanicsRepository.existsById(id)) {
			throw new MechanicsException("Mechanic Not Found");
		}
		return mechanicsRepository.findById(id).get();
	}

	@Override
	public String deleteMechanic(int id) throws MechanicsException {
		if(mechanicsRepository.existsById(id)) {
			throw new MechanicsException("Mechanic Not Found");
		}
		Mechanics mechanic=mechanicsRepository.findById(id).get();
		mechanicsRepository.delete(mechanic);
		return "Mechanic was deleted";
	}

	@Override
	public List<Mechanics> findMechanics() {
		return mechanicsRepository.findAll();
	}

}
