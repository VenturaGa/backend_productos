package Cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Producto;

@FeignClient(name="productos", url="localhost:8081")
public interface ProductoCliente {

	@GetMapping ("/producto")
	public List<Producto> listar();
	
    @GetMapping("/productos/{id}")
    public Producto getUnProducto(@PathVariable Integer id_producto);
    
    
    @PostMapping("/productos")
    public  Producto guardar(@RequestBody Producto producto);
    
    @PutMapping("/productos/{id}")
    public Producto modifecar(@RequestBody Producto producto,@PathVariable Integer id_producto);
    
    @DeleteMapping("/productos/{id}")
    public void eliminar(@PathVariable Integer id_producto);
    
} 

