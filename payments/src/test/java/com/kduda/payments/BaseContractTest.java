package com.kduda.payments;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

class BaseContractTest {
    @Before
    public void setup() {
        // mock
        final PaymentsService service = new PaymentsService();
        RestAssuredMockMvc.standaloneSetup(new PaymentsController(service));
    }
}
