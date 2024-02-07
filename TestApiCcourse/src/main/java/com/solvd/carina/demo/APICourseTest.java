package com.solvd.carina.demo;

import com.solvd.carina.demo.api.products.DeleteProduct;
import com.solvd.carina.demo.api.products.GetProduct;
import com.solvd.carina.demo.api.products.PostProduct;
import com.solvd.carina.demo.api.products.PutProduct;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

public class APICourseTest implements IAbstractTest {
    @Test
    @MethodOwner(owner ="Lucas")
    public void getProductTest(){
        GetProduct getProduct = new GetProduct();
        getProduct.callAPIExpectSuccess();
        Response response = getProduct.callAPIExpectSuccess();
        getProduct.validateResponseAgainstSchema("api/products/_get/rs.schema");
        System.out.println("#####" + JsonPath.from(response.asString()).getString("description"));
    }
    @Test
    @MethodOwner(owner= "Lucas")
    public void postProductTest(){
        PostProduct postProduct = new PostProduct();
        api.setProperties("api/products/product.properties.txt");
        postProduct.callAPIExpectSuccess ();
        postProduct.validateResponse();
    }
    @Test
    @MethodOwner(owner="Lucas")
    public void deleteProductTest(){
        DeleteProduct deleteProduct = new DeleteProduct();
        api.setProperties("api/products/product.properties.txt");
        deleteProduct.callAPIExpectSuccess ();
        deleteProduct.validateResponse();
    }
    @Test
    @MethodOwner(owner= "Lucas")
    public void putProductTest(){
        PutProduct putProduct = new PutProduct();
        api.setProperties("api/products/product.properties.txt");
        putProduct.callAPIExpectSuccess ();
        putProduct.validateResponse();
    }
}
