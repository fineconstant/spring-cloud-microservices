import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method(GET())
        url("/payments/upcoming")
    }
    response {
        status(OK())
        body("Upcoming feature")
    }
}
