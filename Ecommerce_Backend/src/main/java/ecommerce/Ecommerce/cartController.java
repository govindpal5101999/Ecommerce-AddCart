package ecommerce.Ecommerce;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class cartController {

	@Autowired
	cartRepository cartRepo;
	
	@PostMapping("/cartList")
	public cartModel createData (@RequestParam("file") MultipartFile image, @RequestParam("datalist") String datalist) throws JsonParseException , JsonMappingException, Exception{
		
		cartModel product = new ObjectMapper().readValue(datalist, cartModel.class);
		byte[] fileName = image.getBytes();
		product.setPicByte(fileName);
		return cartRepo.save(product);
	}
	
	@GetMapping("/cartList")
	public List<cartModel> getAll(){
		return cartRepo.findAll();
	}
	
	@GetMapping("/cartList/{id}")
	public ResponseEntity<cartModel> getCartById(@PathVariable("id") Integer id){
		Optional<cartModel> product = cartRepo.findById(id);
		
		if(product.isPresent()) {
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
