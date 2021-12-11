package ma.wiebatouta.restcontroller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.wiebatouta.exceptions.AddUnsatisfiedException;
import ma.wiebatouta.exceptions.DataEmptyException;
import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Hotel;
import ma.wiebatouta.repositories.HotelRepository;

@RestController
@RequestMapping("/api/hotel")
@CrossOrigin("*")
public class HotelRestController {

	@Autowired
	private HotelRepository hotelRepository;

	@PostMapping
	@RolesAllowed("ADMIN")
	public HttpEntity<?> addHotel(@Valid @RequestBody Hotel hotel, Errors error) throws AddUnsatisfiedException {
		if (error.hasErrors()) {
			List<ObjectError> errors = error.getAllErrors();
			AddUnsatisfiedException exception = new AddUnsatisfiedException();
			for (ObjectError objectError : errors) {
				exception.getErrors().put(objectError.getObjectName(), objectError.getDefaultMessage());
			}
			throw exception;
		}
		hotel.setId(null);
		hotelRepository.save(hotel);
		return ResponseEntity.ok(hotel);
	}

	@PutMapping
	@RolesAllowed("ADMIN")
	public HttpEntity<?> editHotel(@Valid @RequestBody Hotel hotel, Errors error) throws AddUnsatisfiedException {
		if (error.hasErrors()) {
			List<ObjectError> errors = error.getAllErrors();
			AddUnsatisfiedException exception = new AddUnsatisfiedException();
			for (ObjectError objectError : errors) {
				exception.getErrors().put(objectError.getObjectName(), objectError.getDefaultMessage());
			}
			throw exception;
		}
		hotelRepository.save(hotel);
		return ResponseEntity.ok(hotel);
	}

	@DeleteMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> deleteCatalog(@RequestParam("id") Long id) throws NotFoundException {
		Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not found"));
		hotelRepository.delete(hotel);
		return ResponseEntity.accepted().build();
	}

	@GetMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> findCatalogs(@RequestParam(name = "id", required = false) Long id)
			throws DataEmptyException, NotFoundException {
		List<Hotel> hotels = hotelRepository.findAll();
		if (hotels.size() == 0) {
			throw new DataEmptyException("The list of catalogs is empty");
		} else {
			if (id != null) {
				Hotel hotel = hotelRepository.findById(id)
						.orElseThrow(() -> new NotFoundException("The id is not found"));
				return ResponseEntity.ok(hotel);
			} else {
				return ResponseEntity.ok(hotels);
			}
		}

	}
}
