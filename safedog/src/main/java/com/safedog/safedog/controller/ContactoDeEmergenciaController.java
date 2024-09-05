package com.safedog.safedog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.safedog.safedog.model.ContactoDeEmergencia;
import com.safedog.safedog.service.ContactoDeEmergenciaService;

@RestController
@RequestMapping("/api/safedog/Contacto_Emergencia")
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST})
public class ContactoDeEmergenciaController {
	
	private ContactoDeEmergenciaService contactoDeEmergenciaService;
	
	@Autowired
	public ContactoDeEmergenciaController (ContactoDeEmergenciaService contactoDeEmergenciaService) {
		this.contactoDeEmergenciaService = contactoDeEmergenciaService;
	}
	
	@GetMapping("/listado")
	public List< ContactoDeEmergencia> getMappingAll(){
		return contactoDeEmergenciaService.getMappingAll();
	}
	
	 // Endpoint to get the last ID
    @GetMapping("/lastId")
    public ResponseEntity<Long> getLastId() {
        Long lastId = contactoDeEmergenciaService.getLastId();
        if (lastId == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // or HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(lastId, HttpStatus.OK);
    }
	
	@PostMapping
	public ContactoDeEmergencia newContactoDeEmergencia(@RequestBody ContactoDeEmergencia contactoDeEmergencia) {
		return contactoDeEmergenciaService.createContactoDeEmergencia(contactoDeEmergencia);
	}
	
}
