import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method(POST())
        url("payments/create")
        body("12345-abcdefg")
    }

    response {
        status(OK())
        body("Created new payment with id: [12345-abcdefg]")
    }
}
