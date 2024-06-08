package fca.suayed.dal;

import java.util.List;

import org.jboss.logging.Logger;
import org.jdbi.v3.core.Jdbi;

import fca.suayed.dao.StoreDao;
import fca.suayed.dto.ClientDto;
import fca.suayed.dto.ProductDto;
import fca.suayed.dto.ResponseDto;
import fca.suayed.services.JdbiService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class StoreDal {

    private static final Logger LOGGER = Logger.getLogger(StoreDal.class);

    @Inject
    JdbiService jdbiService;

    public ResponseDto<List<ProductDto>> getProducts() {

        ResponseDto responseDto = new ResponseDto<List<ProductDto>>();
        responseDto.setSuccess(true);
        Jdbi jdbi = jdbiService.getInstance();
        var products = jdbi.withExtension(StoreDao.class, dao -> dao.getProducts());
        responseDto.setData(products);
        return responseDto;
    }

    public ResponseDto<String> addProduct(final ProductDto productDto) {

        ResponseDto responseDto = new ResponseDto<String>();
        responseDto.setSuccess(false);

        Jdbi jdbi = jdbiService.getInstance();
        jdbi.useExtension(StoreDao.class, dao -> {
            dao.addProduct(productDto);
            responseDto.setSuccess(true);
            responseDto.setData("ok");
        });

        return responseDto;
    }

    public ResponseDto<List<ClientDto>> getClient() {

        ResponseDto responseDto = new ResponseDto<List<ClientDto>>();
        responseDto.setSuccess(true);
        Jdbi jdbi = jdbiService.getInstance();
        var client = jdbi.withExtension(StoreDao.class, dao -> dao.getClient());
        responseDto.setData(client);
        return responseDto;
    }
}
