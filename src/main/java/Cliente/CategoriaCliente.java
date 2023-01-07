package Cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Categoria;

@FeignClient(name="categorias", url="localhost:8081")
public interface CategoriaCliente {
	  @GetMapping("/categorias")
	    public List<Categoria> listar();
	  
	  @PostMapping("/categorias")
	    public  Categoria guardar(@RequestBody Categoria categoria);
	  
	  @GetMapping("/categorias/{id}")
	    public Categoria getUnaCategoria(@PathVariable Integer id_categoria);
	  
	   @PutMapping("/categorias/{id}")
	    public Categoria modifecar(@RequestBody Categoria categoria,@PathVariable Integer id_categoria);
	   

	    @DeleteMapping("/categorias/{id}")
	    public void eliminar(@PathVariable Integer id_categoria);
}
