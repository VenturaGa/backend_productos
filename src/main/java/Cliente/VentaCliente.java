package Cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Venta;

@FeignClient(name="ventas", url="localhost:8081")
public interface VentaCliente {
	 @GetMapping("/ventas")
	    public List<Venta> listar();
}
