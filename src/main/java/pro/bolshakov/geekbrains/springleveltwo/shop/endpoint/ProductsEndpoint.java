package pro.bolshakov.geekbrains.springleveltwo.shop.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.ProductDto;
import pro.bolshakov.geekbrains.springleveltwo.shop.service.ProductService;
import pro.bolshakov.geekbrains.springleveltwo.shop.ws.products.GetProductsRequest;
import pro.bolshakov.geekbrains.springleveltwo.shop.ws.products.GetProductsResponse;
import pro.bolshakov.geekbrains.springleveltwo.shop.ws.products.ProductWS;

import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class ProductsEndpoint {

    public static final String NAMESPACE_URL = "http://bolshakov.pro/geekbrains/springleveltwo/shop/ws/products";

    private final ProductService productService;

    public ProductsEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getGreeting(@RequestPayload GetProductsRequest request)
            throws DatatypeConfigurationException {
        GetProductsResponse response = new GetProductsResponse();
        productService.getAll()
                .forEach(dto -> response.getProducts().add(createProductWS(dto)));
        return response;
    }

    private ProductWS createProductWS(ProductDto dto){
        ProductWS ws = new ProductWS();
        ws.setId(dto.getId());
        ws.setPrice(dto.getPrice());
        ws.setTitle(dto.getTitle());
        return ws;
    }
}
