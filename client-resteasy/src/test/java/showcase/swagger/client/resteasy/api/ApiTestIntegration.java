package showcase.swagger.client.resteasy.api;

import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;
import showcase.swagger.client.resteasy.ApiException;
import showcase.swagger.client.resteasy.model.Customer;

import static org.junit.Assert.assertEquals;

public class ApiTestIntegration {

    private static DefaultApi api = new DefaultApi();

    @BeforeClass
    public static void init() {
        api.getApiClient().setBasePath("http://localhost:9000");
    }

    @Test
    public void testSaveAndGet() throws ApiException {
        Long id = saveCustomer().getId();
        Customer customer = getCustomer(id);

        assertEquals(id, customer.getId());
        assertEquals(1L, customer.getCooperationPartnerId().longValue());
        assertEquals("X", customer.getCustomerType());
        assertEquals("Y", customer.getDispatchType());
    }

    private static Customer saveCustomer() throws ApiException {
        Customer customer = new Customer().cooperationPartnerId(1L).registrationDate(DateTime.now()).customerType("X").dispatchType("Y");
        return api.saveCustomer(customer);
    }

    private static Customer getCustomer(Long id) throws ApiException {
        return api.getCustomer(id);
    }
}
